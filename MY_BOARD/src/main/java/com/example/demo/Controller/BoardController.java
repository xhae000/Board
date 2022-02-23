package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Common.Paging;
import com.example.demo.Mapper.BoardMapper;

@Controller
public class BoardController {

	@Autowired
	private BoardMapper boardMapper;
    private static final Logger LOGGER  = LogManager.getLogger(BoardController.class);
	
	@RequestMapping("/")
	public String index(Model model,Principal pri,Authentication auth) {
		if(auth==null) LOGGER.info("비회원 입니다.");
		else LOGGER.info("현재 접속 계정의 아이디/권한 : "+auth.getName()+"/"+auth.getAuthorities());
		
		Paging p = new Paging();
		
		model.addAttribute("totalPageCount",
				p.getTotalPageCount(boardMapper.getArticleCount()));
		model.addAttribute("keword","woojin");	
		model.addAttribute("articles",boardMapper.getArticleLists(0));
		
				
		return "/index";
	}

	@RequestMapping(value = "/write" ,method=RequestMethod.GET)
	public String write() {
		return "/write";
	}
	
	@RequestMapping(value = "/writeProccess", method=RequestMethod.POST)
	public String writeProcess(@ModelAttribute("file")MultipartFile file,@ModelAttribute("title") String title,
			@ModelAttribute("description")String des) throws IllegalStateException, IOException {
		
		//validation 

		if(!file.isEmpty()) {
			File newFile = new File(UUID.randomUUID().toString()+"_"+file.getOriginalFilename());
				file.transferTo(newFile);
		}		
		
		
		return "redirect:/"; //쓴 글로 이동하게
	}

}


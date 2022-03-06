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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Common.Paging;
import com.example.demo.DTO.Article;
import com.example.demo.DTO.User;
import com.example.demo.Mapper.BoardMapper;
import com.example.demo.Mapper.UserMapper;

@Controller
public class BoardController {

	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private UserMapper userMapper;
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
			@ModelAttribute("description")String des, Principal pri) throws IllegalStateException, IOException {
		String filename = "no-image";
		
		if(title.length()>20||des.length()>1100)
			return "redirect:/";
		
		if(!file.isEmpty()) {
			filename = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
			File newFile = new File(filename);
			file.transferTo(newFile);
			filename="/image/"+filename;
		}		
		
		User user = userMapper.getUserInfo(pri.getName());
		Article article =new Article(user.getId(),user.getNickname(),
				title,des,user.getImage(),filename);
		
		
		boardMapper.createArticle(article);
		
		return "redirect:/"; //쓴 글로 이동하게
	}

	@RequestMapping(value="/article/{id}")
	public String article(@PathVariable int id,Model model) {
		Article article = boardMapper.getArticle(id);
		model.addAttribute("article",article);
		model.addAttribute("commentCount",boardMapper.getCommentCount(id));
		model.addAttribute("comments",boardMapper.getCommentLists(0));
		
		boardMapper.plusSee(id);
		return "/article";
	}
	
}


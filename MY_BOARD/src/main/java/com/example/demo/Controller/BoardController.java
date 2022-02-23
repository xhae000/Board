package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Common.Paging;
import com.example.demo.DTO.Article;
import com.example.demo.Mapper.BoardMapper;

@Controller
public class BoardController {

	@Autowired
	private BoardMapper boardMapper;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		System.out.println(boardMapper.getArticleCount());
		
		Paging p = new Paging();
		
		model.addAttribute("totalPageCount",
				p.getTotalPageCount(boardMapper.getArticleCount()));
		model.addAttribute("keword","woojin");	
		model.addAttribute("articles",boardMapper.getArticleLists());
		
		return "/index";
	}

	@RequestMapping("/write")
	public String write() {
	
		
		return "/write";
	}

}



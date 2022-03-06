package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.Article;
import com.example.demo.Mapper.BoardMapper;
import com.example.demo.Mapper.UserMapper;

@Controller
public class AjaxController {
	
	@Autowired
	UserMapper userMapper;
	@Autowired
	BoardMapper boardMapper;
	
	
	@RequestMapping("/isAvailableUsername")
	@ResponseBody
	public String isAvailableUsername(@RequestParam String username) {
		return userMapper.getUserId(username)==null?"available":"using";
	}
	
	@RequestMapping("/getArticles")
	@ResponseBody
	public List<Article> loadArticles(@RequestParam int page){
		return boardMapper.getArticleLists(page*30-30);
	}
	
	@RequestMapping("/commentProccess")
	@ResponseBody
	public String commentProccess(@RequestParam("articleId") int id,@RequestParam("comment")String comment) {
		System.out.println(id);
		System.out.println(comment);
		return "";
	}
}

package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.DTO.User;
import com.example.demo.Mapper.UserMapper;

@Controller
public class MyPageController {
	@Autowired
	UserMapper userMapper;
	@GetMapping("/mypage")
	public String mypage(Authentication auth,Model model) {
		model.addAttribute("nickname",userMapper.getNickname(auth.getName()));
		return "/mypage";
	}
	
	@GetMapping("/mypage/edit-myinfo")
	public String edit_myinfo(Authentication auth,Model model) {
		User user = userMapper.getUserInfo(auth.getName());
		model.addAttribute("nickname",user.getNickname());
		model.addAttribute("image",user.getImage());
		return "/edit-myinfo";
	}
	
}

package com.example.demo.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DTO.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Validate.SignupValidator;

@Controller
public class UserController {
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Autowired
	UserMapper userMapper;
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);
    
	
	
	
	@RequestMapping("/signin")
	public String signin(Authentication auth,@RequestParam(value="referer",required=false)String referer
			,Model model) {
		model.addAttribute("referer",referer);
		return auth==null?"/signin":"redirect:/";
	}
	
	@RequestMapping("/signup")
	public String signup(User user) {
		return "/signup";
	}
	
	@RequestMapping(value="/signupProcess", method=RequestMethod.POST)
	public String signupProcess(@ModelAttribute User user,@ModelAttribute("checkPw") String CheckPw,
			Model model) {
		SignupValidator sv = new SignupValidator(user, CheckPw, userMapper);
		if(sv.validate()==false)
			return "redirect:/";
			
		user.setPw(passwordEncoder.encode(user.getPw()));
		userMapper.createUser(user);
		model.addAttribute("nickname",user.getNickname());
		return "/signup_success";
	}

	
	@RequestMapping("/admin/home")
	public String admin() {
		return "/admin";
	}
}

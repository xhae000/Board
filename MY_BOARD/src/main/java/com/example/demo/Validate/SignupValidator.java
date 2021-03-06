package com.example.demo.Validate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.demo.DTO.User;
import com.example.demo.Mapper.UserMapper;

public class SignupValidator {
	User user;
	String checkPw;
	UserMapper userMapper;
	public SignupValidator(User user, String checkPw, UserMapper userMapper) {
		this.user = user;
		this.checkPw = checkPw;
		this.userMapper = userMapper;
	}
	
	public Boolean validate() {
		String username = user.getNickname();
		String pw = user.getPw();
		String nickname = user.getNickname();
		Logger LOGGER = LogManager.getLogger(SignupValidator.class);
		
		LOGGER.info("회원가입 시도 :\n 아이디:"+username+"\n 비밀번호:"+pw+"\n 비밀번호 확인:"+checkPw+"\n 닉네임:"+nickname);
			
		if(username==null||pw==null||checkPw==null||nickname==null) 
			return false;	
		
		else if(!pw.equals(checkPw)) 
			return false;
		
		else if(username.length()>32||checkPw.length()>32||nickname.length()>8) 
			return false;
		
		else if(userMapper.getUserId(username) != null) 
			return false;
		
		else return true;
	}
}	

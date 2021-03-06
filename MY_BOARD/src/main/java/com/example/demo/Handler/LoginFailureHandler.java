package com.example.demo.Handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailureHandler implements AuthenticationFailureHandler{
	final static private Logger LOGGER = LogManager.getLogger(LoginFailureHandler.class);
	
	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
		String msg="";
		
        if (exception instanceof BadCredentialsException ||exception instanceof UsernameNotFoundException
        		||exception instanceof AuthenticationServiceException) {
            msg = "아이디 또는 비밀번호가 일치하지 않습니다.";
          } else if (exception instanceof LockedException) {
            msg = "잠긴 계정입니다. 관리자에게 문의바랍니다.";
        } 
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("msg", msg);
 
        LOGGER.info("로그인 실패 \n 아이디 :"+request.getParameter("username")+"\n 오류 메시지 :"+msg);
        
        request.getRequestDispatcher("/signin").forward(request, response);
    }


}

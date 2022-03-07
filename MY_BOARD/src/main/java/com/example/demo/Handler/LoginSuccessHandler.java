package com.example.demo.Handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler { 
		
	private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();
    private RequestCache requestCache = new HttpSessionRequestCache();


	@Override public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException { // 로그인 성공시 실패 카운트 초기화
			String referer = httpServletRequest.getParameter("referer");
			SavedRequest req = requestCache.getRequest(httpServletRequest,httpServletResponse);
		
		    if(!referer.equals("")) 
	            redirectStratgy.sendRedirect(httpServletRequest, httpServletResponse, referer);
		    else if(req!=null) 
	            redirectStratgy.sendRedirect(httpServletRequest, httpServletResponse, req.getRedirectUrl());
		    else 
	            redirectStratgy.sendRedirect(httpServletRequest, httpServletResponse, "/");
		}
}


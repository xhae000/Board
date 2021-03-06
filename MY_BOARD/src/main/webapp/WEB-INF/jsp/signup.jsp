<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>SIGN UP</title>

<link href="/css/common.css" rel="stylesheet" />
<link href="/css/signin.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/js/signup.js" type="text/javascript"></script>
<script src="/js/common.js" type="text/javascript"></script>


</head>
<body>
  <div class="screen-top">
      <div class="title">
       ShareALL
      </div>
      <div class="madeByWoojin">
        made by woojin  
      </div>
  </div>
  
  <div class="screen-middle">

    <div class="content">
    <div class="signin-text">
      SIGN UP
    </div>
      <form method="post" action="/signupProcess">
        <input name="username" placeholder="아이디 (영문+숫자로 32자까지)" maxlength="32"     id="username" class="input"/>
        <div id="username_alert" class="alert">
        </div>
        
        <input name="nickname"  id="nickname" maxlength="8" placeholder="닉네임 (8자까지)"class="input" />
        <div id="nickname_alert" class="alert" >
        </div>
        
        <input name="pw" type="password" maxlength="32" placeholder="비밀번호(32자 이내)" id="pw"class="input"/>
        <div id="pw_alert" class="alert">
        </div>
        
        <input name="checkPw" id="checkPw" type="password" maxlength="32" placeholder="비밀번호 확인" class="input"/>
		<div id="checkPw_alert" class="alert">
		</div>
            
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="SIGN UP!" class="submit" />
      </form>

      
    </div>
  </div>
</body>
</html>
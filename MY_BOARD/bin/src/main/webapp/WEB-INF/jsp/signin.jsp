<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<link href="/css/common.css" rel="stylesheet" />
<link href="/css/signin.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/js/signin.js" type="text/javascript"></script>
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
      SIGN IN
    </div>
      <form method="post" action="/signinProcess">
        <input name="username" placeholder="아이디" maxlength="32"   type="text"  id="username" 	/>
        <div id="username_empty" class="alert">
        </div>
        <input name="pw" type="password" maxlength="32" placeholder="비밀번호" id="pw"/>
        <div id="pw_empty" class="alert">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="alert" style="text-align:center;">
        	${msg}
        </div>
        <input type="submit" value="SIGN IN!" class="submit" />
      </form>
      <div class="option-bottom">
        <div style="cursor:pointer"
             onclick="location.href='/signup'">
          SIGN UP
        </div>
        
        <div style="cursor:pointer;">
          Forgot Account?
        </div>
      </div>
    </div>
  </div>
</body>
</html>
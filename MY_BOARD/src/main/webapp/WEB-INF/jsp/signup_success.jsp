<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome!</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script src="/js/common.js" type="text/javascript"></script>
<link href="/css/common.css" rel="stylesheet" />

<style>
	.btn{
		display:inline-block; padding:10px 27px 10px 27px; margin-right:10px; background-color:#ffffff;
		font-size:23px;cursor:pointer;border-radius:7%;
	}
</style>
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
  
  <div style="font-size:57px; text-align:center; margin-top:20px;">
  	welcome! <span style="color:#0072F6"> ${nickname}</span> 님
  </div>
  
  <div style="text-align:center; font-size:18px; margin-top:3px;">
  		회원가입이 완료되었습니다.
  </div>
  <div style="text-align:center;margin-top:8%;">
  		<div class="btn" style="border:0.1px solid #2D91F8;color:#2D91F8;"
  				onclick="location.replace('/signin?referer=/')">
  				로그인
  		</div>
  		<div class="btn" style="border:0.1px solid #c5c5c5;"
  				onclick="location.replace('/')">
  				홈으로
  		</div>
  </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edit Me</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link href="/css/common.css" rel="stylesheet" />
<link href="/css/edit-myinfo.css" rel="stylesheet" />

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
  	 
<div style="text-align:center; border-top:40px;">
  <div class="cont">
    <div>
      <h2>
         내 정보 수정
      </h2>
    </div>
    <div class="info-zone">
      <div class="image-zone">
        <img src="http://localhost:8080/image/no-image.png" /><br>
        <label for="" class="change-image">
            변경
        </label>
        <input type="file" id="image-input" accept="image/*" style="display:none;"/>
        <div style="font-size:14px;color:#595959">
          변경된 이미지는 1:1 비율로 조정됩니다.
        </div>
      </div>
      <div class="nickname-zone">
        <div>
          <div class="type-info">
            닉네임
          </div>
          <div style="display:inline-block;">
            <input value="${user.nickname}"/>
            <span class="nickname-submit">변경</span>  
          </div>
        </div>
      </div>
      <div class="password-zone">
         <div>
          <div>
            <div class="type-info">비밀번호</div>  
            
          <div style="display:inline-block;">
            <input value="${user.nickname}"/>
          </div>
           </div>
           <div style="margin-top:5px;">
            <div class="type-info" >
              비밀번호 확인
            </div>
            <div style="display:inline-block;">
              <input value="${user.nickname}"/>
              <span class="nickname-submit">변경</span>  
            </div>
           </div>
        </div>
      </div>
      <div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
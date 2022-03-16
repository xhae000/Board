<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script src="/js/common.js" type="text/javascript"></script>

<link href="/css/common.css?after" rel="stylesheet" />
<link href="/css/mypage.css" rel="stylesheet" />

<meta charset="utf-8">
<title>MYPAGE</title>
<script>
	$(document).ready(function(){
		$('.move-btn').click(function(){
			location.href = "/"+$(this).attr('id');
		});
	});
</script>
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
      
    <div style="text-align:center;paddig-top:15px; overflow:hidden;">
    <div class="mypage-box">
    	<h2 style="text-align:center;">
    		<span style="color:#30CBA0">${nickname}</span> 님의 마이페이지
    	</h2>
		    <div>
		  <div class="menu-circle">
		    <h4>내 정보 수정</h4>
		    <div class="description">
		      닉네임, 비밀번호, 이미지 등 나의 정보를 수정할 수 있어요.
		    </div>
		    <div class="box-bottom">
		      <div class="move-btn" id="edit-myinfo">
		        〉〉 이동
		      </div>
		    </div>
		  </div>
		  <div class="menu-circle">
		    <h4>
		     내가 쓴 글
		    </h4>
		    <div class="description">
		      내가 쓴 글, 댓글 등을 볼 수 있어요.
		
		    </div>
		   <div class="box-bottom">
		      <div class="move-btn" id="writed-articles">
		        〉〉 이동
		      </div>
		    </div>
		  </div>
		  </div>
		  <div>
		  <div class="menu-circle">
		    <h4>
		      통계
		    </h4>
		    <div class="description">
		      나의 활동을 눈으로 볼 수 있어요.
		    </div>
		    <div class="box-bottom">
		      <div class="move-btn" id="statistics">
		        〉〉 이동
		      </div>
		    </div>  
		  </div>
		  <div class="menu-circle">
		    <h4>
		      회원탈퇴
		    </h4>
		    <div class="description" style="color:#F1493B">
		      	계정을 삭제할 수 있어요.
		    </div>
		    <div class="box-bottom">
		      <div class="move-btn" id="delete-account">
		        〉〉 이동
		      </div>
		    </div>  
		  </div>
		  </div>
  </div>
  </div>
</body>
</html>
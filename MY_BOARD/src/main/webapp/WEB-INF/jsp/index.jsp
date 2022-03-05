<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ShareALL</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link href="/css/index.css" rel='stylesheet' />
<link href="/css/common.css?after" rel="stylesheet" />
<script src="/js/common.js" type="text/javascript"></script>
<script src="/js/index.js" type="text/javascript"></script>

<style>
  @media (max-width:1085px) {
  .screen-side{
    width:4%;
  }
  .wrap-content{
    width:90%;
  }
       .menuBox{
         display:none;

       }
       
       .bottom-cont{
       	width:90%;
       }


}

</style>

<script>
	$(document).ready(function(){
		
	
	$('.signin-btn').click(function(){
		window.location.href="/signin"
	});
	$('.signup-btn').click(function(){
		window.location.href="/signup"
	});
	$('.write-btn').click(function(){
		window.location.href="/write"
	});
	
	})
	
	function getTime(time){	
	    var date = new Date(String(time));
	    var nowDate = new Date();
	
	    var yearD = nowDate.getFullYear()-date.getFullYear();
	    var monthD = nowDate.getMonth()-date.getMonth();
	    var dateD = nowDate.getDate()-date.getDate();
	    var hourD = nowDate.getHours()-date.getHours();
	    var minuteD = nowDate.getMinutes()-date.getMinutes();
		
	    if(yearD==0&&monthD==0&&dateD==0&&hourD==0) {
	    	if(minuteD==0) return "방금 전";
	    	else
	    		return String(minuteD)+"분 전";
	    }
	    else if(yearD==0&&monthD==0&&dateD==0) {
	        if(minuteD>0) return String(hourD)+"시간 전";
	        else return String(hourD-1)+"시간 전";
	    }
	    else if(yearD==0 || monthD<=0) return String(date.getMonth()+1)+"월 "+String(date.getDate())+"일";
	    else return String(yearD)+"년 전"
	   
	};
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
  
  <div class="screen-middle">
    <div class="screen-side">
    </div>
    
 
    <div class="wrap-content">
    
    	<div class="content-top">
    		<div class="search-bar">
    			<input class="search-input" placeholder="Search..."
                 onKeypress="javascript:if(event.keyCode==13) {검색함수.ajax로}"/>
          <div class="search-btn">
              <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Ios-search.svg/768px-Ios-search.svg.png"                        width="25px" />    
          </div>
    		</div>
    		<div class="write-article">
          <div class="write-btn">
            글쓰기
          </div>

    		</div>
    	</div>
   
    <div class="article-zone">
	<c:forEach var="i" items="${articles}" varStatus="status">
		<div class="articleBox">
      	  <div class="article-top">
          	<div class="titleBox">
           	 <div class="article-title">
             	${i.title}
           	 </div>
            </div>
            <div class="writerBox">
           	 	<img class="writerImage" src="${i.writer_image}"
             	   />
           	 	<span class="writerNickname">
            	  ${i.nickname}
           		</span>
          	</div>
       	 </div>
       	 <div class="article-bottom">
         	 <div style="color:#717171;font-size:13px;">
              		<script>
              			var t = getTime("${i.uploadtime}");
                  		document.write(t);
              		</script>
        	 </div>
          	 <div>
            	<img class="article-info"
                	 src="https://everytime.kr/images/new/container.articles.vote.png" />
          	    <span class="likes">${i.likes}</span>
          	    <img class="article-info"
                 src="https://everytime.kr/images/new/container.articles.comment.png" />
            	<span class="comments">1041</span>
         	</div>
        </div>
      </div>
	</c:forEach>
	</div>

	    </div>
    <div class="screen-side">
      <div class="menuBox">
        <div style="text-align:center;">
        	<sec:authorize access="isAnonymous()">
	          <div class="signin-btn">
	            	로그인
	          </div>
	          <div class="signup-btn">
	             	회원가입 
	          </div>
           	</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<div class="signout-btn" onclick="location.replace('/signout')" >
					로그아웃
				</div>
			</sec:authorize>	
        </div>
      </div>
      

    </div>
    <div style="text-align:center;">
    <div class="bottom-cont" style="">
			<div class="screen-bottom">
			  <div class="page-left">
		    	<div id="prev-btn" class="page-btn">
		      		◀ 이전
		    	</div>
		    	<div id="first-btn" class="page-btn">
		   		   ▲ 처음
		   		 </div>
		 	 </div>
		  <div class="page-right">
			    <div id="next-btn" class="page-btn">
			      다음 ▶
			    </div>
			  </div>
			</div>
	
	</div>
   </div>
   </div>
	

</body>

</html>
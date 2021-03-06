<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>index</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link href="/css/index.css" rel='stylesheet' />
<link href="/css/toolbar.css" rel="stylesheet" />


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
    
    
	<c:forEach var="i" items="${articles}" varStatus="status">
		<div class="articleBox">
      	  <div class="article-top">
          	<div class="titleBox">
           	 <div class="article-title">
             	${i.title}
           	 </div>
            </div>
            <div class="writerBox">
           	 	<img class="writerImage" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcf6LCh1ePK3THqiX8X0cyhHMF2y4QlJMd_A&usqp=CAU"
             	   />
           	 	<span class="writerNickname">
            	  ${i.nickname}
           		</span>
          	</div>
       	 </div>
       	 <div class="article-bottom">
         	 <div style="color:#717171;font-size:13px;">
              	${i.uploadtime}
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
    <div class="screen-side">
      <div class="menuBox">
        <div>
          메뉴메뉴메뉴
        </div>
      </div>
    </div>

   </div>
	

</body>
</html>
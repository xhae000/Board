<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${article.title} - ShareALL</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/js/common.js" type="text/javascript"></script>
<script src="/js/article.js" type="text/javascript"></script>
<script>
function getTime(time){	
    var date = new Date(String(time));
    var nowDate = new Date();
	
    const sub = (nowDate - date)/1000/60 //분 단위
    
    if(sub<1) //1분 미만
   		return "방금 전";
    else if(sub<60) //1시간 미만
    	return Math.floor(sub)+"분 전";
    else if(sub<60*24) //1일 미만
    	return Math.floor(sub/60)+"시간 전";
    else if(sub<60*24*30) //1달 미만(30일로)
    	return Math.floor(sub/60/24)+"일 전";
    else if(sub<60/24/365) //1년 미만
    	return Math.floor(sub/60/24/30)+"개월 전";
    else 
    	return Math.floor(sub/60/24/365)+"년 전";
};
</script>

<link href="/css/common.css?after" rel="stylesheet" />
<link href="/css/article.css" rel="stylesheet" />


</head>
<body>
<body >
  <div class="screen-top">
      <div class="title">
       ShareALL
      </div>
      <div class="madeByWoojin">
        made by woojin  
      </div>
  </div>
  <div style="text-align:center;" >
  	<div class="screen-middle">
  		<div class="title-zone" data-id="${article.id }">
        	${article.title}
      </div>
      <div class="info-zone">
        <div class="writer-zone">
           <img src="${article.writer_image}" width="27px" height="27px" style="vertical-align:middle;border-radius:70%;border:0.1px solid #c5c5c5" />
          <div class="writer-name">
            ${article.nickname }
          </div>
        </div>
        <div class="info-right">
          <div class="article-time" title = "${article.uploadtime}">              		
          			<script>
              			var t = getTime("${article.uploadtime}");
                  		document.write(t);
              		</script>
         </div>
          <div class="see"> 조회 ${article.see} </div>
          <div style="display:inline-block" class="likes">추천 ${article.likes}</div>
        </div>
      </div>
      <div class="des-zone">
			${article.description}
      </div>
      
      <div class="comment-zone">
        <div style="border-bottom:0.1px solid #c5c5c5;padding-bottom:5.5px;">
          <div class="commentCount" data-commentCount = "${commentCount}">
            댓글 ${commentCount}개
          </div>
        </div>
        <div class="comment-list">
        <c:forEach items="${comments}" var="i">
          <div class="comment-box">
            <div class="comment-info">
              <div style="display:flex;justify-content:space-between;">
                <div>
               <span class="comment-img" style="cursor:pointer">
                <img src="${i.writer_image}" width="30px" style="height:30px;border-radius:70%;background-color:black;vertical-align:middle;"/>
                </span>

                 <div class="comment-top">
                    ${i.nickname}
                  </div>
                  <span class="comment-time">
                     <script>
              			var t = getTime("${i.upload_time}");
                  		document.write(t);
              		</script>
                  </span>
                </div>
                 <div class="comment-report">
                  신고
                </div>
              </div>
              <div style="display:inline-block;">
                <div class="comment-des">
						${i.description }
                </div>
              </div>
            </div>
            <div class="comment-bottom">
              <div class="write-reply">
                <img src="https://everytime.kr/images/new/container.articles.comment.png"   width="18px;" style="vertical-align:middle;padding-bottom:5px;"/>
                   답글
              </div>
              <div class="comment-like">
                <img src="https://everytime.kr/images/new/container.articles.vote.png" width="16px" style="vertical-align:middle;padding-bottom:5px;"/>
                <span class="comment-like-num">
                  ${i.likes}
                </span>
              </div>
              

            </div>
          </div>
          </c:forEach>
          <c:if test="${commentCount==0}">
          	 <div class="no-comment">
          			<img src="https://static.thenounproject.com/png/638755-200.png" /><br>
          			첫 댓글을 작성해주세요!
         	 </div>
          </c:if>
				<div class="write-comment">
				   	<input type="text" placeholder="댓글을 입력해주세요." maxlength="200" class="comment-input" />
				   	<div class="comment-submit">
				   		등록
				   	</div>
				</div>
          </div>
        </div>
       </div>
  	</div>
  	
  
 
  
</body>
</body>
</html>
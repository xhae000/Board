<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Create Article</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link href="/css/common.css" rel="stylesheet" />
<link href="/css/write.css" rel="stylesheet" />

<script src="/js/common.js" type="text/javascript"></script>
<script src="/js/write.js" type="text/javascript"></script>

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
  	 <div style="text-align:center">
  <div class="screen-middle">

    <div class="content">
    <form class="writeForm" action="/writeProcess" method="post" enctype="multipart/form-data">
    <div class="write-article">
      글쓰기
    </div>
      <div class="title-bar">
        <input name="title" class="title-input" maxlength="20" placeholder="제목을 입력해주세요." />
      </div>
      <div class="description">
         <textarea name="description" class="description-input" maxlength="1100" placeholder="내용을 입력해주세요."></textarea>
      </div>
      <div class="content-bottom">
		<div class="img-status">
             <label class="upload-img" for="input-file">
                     <img src="https://icon-library.com/images/add-image-icon-png/add-image-icon-png-15.jpg"
             width="30px" title="사진 추가하기" alt="사진 추가하기" style="cursor:pointer;" />
             </label>
             <input type="file" id="input-file" name="file" style="display:none;" accept="image/*" />
             <div class="img-info">
            		<img class="img-preview" style="vertical-align:middle" width="30px"/>
                    <span class="delete-img">
            	     	×
           		    </span>
             </div>

		</div>
        <div class="btn-container">
        <label class="label-submit" for="submit">
          <span class="article-btn" id="create-btn">
            등록
          </span>
          
          </label>        
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>        
          <input type="submit" id="submit" style="display:none;"/> 
          
          <span class="article-btn" id="cancel-btn">
            취소
          </span>
        </div>
      </div>
      </form>
      
    </div>
  </div>
</div>
</body>
</html>
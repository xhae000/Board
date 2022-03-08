	/**
 * 
 */
 

$(document).ready(function(){
	
		var w = $('.article-image').width();
		var h = $('.article-image').height();
		if(w>=h){
			$('.article-image').css("min-width","600px");
			$('.article-image').css("max-width","270px");
		}
		else{
			$('.article-image').css("min-height","270px");
			$('.article-image').css("max-height","600px");
		}
	

		
	function updateComment(data){
		$('.comment-list').empty();
		$('.no-comment').css('display','none');
		$('.commentCount').empty().append("댓글 "+data.commentCount+"개");
		$.each(data.comments , function (index, i) {
			var des =""+i.description
			
			$('.comment-list').append("<div class='comment-box' data-parent-id='"+i.parent_id+"'>"+
            "<div class='comment-info'>"+
            "  <div style='display:flex;justify-content:space-between;'>"+
            "    <div>"+
            "   <span class='comment-img' style='cursor:pointer'>"+
            "    <img src='"+i.writer_image+"' width='30px' style='height:30px;border-radius:70%;background-color:black;vertical-align:middle;'/>"+
            "    </span>"+
			"     <div class='comment-top'>"+
 					 i.nickname+
            "     </div>"+
            "     <span id='time-zone"+index+"' class='comment-time'>"+
 				   "<script>"+
  						"var t = getTime('"+i.upload_time+"');"+
   						"document.getElementById('time-zone"+index+"').innerHTML = t;"+
    			   "</script>"+
     "             </span>"+
      "          </div>"+
       "          <div class='comment-report'>"+
         "         신고"+
          "      </div>"+
          "    </div>"+
          "    <div style='display:inline-block;'>"+
          "      <div class='comment-des'>"+
						des+
            "</div>"+
            "  </div>"+
          "  </div>"+
          "  <div class='comment-bottom'>"+
          "    <div class='write-reply'>"+
                "<img src='https://everytime.kr/images/new/container.articles.comment.png'   width='18px;' style='vertical-align:middle;padding-bottom:5px;'/>"+
                   " 답글"+
              "</div>"+
              "<div class='comment-like'>"+
                "<img src='https://everytime.kr/images/new/container.articles.vote.png' width='16px' style='vertical-align:middle;padding-bottom:5px;'/>"+
                "<span class='comment-like-num'>&nbsp;"
                  +i.likes+
                "</span>"+
              "</div>"+
            "</div>"+
         "</div>");
         $('.comment-input').val('');
		});
	}
	
	
	
	$('.comment-submit').click(function(){
		$.ajax({
			url : "/commentProccess",
			data : {articleId:$('.title-zone').data('id'), comment:$('.comment-input').val()},
			method : "get",
			success : function(data){
				updateComment(data);
			}
		});
	});
	
	$('.article-like').click(function(){
		$.ajax({
			url : "/articleLike/"+id,
			method : "get",
			success : function(data){
				if(data=="need_login"){
					if (confirm("로그인이 필요한 서비스 입니다.\n로그인 하시겠습니까?"))
						location.href="/signin?referer=article/"+id;
				}
				else if(data=="already_like")
					alert("좋아요는 한 번만 가능합니다.");
				else
					$('.article-like-num').empty().append(data);
					//좋아요 수 업데이트		
			}
		})	
	});
	
	$('#delete-article').click(function(){
		if(confirm("게시글을 삭제하시겠습니까?"))
			location.href="/deleteArticle/"+id;
	});
	
	$('#edit-article').click(function(){
		location.href="/editArticle/"+id;
	})
	

});
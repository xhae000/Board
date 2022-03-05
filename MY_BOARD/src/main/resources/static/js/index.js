	/**
 * 
 */
 
 $(document).ready(function(){
			$('#first-btn').click(function(){location.reload()});
	
			var page_=1;

			function loadArticles(){		
				$.ajax({
					url : "/getArticles",
					data : {page : page_},
					method : "get",
					async: false, 
					success : function(data){

						$('.article-zone').empty();
						$.each(data , function (index, i) {
 							$(".article-zone").append(
						 		"<div class='articleBox'>"+
						      	  "<div class='article-top'>"+
						          	"<div class='titleBox'>"+
						           	"<div data-id='"+i.id+"' class='article-title'>"+
						             	i.title+
						           	 "</div>"+
						            "</div>"+
						            "<div data-writer-id='"+i.writer_id+"'class='writerBox'>"+
						           	 	"<img class='writerImage' src="+i.writer_image+
						             	 "  />"+
						           	 	"<span class='writerNickname'> "
						            	+i.nickname+
						           		"</span>"+
						          	"</div>"+
						       	 "</div>"+
						       	 "<div class='article-bottom'>"+
						         "	 <div id='time-zone"+index+"' style='color:#717171;font-size:13px;''>"+

						        	 "</div>"+
						          	 "<div>"+
						            	"<img class='article-info'"+
						                "	 src='https://everytime.kr/images/new/container.articles.vote.png'/>"+
						          	    "<span class='likes'> "+i.likes+"</span>"+
						          	   " <img class='article-info'"+
						              "   src='https://everytime.kr/images/new/container.articles.comment.png' />"+
						            	"<span class='comments'> 1041</span>"+
						         "	</div>"+
						        "</div>"+
						      "</div>"+
						      						          "    		<script>"+
						           "  			var t = getTime('"+i.uploadtime+"');"+
						           "      document.getElementById('time-zone"+index+"').innerHTML = t;"+
						             " 		</script>");
                		});
                		if(data.length<30)
							$('#next-btn').css('display','none');	
					}	
				});
			}
						$('.page-btn').click(function(){
						 $('.page-btn').css('display','inline-block');
						});
	$('#next-btn').click(function(){
		page_+=1;
		loadArticles();
	});
	
	$('#prev-btn').click(function(){
		page_-=1;
	   if(page_==1) $('#first-btn, #prev-btn').css('display','none');
		loadArticles();
	});
	$('body').on('click','.article-title',function(){ 
			location.href  = "/article/"+$(this).data('id');
	});
	$('body').on('click','.writerBox',function(){
			location.href  = "/user/"+$(this).data('writer-id');
	});
});	

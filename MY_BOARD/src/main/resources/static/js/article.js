$(document).ready(function(){
	$('.comment-submit').click(function(){
		$.ajax({
			url : "/commentProccess",
			data : {articleId:$('.title-zone').data('id'), comment:$('.comment-input').val()},
			method : "get",
			success : function(data){
				alert("successa");
			}
		});
	});
});
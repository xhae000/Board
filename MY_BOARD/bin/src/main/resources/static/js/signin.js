/**
 * 
 */
 
 $(document).ready(function(){
	$('#username').focus();
	 $(".submit").click(function(){
	  $('.alert').empty();
	  $('#username, #pw').css('border','0.1px solid #000000');
	  
	  if($("#username").val()==''){
	    $('#username_empty').append('아이디를 입력해주세요.');
	    $('#username').focus().css('border','1px solid #ff6060');
	    return false;
	  }
	  else if($("#pw").val()==''){
	    $('#pw_empty').append('비밀번호를 입력해주세요.');
	    $('#pw').focus().css('border','1px solid #ff6060');
	    return false;
	  }
	});
});
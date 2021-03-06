/**
 * 
 */
 function isAvailableUsername(){
				var isAvailable;
				$('#username_alert').empty();
				$('#username').css('border','1px solid #000000');

				$.ajax({
				url : "/isAvailableUsername",
				data : {username : $('#username').val()},
				method : "get",
				async: false, 
				success : function(data){
					if(data=="using"){
						$('#username_alert').append("이미 사용 중인 아이디입니다.");
						$('#username').css('border','1px solid #ff6060');
				   	  isAvailable = false;
					}
					else isAvailable= true;
				}
			});
			
			return isAvailable;
}
 
 
  $(document).ready(function(){
	$('#username').focus();
	
	 $(".submit").click(function(){	
	  $('.alert').empty();
	  $('.input').css('border','0.1px solid #000000');
	  
	  
       if(!isAvailableUsername())
     		return false;
	   else if($("#username").val()==""){
	    $('#username_alert').append("아이디를 입력해주세요.");
	    $("#username").focus().css('border','1px solid #ff6060');
	    return false;
	  }
	  else if($('#nickname').val()==""){
		$('#nickname_alert').append("닉네임을 입력해주세요.");
		$('#nickname').focus().css('border','1px solid #ff6060');
		return false;
	}
	  else if($("#pw").val()==""){
	    $('#pw_alert').append("비밀번호를 입력해주세요.");
	    $("#pw").focus().css('border','1px solid #ff6060');;
	    return false;
	  }
	  else if($("#checkPw").val()==""){
		$('#checkPw_alert').append("비밀번호를 재입력해주세요.");
		$("#checkPw").focus().css('border','1px solid #ff6060');
		return false;
	 }	
	 else if($('#pw').val()!=$('#checkPw').val()){
		$('#checkPw_alert').append("비밀번호가 일치하지 않습니다.");
		$("#checkPw").focus().css('border','1px solid #ff6060');
		return false;	
	}
		
	});
	
	$('#checkPw, #pw').change(function(){
		var pw=$('#pw').val();
		var checkPw=$('#checkPw').val();

		$('#checkPw_alert').empty();
		
		if(pw!=checkPw
			&&pw!="" && checkPw!="")	
			$('#checkPw_alert').append("비밀번호가 일치하지 않습니다.");
	});
	  
	  
	  $('#username').change(function(){
			$('#username_alert').empty();
			isAvailableUsername();
		});
	  
	  
});
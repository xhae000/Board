/**
 * 
 */
 $(document).ready(function(){
	$('form').submit(function(){		
		if($('.title-input').val()==''){
			alert("제목을 입력해주세요.");
			return false;
		}
		else if($('.description-input').val()==''){
			alert("내용을 입력해주세요.");
			return false;
		}
	});


	 $('#input-file').change(function(input){
	       var fileExtension = ['jpeg', 'jpg', 'png', 'gif', 'bmp'];
	        if ($.inArray($(this).val().split('.').pop().toLowerCase(), fileExtension) == -1) {
	            alert("이미지 파일이 아닙니다. \n("+fileExtension.join(', ')+")");
	            return false;
	        }
	        else {
				$('.upload-img').css('display','none');
				$('.img-info').css('display','block');
				
				
				var reader = new FileReader();
		        reader.onload = function (e) {
		            $('.img-preview').attr('src', e.target.result);
		            
		        }
		        reader.readAsDataURL(input.target.files[0]);
			}
	 });
	 
	 $('.delete-img').click(function(){
			$('.upload-img').css('display','block');
			$('.img-info').css('display','none');
			$('#input-file').val('')
	});
	 
 });	
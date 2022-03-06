<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />		
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&family=Poor+Story&display=swap" rel="stylesheet">
<script>
    $.ajax({
        url : "http://apis.data.go.kr/B552584/ArpltnStatsSvc/getCtprvnMesureLIst?serviceKey=Zf5Io47CxsmCU8Ws3K6l5oMnScHy5KCEhsAAA7KlBX6XRqKSq5m9PHEUwpOWOUOmdkbNcvePvToupmBqoO54mw%3D%3D&returnType=json&numOfRows=1&pageNo=1&itemCode=PM10&dataGubun=HOUR&searchCondition=MONTH",
        dataType : "JSON",
        success : function(){
            alert("success");
        },
        error : function(a,s,error){
            alert(a.message);
        }
            

    });
</script>	
<title>미세먼지 알리미</title>
	
	<style>
		body{
			margin : 0px;
			padding-bottom:30px;
		}
	    #title{
	        height : auto; width : 98%;
	        padding:1%;
	        font-size : 60px;
	        text-align : center;
			font-family: 'Poor Story', cursive;
			border-bottom : 0.5px solid #c5c5c5;
	    }
	    .box{
	    	display:none;
			border-radius:1px;
	    	padding:28px 80px 28px 80px;
	    	margin:5px;
	    	border : 0.5px solid #c5c5c5;
	    }
	    #content{
	    	text-align:center;
	    	margin-right:20%;
	   		margin-left:20%;
	    }
	    .sido_name{
	    	font-family: 'Noto Sans KR', sans-serif;
	    	font-size:33px;
	    }
	    .sido_num{
	    	font-family: 'Noto Sans KR', sans-serif;
	    	font-size:60px;	
	    	padding-top:5px;
	    	padding-bottom:5px;
	    }
	    .sido_state{
	    	font-family: 'Noto Sans KR', sans-serif;
	    	font-size:33px;	
	    }


	    #info_bar{
	    	text-align:center;
	    	    	display:flex;
	    	justify-content:space-between;
	    	margin-top:5px;
	    }
	    
	    
		#explain{
			font-family: 'Noto Sans KR', sans-serif;
		}
		.ex_box{
			display:inline-block;
			padding:5px;
			width:80px;
			text-align:center;
		}
	    #time{
	    	display:inline-block;
			text-align:right;
	    	margin-left:7px;
	    	font-family: 'Noto Sans KR', sans-serif;
	    }
	
		
		@media screen and (max-width: 1200px) {
			#content{
				margin-left:0;
				margin-right:0;	
			}
		}	
	</style>
	

</head>
<body>
 
<div id="title">
       미세먼지 알리미
</div>
<div id="info_bar">
	<div id="time">
		최종 업데이트 ${time}
	</div>
	<div id="explain">
		<span class="ex_box" style="background-color:#D7FFFE;color:#006CFF">
			0~30
		</span>
		<span class="ex_box" style="background-color:#E1FFD7;color:#22DE00">
			31~80
		</span>
		<span class="ex_box" style="background-color:#FFE09E;color:#FF6F25">
			81~150
		</span>
		<span class="ex_box" style="background-color:#FFB09E;color:#E91F03">
			151이상
		</span>
	</div>

</div>


<div id="content">
	<c:forEach items = "${map}" var = "i" varStatus="status">
		<div class="box" data-fade-time="${status.index }">
			<div class="sido_name" id="${i.key}"></div>
			<div class="sido_num">${i.value}</div>
			<div class="sido_state" data-num="${i.value}"></div>
		</div>
	</c:forEach>

</div>
</body>
	<script>
		var sido = new Map(); // 영어로된 시/도 이름을 한글로 변환
		sido.set("seoul","서울");
		sido.set("gyeonggi","경기");
		sido.set("incheon","인천");
		sido.set("gangwon","강원");
		sido.set("busan","부산");
		sido.set("daegu","대구");
		sido.set("sejong","세종");
		sido.set("gwangju","광주");
		sido.set("daejeon","대전");
		sido.set("ulsan","울산");
		sido.set("chungnam","충남");
		sido.set("chungbuk","충북");
		sido.set("jeonnam","전남");
		sido.set("jeonbuk","전북");
		sido.set("gyeongbuk","경북");
		sido.set("gyeongnam","경남");
		sido.set("jeju","제주");
		
		$('.sido_name').each(function(){
			$(this).text( 
				sido.get($(this).attr('id')));
		});
		
		$('.sido_num').each(function(){ //농도에 따른 요소에 색깔 입히기
			var color;
		
			if($(this).text()>150) //매우나쁨
				color = "#FFB09E"; 
			else if($(this).text()>80) //나쁨
				color = "#FFE09E";
			else if($(this).text()>30) //보통
				color = "#E1FFD7";
			else if($(this).text()>0) //좋음
				color = "#D7FFFE";
			else 					 //값이 안들어왔을때(흰색)
				color = "#ffffff";
			
			$(this).parent().css('background-color',color);
		})
		
		$('.sido_state').each(function(){
			var state = ['',''];
			
			if($(this).data('num')>150){
				state[0]="매우나쁨";
				state[1]="#E91F03"
			}
			else if($(this).data('num')>80){
				state[0]="나쁨";
				state[1]="#FF6F25";
			}
			else if($(this).data('num')>30){
				state[0]="보통";
				state[1]="#22DE00";
			}
			else if($(this).data('num')>0){
				state[0]="좋음"
				state[1]="#006CFF";
			}
			else{				 
				state[0]="-";
				state[1]="#000000"
			}
			
			$(this).text(state[0]);
			$(this).css('color',state[1]);
		});
		
		$('.box').each(function(){
			var fadeTime = $(this).data('fade-time');
			$(this).fadeIn(fadeTime*200).css('display','inline-block');
		});
		
		
	</script>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1">
<meta name="format-detection" content="telephone=no">
<title>대전전시관</title>
<link rel="stylesheet" type="text/css" href="../css/base.css">
<link rel="stylesheet" type="text/css" href="../css/common.css">
<link rel="stylesheet" type="text/css" href="../css/fullpage.css">
<link rel="stylesheet" type="text/css" href="../css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="../css/layout.css">
<link rel="stylesheet" type="text/css" href="../css/swiper.css">
<link rel="stylesheet" type="text/css" href="../css/board.css">
<link rel="stylesheet" type="text/css" href="../css/content.css">
<link rel="stylesheet" type="text/css" href="../js/custom.css">

<link rel="stylesheet" type="text/css" href="../css/main.css?ver=1.2">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/jquery-1.12.2.min.js"></script>
<!-- <script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/swiper-min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/slide.js"></script> -->
<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/scroll.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/schedule.js"></script>


<link href="<%=request.getContextPath() %>/admin/css/layout.css" rel="stylesheet">

<!--날짜선택 api -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<style>
#modalWrap {
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  display: none;
}

#modalBody {
  width: 500px;
  height: 300px;
  padding: 30px 30px;
  margin: 0 auto;
  border: 1px solid #777;
  background-color: #fff;
}

#closeBtn {
  float:right;
  font-weight: bold;
  color: #777;
  font-size:25px;
  cursor: pointer;
}
</style>

<%

	
	String inputId = (String)session.getAttribute("LOGINID");
	String inputNo = (String)session.getAttribute("USERNUM");

%>

<script>
	mypath = '<%=request.getContextPath()%>';
	currentPage = 1;
	
	usersNo = "<%=inputNo%>";
	
	$(function(){
		
		$.scheduleList();	
		
		$('.datepicker').datepicker();	
		  
		  $('.datepicker').datepicker({
	          dateFormat: 'yy-mm-dd' //Input Display Format 변경
	          ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
	          ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
	          ,changeYear: true //콤보박스에서 년 선택 가능
	          ,changeMonth: true //콤보박스에서 월 선택 가능                
	          ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
	          ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
	          ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
	          ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
	          ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
	          ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
	          ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
	          ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
	          ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
	          ,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
	          ,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
	      });    
		  
		  //$('.datepicker').datepicker('setDate', 'today');
		
	});
	
	$('#insertSchedule').on('click', function(){
		modal.style.display = 'block';
	});
	
	function closeModal() {
		$('#mform .txt').val("");
        $('#modalWrap').modal('hide');
    }
	
	function insertSchedule(){				
		
		scName = $('#scName').val();
		sDate = $('#sDate').val();
		eDate = $('#eDate').val();
		
		
		// 입력된 날짜를 'yy/mm/dd' 형식으로 변환하는 함수
	    function formatDate(date) {
	        const d = new Date(date);
	        const year = d.getFullYear().toString(); // 뒤의 두 자리만 사용
	        const month = (d.getMonth() + 1).toString().padStart(2, '0'); // 0부터 시작하므로 1을 더함
	        const day = d.getDate().toString().padStart(2, '0');
	        
	        result = year + "/" + month + "/" + day;
	        
	        return result;
	    }

	    // 날짜를 'yy/mm/dd' 형식으로 변환
	  	sDate = formatDate(sDate);
	  	eDate = formatDate(eDate);

	    console.log(sDate);
	    console.log(eDate);
		
		/*function calDate(sDate, eDate){
			// 입력된 날짜를 정수로 변환
		    const day1 = Date.parse(sDate);
		    const day2 = Date.parse(eDate);
		    
		 	// 날짜 간의 차이 계산 (밀리초 단위)
		    const difference = Math.abs(day2 - day1);

		    // 차이를 일(day)로 변환하여 반환
		    const daysDifference = difference / (1000 * 60 * 60 * 24);
		    
		    return daysDifference;
		}
		
		// +1일 만큼 반복해주어야 함
		const daysDifference = calDate(sDate, eDate);
		
		console.log(daysDifference);*/
		
		location.href="<%=request.getContextPath()%>/schedultWrite.do?scName="+scName+"&&sDate="+sDate+"&&eDate="+eDate+"&&usersNo="+usersNo;
		
// 		$.scheduleWrite();
		
		$('#mform .txt').val("");
		$('#modalWrap').modal('hide');

	}
	
	$(document).on('click','.checkMySchedule',function(){
		scNo = $(this).attr('id');
		location.href = "<%= request.getContextPath()%>/checkMySchedule.do?scNo="+scNo;
	});


</script>
</head>

<body class="main">
	<ul id="skip_navi">
		<li><a href="#content">본문 바로가기</a></li>
		<li><a href="#gnb">메인메뉴 바로가기</a></li>
	</ul>

	<div id="wrap">
		<!-- S. header -->
		<header id="header"  class="mob on"> <!-- !!!!!!!!!! -->
			<div class="inner wrap">
				<h1 class="logo">
					<a href="<%=request.getContextPath()%>/Mproject/jsp/main.jsp" title="">NORI Daejeon</a>
				</h1>
				<a href="#" class="btn_menu" data-util="menu">메뉴 열기</a>
				<nav id="gnb">
					<ul class="gnb">
						<li><a href="<%=request.getContextPath()%>/Mproject/jsp/tourism.jsp" >관광정보</a></li>
						<li><a href="<%=request.getContextPath()%>/Mproject/jsp/restaurant.jsp" >맛집정보</a></li>
						<li><a href="<%=request.getContextPath()%>/Mproject/jsp/communityList.jsp" >커뮤니티</a>
						<li><a href="<%=request.getContextPath()%>/Mproject/jsp/noticelist.jsp" class="board_notice">공지사항</a></li>
						<li><a href="<%=request.getContextPath()%>/qaList.do" class="board_Dgallery">Q&A</a></li>
					</ul>
				</nav>
				<div class="util_member">
<%

	
	if(inputId!=null){
		
	

%>
<a href="#"><%=inputId %>님</a>
	<a href="#" id="logout">로그아웃</a>
<%
	}else{
		
	
%>
<a href="<%=request.getContextPath()%>/Mproject/jsp/login.jsp">로그인</a>
<a href="<%=request.getContextPath()%>/Mproject/jsp/login.jsp">회원가입</a>
<%
	}

%>

					<a href="<%=request.getContextPath()%>/Mproject/jsp/mypageMain.jsp">마이페이지</a>
				</div>
				
			</div>
		</header>
		<div class="area_subVisual">
			<div style="background-image: url(../images/m01.jpg);"></div>
			<div class="subTit">
				<div>
					<h2 data-aos="fade-up">나의 일정</h2>
				</div>
				<div>
					<i data-aos="fade-up" data-aos-delay="350">나만의 일정을 짜보세요</i>
				</div>
			</div>
		</div>

		<!--container -->

		<section id="container">
			<div id="content">
				<article class="area_">
					<div class="wrap">
						<script type="text/javascript" src="/js/board.js"></script>
						<script type='text/javascript'>
							document.title = '(목록) | 공지사항';
						</script>


						<script type="text/javascript">
							$("#searchType option[value='" + "" + "']").prop(
									"selected", true);
						</script>
						
						<!-- 일정추가 버튼 -->						
						<div>
							<button type="button" id="insertSchedule" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalWrap">일정 추가</button>
						</div>
						<div class="modal fade">
						  <div class="modal-dialog">
						    <div class="modal-content">
						        <!-- remote ajax call이 되는영역 -->
						    </div>
						  </div>
						</div>
						
						<br>
												
						<div id="showList">
							<!--<ul class="bbsList">
	
								 일정 리스트 출력 -->
								<!--  <li><span class="date">23.08.13<br>~<br>23.08.15</span> 
								<a href="#" class="subject">대전 - 다양한 이야기</a></li>
								<li><span class="date"><i>16</i>2023.03</span> 
								<a href="#" class="subject">대전 - 다양한 이야기</a></li>
								<li><span class="date"><i>16</i>2023.03</span> 
								<a href="#" class="subject">대전 - 다양한 이야기</a></li> 
							</ul>-->
						</div>
		
					</div>
				</article>
			</div>
		</section>

		<!-- // container -->

		<!-- footer -->
		<footer id="footer">
			<div id="dokdo_bg" class="dokdo_area">
				<div id="dokdo_inn" class="wrap">

					<p>“ 아름다운 대전 ”</p>
					<div class="circle1"></div>
					<div class="circle1_1"></div>
					<div class="circle2"></div>
					<div class="circle2_1"></div>
					<i class="tx1">성심당</i>

				</div>
			</div>
			<div class="footer_inn">
				<div class="wrap">
					<address>
						<p class="copyright">© 2023 All rights reserved .</p>
					</address>
				</div>
			</div>
		</footer>
		<!-- //footer -->
		<!-- //footer -->
	</div>
	
	<!-- 띄워질 글쓰기 모달 창 -->
	<div id="modalWrap" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
		  <div id="modalContent">
		    <div id="modalBody">
		    	<!-- header -->
				<div class="modal-header">
					<button type="button" class="close-modal-btn" onclick="closeModal()">x</button>			
				</div>
				<div class="modal-header">
					<h3 class="modal-title">새 일정</h3>
				</div>
				
				<!-- body -->
				<div class="modal-body">
					<form name="mform" id="mform" action="<%=request.getContextPath()%>/schedultWrite.do">
						<!-- <input type="hidden" id="scNum" name="scNum"> -->
						
						<label>제목</label>
						<input type="text" class="txt" id="scName" name="scName" placeholder="제목"><br>
						
						<label>날짜</label>
						<input class="datepicker startDate txt" id="sDate" name="sDate" placeholder="시작일 선택"> ~ 
						<input class="datepicker endDate txt" id="eDate" name="eDate" placeholder="종료일 선택">
					</form>
				</div>
				
				<!-- footer -->
				<div class="modal-footer">
					<input type="button" id="send" value="만들기" onclick="insertSchedule()">
				</div>
		    </div>
		  </div>
		 </div>
	</div>

</body>

</html>
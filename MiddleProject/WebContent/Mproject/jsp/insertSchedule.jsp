<%@page import="vo.ScheduleVO"%>
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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/base.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/common.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/fullpage.css">
 <%--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/jquery-ui.css"> --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/layout.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/swiper.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/content.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/board.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/detail.css">
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/js/custom.css"> --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/tourism.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/schedule.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/main.css?ver=1.2">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/insertSchedule.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/jquery-1.12.2.min.js"></script>
 <%--<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/swiper-min.js"></script> --%>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/slide.js"></script> --%>
<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/scroll.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/main.js"></script>
<script src="<%=request.getContextPath()%>/Mproject/js/insertSchedule.js"  type="text/javascript"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=95544088854ec9cb3a80eaad450b5e1e"></script>
<%
 	ScheduleVO vo = (ScheduleVO)request.getAttribute("scheduleVO");
	String sdate = vo.getSc_sdate();
	System.out.println(sdate);
	String edate = vo.getSc_edate();
	System.out.println(edate);
	
	String inputId = (String)session.getAttribute("LOGINID");
%>
<script>
$(function(){
	
 	mypath="<%=request.getContextPath()%>";
	
  	scSdate = new Date("<%=vo.getSc_sdate()%>");
 	scEdate = new Date("<%=vo.getSc_edate()%>");
 	
 	
 	scNo = "<%=vo.getSc_no()%>";
 	
 	 
 	$.startPage(scNo, scSdate, scEdate);
// 	$.startPage();
	
	$(document).on('click','#save_schedule_list',function(){
		$('#scheduleListForm').get(0).submit();
	})
	
	//검색버튼
	$('#searchBtn').on('click', function(){
		currentPage = 1;
		sword = $('.search #searchTourList').val()
		$.search(currentPage);
	});
	
	//관광지 삭제
	$(document).on('click','.trRemoveBtn',function(){
		$(this).parent().prev().remove();
		$(this).parent().remove();
	})
	
	//관광지 추가
	$(document).on('click','.trChoiceBtn', function(){
		targetTrNo = $(this).prev().attr('id');
		targetTrName = $(this).prev().text();
		$.tourismChoice(targetTrNo, targetTrName);
	});
	
	//관광지 정보
	$(document).on('click','.search_tr_name', function(){
		trNo = $(this).attr('id');
		$.tourismInfoMap(trNo);
		$.tourismInfoModal(trNo);
	});
	
	//DAY버튼
	$(document).on('click','.dayInfo',function(){
		dayInfoTarget = $(this).attr('id');
		$.dayChoice(dayInfoTarget);
	})
	
	//페이지버튼
	$(document).on('click','.pageno',function(){
		currentPage = $(this).text();
		$.search(currentPage);
	});	//.pageno 끝
	
	
	//다음버튼
	$(document).on('click','#nextBtn', function(){
		currentPage = parseInt($('.pageno').last().text())+1;
		$.search(currentPage);
	});//다음 끝
	
	
	//이전버튼
	$(document).on('click', '#prevBtn', function(){
		var currentPage = parseInt($('.pageno').first().text())-1
		$.search(currentPage);
	});//이전 끝
	

	//로그아웃
	$('#logout').on('click',function(){
		$.ajax({
			url:"<%=request.getContextPath()%>/logoutMember.do",
			type:'post',
			success: function(res) {
				alert("로그아웃 완료!")
				 location.href = "<%=request.getContextPath()%>/Mproject/jsp/main.jsp";
			},
			error:function(xhr){
				  alert("상태: " + xhr.status);
			}
		});//ajax
	});//온클릭	

});//$(function) 끝
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

					<a href="">마이페이지</a>
				</div>
				
			</div>
		</header>
		<div class="area_subVisual">
			<div style="background-image: url(<%=request.getContextPath()%>/Mproject/images/m01.jpg);"></div>
			<div class="subTit">
				<div>
					<h2 data-aos="fade-up">일정관리</h2>
				</div>
				<div>
					<i data-aos="fade-up" data-aos-delay="350">나만의 일정을 만들어보세요.</i>
				</div>
			</div>
		</div>

		<!--container -->

		
		<section id="container">

			<div id="content">
				<div class="wrap">
	
					<button type="button" id="save_schedule_list" class="right_blue">저장</button>
					<div class="tour_wrap">
						<div class="tourtime_wrap">
							<ul class="tab_day_list" id="tab_day_list">
								<!-- DAY출력 부분 -->
							</ul>
							<form action="<%=request.getContextPath()%>/insertSchedule.do" method="post" id="scheduleListForm">
								<div class="content_wrap">
										<!-- tabcontent 출력부분 -->
								</div>
							</form>
							
							
							<div class="sch_wrap">
								<div class="search_form">
						            <div class="search">
						                <input type="text" value="" id="searchTourList">
						                <button type="button" id="searchBtn">검색</button>
						            </div>
						        </div>
						        
								<div class="sch_list">
									<!-- 검색리스트 출력하는 곳 -->
								</div>
								<div id="pager"></div>
							</div>
							
						</div><!--tour_wrap  -->
						
						<div class="tour_map">
						<div id="map" style="width:700px; height:640px;"></div>
						</div>
					</div>	
				</div>
			</div>
			
		</section>
		
		<br>

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
			
		</footer>
		<!-- //footer -->
		<!-- //footer -->
	</div>

</body>

</html>
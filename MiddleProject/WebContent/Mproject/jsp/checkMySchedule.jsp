
<%@page import="vo.ScheduleDetailVO"%>
<%@page import="java.util.List"%>
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
<script src="<%=request.getContextPath()%>/Mproject/js/schedule.js"  type="text/javascript"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=95544088854ec9cb3a80eaad450b5e1e"></script>
<%
 	int maxDay = (int)request.getAttribute("maxDay");

	List<ScheduleDetailVO> list = (List<ScheduleDetailVO>)request.getAttribute("scNo");
	
	List<List<String>> trNameList = (List<List<String>>)request.getAttribute("trNameList");
	
%>
<script>
$(function(){
	
 	mypath="<%=request.getContextPath()%>";
 	
 	
 	scNo = "<%=list.get(0).getSc_no()%>";
 	 
<%--  	$.startPage(scNo, <%=maxDay%>); --%>
	content = `<input type="hidden" name="scNo" value=${scNo}>`;
	dayList = ``;
	
<%
	for(int i=0; i<trNameList.size(); i++){
%>
		dayList += `<li class="dayInfo" id="dayInfo<%=i+1%>">DAY<%=i+1%></li>`;
		content += `<div class ="tabcontent dayInfo<%=i+1%>" style="display:none">
					<ul class="schedule_list">`;
					
		content += `</ul>
					</div>`;
					
					
<%
	}
%>	

$('#tab_day_list').html(dayList);
$('.content_wrap').html(content);

$('.dayInfo').first().addClass('on');

$('.content_wrap .dayInfo1').attr('style','display:block');


	
<%
	for(int i=0; i<trNameList.size(); i++){
%>	
			trNames = ``;
<%
			for(int j=0; j<trNameList.get(i).size(); j++){
%>
			trNames += `<li>
<%			
			String trName = trNameList.get(i).get(j);
%>
						<%=trName%>
						</li>`;
<%
			}
%>
			$('.dayInfo<%=i+1%> .schedule_list').html(trNames);

<%
	}
%>			



<%-- <%
	for(int i=0; i<trNameList.size(); i++){
%>
		dayList += `<li class="dayInfo" id="dayInfo<%=i+1%>">DAY<%=i+1%></li>`;
		content += `<div class ="tabcontent dayInfo<%=i+1%>" style="display:none">
					<ul class="schedule_list">`;
					
			trNames = ``;
<%
			for(int j=0; j<trNameList.get(i).size(); j++){
%>
			trNames += `<li class="trNames">
<%			
			String trName = trNameList.get(i).get(j);
%>
						<%=trName%>
						</li>`;
<%
			}
%>			
					
		content += `</ul>
					</div>`;
<%					
	}
%> --%>
	
	
	
	//DAY버튼
	$(document).on('click','.dayInfo',function(){
		dayInfoTarget = $(this).attr('id');
		$.dayChoice(dayInfoTarget);
	})

function printTrName(){

}
	
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
		<header id="header" class="slidedown">
			<div class="inner wrap">
				<h1 class="logo">
					<a href="<%=request.getContextPath()%>/admin/jsp/index.jsp" title="">NORI Daejeon</a>
				</h1>
				
				
				
				<a href="#" class="btn_menu" data-util="menu">메뉴 열기</a>
				<nav id="gnb">
					<ul class="gnb">
						<li><a href="<%=request.getContextPath()%>/Mproject/jsp/tourism.jsp">관광정보</a></li>
						<li><a href="<%=request.getContextPath()%>/Mproject/html/food.html">맛집정보</a></li>
						<li><a href="<%=request.getContextPath()%>/Mproject/html/event.html">이벤트</a></li>
						<li><a href="<%=request.getContextPath()%>/Mproject/html/celebration.html">행사안내</a></li>
						<li><a href="<%=request.getContextPath()%>/Mproject/html/community.html">커뮤니티</a>
							<ul>
								<li><a href="/html/notice.html" class="board_notice">공지사항</a></li>
								<li><a href="/html/qa.html" class="board_Dgallery">Q&A</a></li>
							</ul></li>
					</ul>
				</nav>
				<div class="util_member">
					<a href="login.html">로그인</a> <a href="join.html">회원가입</a> <a
						href=mypage.html">마이페이지</a>
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
					<div class="tour_wrap">
						<div class="tourtime_wrap">
							<ul class="tab_day_list" id="tab_day_list">
								<!-- DAY출력 부분 -->
							</ul>
							
								<div class="content_wrap">
										<!-- tabcontent 출력부분 -->
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
<!-- 		<div id="pageList"></div> -->


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
					<a href="#" class="org qacircle"> <i class="fa fa-pencil"></i> Q&A</a>
				</div>
			</div>
		</footer>
		<!-- //footer -->
		<!-- //footer -->
	</div>

</body>

</html>
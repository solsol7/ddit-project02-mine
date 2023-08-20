<%@page import="vo.TourismVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %> 
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

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Mproject/css/main.css?ver=1.2">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/jquery-1.12.2.min.js"></script>
 <%--<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/swiper-min.js"></script> --%>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/slide.js"></script> --%>
<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/scroll.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Mproject/js/main.js"></script>
<script src="<%=request.getContextPath()%>/Mproject/js/tourism.js"  type="text/javascript"></script>

<%

	String inputId = (String)session.getAttribute("LOGINID");

%>
<script>
mypath = '<%= request.getContextPath()%>';
currentPage = 1;

$(function(){
	
	$.tourismList(currentPage);
	
	//페이지버튼
	$(document).on('click','.pageno',function(){
		currentPage = $(this).text();
		$.tourismList(currentPage);
	});	//.pageno 끝
	
	
	//검색버튼
	$(document).on('click','#sBtn',function(){
		currentPage = 1;
		$.tourismList(currentPage);
	}); //sBtn 끝
	
	
	//다음버튼
	$(document).on('click','#nextBtn', function(){
		currentPage = parseInt($('.pageno').last().text())+1;
		$.tourismList(currentPage);
	});//다음 끝
	
	
	//이전버튼
	$(document).on('click', '#prevBtn', function(){
		currentPage = parseInt($('.pageno').first().text())-1
		$.tourismList(currentPage);
	});//이전 끝

	
	//List클릭
	$(document).on('click','.tourDetail',function(){
		trNo = $(this).attr('id');
		location.href = "<%= request.getContextPath()%>/tourismDetail.do?trNo="+trNo;
	});//tourDetail 끝
	

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

})// $(function)끝
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
					<h2 data-aos="fade-up">관광정보</h2>
				</div>
				<div>
					<i data-aos="fade-up" data-aos-delay="350">대전의 다양한 관광정보를 확인하세요</i>
				</div>
			</div>
		</div>

		<!--container -->

		
		<section id="container">
			<div id="content">
				
				<article class="area_photo">
				
					<div class="wrap">
						<div id="search">
							<input type="text" id="sword">
							<input type="button" id="sBtn" value="검색">
						</div>

						<div class="tab_container">
							<div id="tab1" class="tab_cnt" style="display: block;">
								<script type="text/javascript" src="/js/board.js"></script>
								<script type="text/javascript">
									document.title = '(목록) | 독도사진';
								</script>
								<ul class="photoList" id="result"></ul>


							</div>
					
						</div>


					</div>
				</article>

			</div>
		</section>
		
		<br>
		<div id="pageList"></div>


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
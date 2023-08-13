<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/Mproject/js/jquery-3.7.0.min.js"></script>
<script>
$(function(){
	sdate = new Date('2023-08-2 00:00:00').getTime();
	edate = new Date('2023-08-13 00:00:00').getTime();
	
	tdate = (edate-sdate)/(1000*60*60*24)+1;
	$('#sdate').html(sdate);
	$('#edate').html(edate);
	$('#tdate').html(tdate);
})

</script>
</head>
<body>
	<div id="sdate"></div>
	<div id="edate"></div>
	<div id="tdate"></div>
</body>
</html>
<%@page import="com.google.gson.Gson"%>
<%@page import="vo.TourismVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	TourismVO vo = (TourismVO)request.getAttribute("tourVo");
	
	Gson gson = new Gson();
	
	String jsonData = gson.toJson(vo);
	response.setContentType("application/json; charset=utf-8");
	
	out.print(jsonData);

%>
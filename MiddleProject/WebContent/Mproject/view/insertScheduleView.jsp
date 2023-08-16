<%@page import="com.google.gson.Gson"%>
<%@page import="vo.ScheduleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	ScheduleVO vo = (ScheduleVO)request.getAttribute("scheduleVO");

	Gson gson = new Gson();
	
	String jsondata = gson.toJson(vo);
	
	response.setContentType("application/json; charset=utf-8");
	
	out.print(jsondata);
	
	out.flush();
%>
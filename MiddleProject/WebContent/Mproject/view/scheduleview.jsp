<%@page import="vo.ScheduleVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<ScheduleVO> list = (List<ScheduleVO>)request.getAttribute("scheduleList");

	Gson gson = new Gson();
	
	String jsondata = gson.toJson(list);
	
	out.print(jsondata);
	
	out.flush();
%>
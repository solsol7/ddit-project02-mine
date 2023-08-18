<%@page import="vo.CouponVO"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="java.util.List"%>
<%@page import="vo.TourismVO"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	List<CouponVO> list = (List<CouponVO>)request.getAttribute("couponList");
	int sp = (Integer)request.getAttribute("sp");
	int ep = (Integer)request.getAttribute("ep");
	int tp = (Integer)request.getAttribute("tp");
	int size = (Integer)request.getAttribute("size");

	Gson gson = new Gson();

	JsonElement ele = gson.toJsonTree(list);
	
	JsonObject jobj = new JsonObject();
	
	jobj.addProperty("sp", sp);
	jobj.addProperty("ep", ep);
	jobj.addProperty("tp", tp);
	jobj.addProperty("size", size);
	jobj.add("list", ele);
	
	response.setContentType("application/json; charset=utf-8");
	out.print(jobj);

%>
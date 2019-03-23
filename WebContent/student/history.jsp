<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>以往试卷成绩查询</title>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h3 class="subTitle">
		${user.name }，以往试卷成绩查询
		<div class="search">
			<form action="<%=path%>/pastTestServlet" method = "post">
				课程名称 :	<input type="text" name= "courseSearch" value=""> 
				<input type="submit" class="btn_grey" value="搜索">
			</form>
		</div>
	</h3>
	<br />
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table3">
		<tr align="center">
			<td width="138" >考试科目</td>
			<td width="162">试卷名称</td>
			<td width="162">考试时长</td>
			<td width="162">考试时间</td>
			<td width="162">考试得分</td>
		</tr>
		<c:forEach var="paper" items="${paperList}">
			<tr align="center">
				<td>${paper.courseName}</td>
				<td>${paper.testName}</td>
				<td>${paper.time}</td>
				<td>${paper.createDate}</td>
				<td>${paper.score}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
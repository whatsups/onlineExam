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
<title>Insert title here</title>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h3 class="subTitle">
		班级排课管理
		<div class="search">
			<form action="<%=path%>/scheduleQueryServlet" method = "post">
				课程名称 :	<input type="text" name= "courseSearch" value="${courseSearch }"> 
				<input type="submit" class="btn_grey" value="搜索">
			</form>
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=path%>/scheduleAddServlet">新加排课信息</a>
	</h3>
	<br />
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table3">
		<tr align="center">
			<td width="138" height="51">序号</td>
			<td width="162">课程名称</td>
			<!-- <td width="90">所属分类</td> -->
			<td width="171">任课教师</td>
			<td width="120">所教班级</td>
			<td width="94">修改操作</td>
			<td width="116">删除操作</td>
		</tr>
		<c:forEach var="tc" items="${tcList}">
			<tr align="center">
				<td>${tc.tcId}</td>
				<td>${tc.courseName}</td>
				<!-- <td></td> -->
				<td>${tc.teacherName}</td>
				<td>${tc.stuclassName}</td>
				<td><a href="<%=path%>/scheduleModifyServlet?info=${tc.tcId}">修改</a></td>
				<td><a href="<%=path%>/scheduleDeleteServlet?info=${tc.tcId}" onclick="javascript: return confirm('确认删除排课吗？');">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
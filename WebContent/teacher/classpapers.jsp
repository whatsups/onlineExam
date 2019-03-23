<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<title>无标题文档</title>
<style>
</style>
 
</head>

<body>
	<h3 class="subTitle">班级成绩汇总</h3>
	<br />
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table3">
		<tr align="center">
			<td><b>班级</b></td>
			<td><b>考试科目</b></td>
			<td><b>考试名称</b></td>
			<td><b>考试截止时间</b></td>
			<td><b>方向</b></td>
			<td><b>班级平均分</b></td>
		</tr>
		<c:forEach var="paper" items="${paperList }">
			<tr align="center">
				<td>${paper.className }</td>
				<td>${paper.courseName }</td>
				<td>${paper.testName }</td>
				<td>${paper.endDate }</td>
				<td>${paper.deptName }</td>
				<td>${paper.avgScore }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
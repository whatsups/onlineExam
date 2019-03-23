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
<script>
	history.go(1);//屏蔽回退
	document.oncontextmenu = function(e) {
		if (e == null)
			e = window.event;
		e.cancelBubble = true;
		e.returnValue = false;
		return true;//右键屏蔽
	};
</script>
</head>

<body>
	<form action="<%=path%>/testQueryServlet" method="post">
	<h3 class="subTitle">近期考试
					<input type="submit" name="reLoad" value="刷新" align="left" />
				</h3>
	<br />
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table3">
		<tr align="center">
			<td><b>考试科目</b></td>
			<td><b>考试名称</b></td>
			<td><b>考试截止时间</b></td>
			<td><b>考试时长</b></td>
			<td><b>考试对象</b></td>
			<td><b>考试分值</b></td>
			<td width="81"><b>考试状态</b></td>
		</tr>
		<c:forEach var="test" items="${testsList }">
			<tr align="center">
				<td>${test.courseName }</td>
				<td><a href = '<%=path%>/testDetailInfoServlet?id=${test.id}'>${test.name }</a></td>
				<td>${test.endDate }</td>
				<td>${test.testTime }</td>
				<td>${test.classNames }</td>
				<td>${test.scores }</td>
				<td width="81">正在考试</td>
			</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>
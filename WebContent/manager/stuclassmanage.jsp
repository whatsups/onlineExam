<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.text2 {
	width: 700px;
	line-height: 40px;
	font-size: 16px;
	font-family: Arial, "宋体";
	margin: 0 auto;
	margin-top: 20px;
}
-->
</style>
</head>

<body>
	<h3 class="subTitle">
		班级管理
		<div class="search">
			<!-- <form id="form1" method="post"
				action="sys_Find_findClassesManagement.action?currentPage=0">
				<select name="selectk">
					<option selected="selected" value="2">开发方向</option>
					<option value="1">测试方向</option>
				</select> <input type="submit" name="Submit" class="btn_grey" value="搜索" />
			</form> -->
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=path%>/stuClassAddServlet">增加班级</a>
	</h3>
	<br />
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table3">
		<tr align="center">
			<td width="138" height="51">班级编号</td>
			<td width="162">班级名称</td>
			<td width="90">所属属性</td>
			<td width="94">修改操作</td>
			<td width="116">删除操作</td>
		</tr>
		<c:forEach var="sc" items="${scList}"> <!-- 这里scList是起的名字，要和setAttribute的键参数对应 -->
			<tr align="center">
				<td>${sc.id}</td>
				<td>${sc.name}</td>
				<td>${sc.deptName}</td>
				<td><a
					href="<%=path%>/stuClassModifyServlet?info=${sc.id}">修改</a></td>
				<td>没有权限</td>
			</tr>
		</c:forEach>
	</table>
	<br />
</body>
</html>
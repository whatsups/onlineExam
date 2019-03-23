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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>增加试题</title>
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

.paging {
	font-family: Arial, "宋体";
	font-size: 12px;
}
-->
</style>
</head>

<body>
	<form id="form1" method="post" action="<%=path%>/questionQueryServlet">
		<h3 class="subTitle">
			题库管理
			<div class="search">
				<select name="selectk" id="selectk">
					<option selected="selected" value="name">课程科目</option>
					<option value="queTitle">试题题目</option>
				</select> 
				<input type="text" name="searchName" id="searchName" value='' /> <input
					type="submit" name="Submit" class="btn_grey" value="搜索" />
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;<a href='<%=path%>/questionAddServlet'>增加试题</a>
		</h3>
		<br />
	</form>
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table3">
		<tr align="center">
			<td><b>题号</b></td>
			<td><b>考试科目</b></td>
			<td><b>题型</b></td>
			<td><b>题干</b></td>
			<td><b>选项</b></td>
			<td><b>答案</b></td>
			<td><b>操作</b></td>
		</tr>
		<c:forEach var="que" items="${queList}">
			<tr align="left">
				<td width="10">${que.id}</td>
				<td width="20">${que.name}</td>
				<td width="20">单选题</td>
				<td width="40">${que.queTitle}</td>
				<td width="150"><p>A. ${que.choiceA}
						&nbsp;&nbsp;&nbsp;&nbsp; B. ${que.choiceB}</p>
					<p>C. ${que.choiceC} &nbsp;&nbsp;&nbsp;&nbsp; D. ${que.choiceD}</p></td>
				<td width="30" align="center">${que.ans}</td>
				<td width="30"><a
					href='<%=path%>/questionModifyServlet?id=${que.id}'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href='<%=path%>/questionDeleteServlet?id=${que.id}'
					onclick="javascript: return confirm('确认删除试题吗？');">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
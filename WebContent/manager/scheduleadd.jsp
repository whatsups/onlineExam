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
<style>
p {
	text-indent: 2em;
}

textarea {
	　　resize: none;
}

.text2 {
	width: 700px;
	line-height: 40px;
	font-size: 16px;
	font-family: Arial, "宋体";
	margin: 0 auto;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="text2">
		<form action="<%=path%>/scheduleAddServlet" method="post">
			<table width="750" border="0" align="center" class="word_darkGrey">
				<tr>
					<td>课程名称</td>
					<td><select name="course">
							<c:forEach var="course" items="${courseList}">
								<option value="${course.id}">${course.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>讲师姓名</td>
					<td><select name="teacher">
							<c:forEach var="tea" items="${teaList}">
								<option value="${tea.id}">${tea.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>负责班级</td>
					<td><select name="stuclass">
							<c:forEach var="stucl" items="${stuclList}">
								<option value="${stucl.id}">${stucl.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="提交班级排课信息"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

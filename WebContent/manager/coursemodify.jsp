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
		<form
			action="<%=path%>/courseModifyServlet"
			method="post">
			<table>
				<tr><input type="hidden" id="id" name="id" value="${course.id }">
					<td>课程名称</td>
					<td><td><input type="text" id="courname" name="courname" value="${course.name }"></td>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="修改课程关联"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
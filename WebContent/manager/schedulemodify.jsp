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
			action="<%=path%>/scheduleModifyServlet?teaCourId=<%=request.getAttribute("teaCourId")%>"
			method="post">
			<table>
				<tr>
					<td colspan="2" ><h6>课程名称不允许修改,只能修改课程和老师班级之间的关联</h6></td>
				</tr>
				<tr>
					<td>课程名称</td>
					<td><select name="course">
						<c:forEach var="cour" items="${courList}">
							<c:choose>
								<c:when test="${cour.id==tc.courseId}">
									<option value="${cour.id}" selected="selected">${cour.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${cour.id}">${cour.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>讲师姓名</td>
					<td><select name="teacher">
							<c:forEach var="tea" items="${teaList}">
								<c:choose>
									<c:when test="${tea.id==tc.teaId}">
										<option value="${tea.id}" selected="selected">${tea.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${tea.id}">${tea.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>负责班级</td>
					<td><select name="stuclass">
							<c:forEach var="stucl" items="${stuclList}">
								<c:choose>
									<c:when test="${stucl.id==tc.classId}">
										<option value="${stucl.id}" selected="selected">${stucl.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${stucl.id}">${stucl.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
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
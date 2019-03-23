<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/js/calendar-blue.css" rel="stylesheet" type="text/css" />
<style>
p {
	text-indent: 2em;
}

.text2 {
	width: 450px;
	line-height: 40px;
	font-size: 16px;
	font-family: Arial, "宋体";
	margin: 0 auto;
	margin-top: 20px;
}
</style>

</head>

<body>
	<form id="form1" name="form1" class="word_darkGrey" method="post"
		onsubmit="return InputM();"
		action='<%=path%>/testAddServlet'>
		<div class="text2">
			<p>
				<label>考试科目为： <select name="courseid" id="courseid">
						<c:forEach var="course" items="${courseList }">
							<option value="${course.id}">${course.name}</option>
						</c:forEach>
				</select>
				</label>
			</p>

			<p>
				试卷名称为： <label> <input type="text" name="testname"
					id="testname" onblur="isNotNull('testname');" />
				</label> <br />
			</p>
			<p>
				考试截止时间为： <label><input name="enddate" type="text"
					id="control_date" size="20" maxlength="10" readonly="readonly"
					value='' />
					 </label><br />
			</p>

			<p>
				单项选择题（共<input name="sinscores" id="sinscores" type="text" size="1"
					onblur="isNotNull('sinscores');" />分） &nbsp;&nbsp; <label><input
					name="sinnum" type="text" id="sinnum" size="5"
					onblur="isNotNull('sinnum');" /></label> 道小题 <br />
			</p>
			<p>
				考试时间：<label><input name="testtime" id="testtime" value="45"
					type="text" size="5" onblur="isNotNull('testtime')" /></label>分钟
			</p>

			<p>
				面向班级：
				<c:forEach var="stuclass" items="${classesList}">
					<input type="checkbox" name="classCheck" value="${stuclass.id}" checked="checked"/>${stuclass.name}
				</c:forEach>
			</p>
			<p align="center">
				<input type="submit" class="btn_grey" value="自动出题" />&nbsp;&nbsp;&nbsp;&nbsp;<br />
			</p>
		</div>
	</form>
	<p>
<script type="text/javascript" src="<%=path%>/js/calendar.js"></script>
<script>
Calendar.setup({
inputField : "control_date",
ifFormat : "%Y-%m-%d %H:%M:%S",
showsTime : true,
timeFormat : "24"
});
</script>
	</p>
</body>${hint }
</html>
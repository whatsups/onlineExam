<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<h3 class="subTitle">
	近期考试
</h3>
<br />
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0" class="table3">
  <tr align="center">
    <td><b>考试科目</b></td>
    <td><b>考试名称</b></td>
    <td><b>考试截止时间</b></td>
    <td width="81" ><b>进入考试</b></td>
  </tr>
	
<c:forEach items="${testsList}" var="test">
  <tr align="center">
    <td width="113">${test.courseName }</td>
    <td width="260">${test.testName }</td>
    <td width="220">${test.endDate }</td>
    <td width="81" ><a href='studentTest?testId=${test.id}' target="_parent">开始考试</a></td>
  </tr>
</c:forEach>
</table>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<style>
#welcome{
	background-color:#EEF6FF;
	color:#5084BB;
	font-size:16px;
	line-height:19px;
	text-indent:11em;
}
</style>
</head>

<body>
	<img src="../img/logo.jpg" align="top" />
    <div id="welcome">&nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <hr />
</body>
</html>
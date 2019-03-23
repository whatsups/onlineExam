<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.text2 {	width:700px;
	line-height:40px;
	font-size:16px;
	font-family: Arial, "宋体";
	margin:0 auto;
	margin-top:20px;}
-->
</style>
</head>

<body>
<h3 class="subTitle">学生管理
  <div class="search">
        <form id="form1" method="post" action="<%=path %>/studentQueryServlet">
           	 学生姓名：<input type="text" name="name" value='' />
            <input type="submit" name="Submit" class="btn" value="搜索" />
        </form>
  </div>
  &nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=path %>/studentAddServlet">增加学生</a>
</h3>
<br />
<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0" class="table3">
  <tr align="center">
    <td width="127" height="51">学生学号</td>
    <td width="61">姓名</td>
    <td width="40">性别</td>
    <td width="90">出生日期</td>
    <td width="56">登录密码</td>
    <td width="156">原学校</td>
    <td width="68" >课程方向</td>
    <td width="68" >所在班级</td>  
    <td width="87">修改操作</td>
    <td width="87">删除操作</td>
  </tr>
  <c:forEach items="${studentList }" var="s">
	  <tr align="center">
	    <td >${s.id }</td>
	    <td >${s.name }</td>
	    <td >${s.sex }</td>
	    <td >${s.born }</td>
	    <td >${s.pwd }</td>
	    <td >${s.school }</td>
	    <td >${s.deptName }</td>
	    <td >${s.className }</td>
	    <td><a href="<%=path %>/studentModifyServlet?id=${s.id }" target="_self">修改</a></td>
	    <td>无权限</td>
	  </tr>
  </c:forEach>
</table>
<br />
</body>
</html>
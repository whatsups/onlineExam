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
<link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
<style>
p{
	text-indent:2em;}
.text2{
	width:700px;
	line-height:40px;
	font-size:16px;
	font-family: Arial, "宋体";
	margin:0 auto;
	margin-top:20px;}

</style>
</head>

<body>
<h3 class="subTitle">
	修改学生信息 &nbsp;&nbsp;&nbsp;&nbsp;学生编号${student.id }
</h3>
<div class="text2">
  <form action="<%=path %>/studentModifyServlet" method="post" name="form1" id="form1">
    <table width="900" border="0" align="center" class="word_darkGrey">
      <input type="hidden" readonly="readonly" name="id" id="id" value="${student.id }"/>
      <tr>
        <td width="132">姓名：</td>
        <td width="195"><label>
          <input type="text" name="name" id="name" value="${student.name }"/>
        </label></td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><label>
          <input type="password" name="pwd" id="pwd" value="${student.pwd }" />
        </label></td>
      </tr>
            <tr>
        <td width="132">性别：</td>
        <td width="195"><label>
          <input type="radio" value="男"  name="sex"  <c:if test="${student.sex =='男' }">checked="checked"</c:if>/>男
          <input type="radio" value="女"  name="sex"  <c:if test="${student.sex =='女' }">checked="checked"</c:if>/>女
        </label></td>
      </tr>
            <tr>
        <td width="132">出生日期：</td>
        <td width="195"><label>
          <input type="text" name="born" id="born" value="${student.born }"/>
        </label></td>
      </tr>
            <tr>
        <td width="132">原学院：</td>
        <td width="195"><label>
          <input type="text" name="school" id="school" value="${student.school }"/>
        </label></td>
      </tr>
      <tr>
        <td>课程方向：</td>
        <td><select name="deptId"  >
        <c:forEach items="${deptList }" var="deptName">
          <option value='${deptName }'  <c:if test="${deptName ==student.deptName }">selected="selected"</c:if> >${deptName }</option>
        </c:forEach>
        </select></td>
      </tr>
      <tr>
        <td>所在班级：</td>
        <td><select name="classId"  >
        <c:forEach items="${classList }" var="c">
          <option value='${c.id }'  <c:if test="${c.id==student.classid }">selected="selected"</c:if> >${c.name }</option>
        </c:forEach>
        </select></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" name="button" id="button" class="btn_grey" value="提交" />
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
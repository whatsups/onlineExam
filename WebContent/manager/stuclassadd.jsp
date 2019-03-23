<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
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
<script>
	function coursename(eeId) {
		var a = document.getElementById("clanum").value;
		var re = /^[0-9]*$/;
		if (re.test(a)) {
			return true;
		} else {
			var msg = "班级编号只能为数字！";
			showErrorMsg(msg, eeId);
			return false;
		}
	}

	function number(eeId) {
		var a = document.getElementById("claname").value;
		var re = /^[\u4e00-\u9fa5]|[0-9]*$/;
		if (re.test(a)) {
			return true;
		} else {
			var msg = "班级名称只能为中文或数字！";
			showErrorMsg(msg, eeId);
			return false;
		}
	}

	function showErrorMsg(msg, eeId) {
		document.getElementById(eeId).style.display = "";
		document.getElementById(eeId).innerHTML = msg;
	}
	//当获得焦点 错误信息就不显示
	function clearErrorMsg(eId) {
		document.getElementById(eId).style.display = "none";
	}

	function verInput() {
		/**
			revised by yangzhen 2016-01-15
			对班级编号和班级名称做非空验证
		 **/
		var clanum = document.getElementById("clanum").value.replace(
				/(^\s*)|(\s*$)/g, "");
		var claname = document.getElementById("claname").value.replace(
				/(^\s*)|(\s*$)/g, "");
		if (clanum.length == 0) {
			alert("班级编号不能为空！");
			return false;
		}
		if (claname.length == 0) {
			alert("班级名称不能为空！");
			return false;
		}
		if (coursename('name_hint') && number('num_hint')) {
			return true;
		} else {
			alert("修改失败，请按照提示信息修改");
			return false;
		}
	}
</script>
</head>

<body>
	<div class="text2">
		<form action="<%=path%>/stuClassAddServlet" method="post">
			<table width="1200" border="0" align="center" class="word_darkGrey">
				<tr>
					<td>班级编号：</td>
					<td><label> <input type="text" name="clanum"
							id="clanum" />
					</label></td>
					<td align="center"><font color="#FF0000" size="-1"><div
								id="name_hint"></div></font></td>
				</tr>
				<tr>
					<td width="103">班级名称：</td>
					<td width="240"><label> <input type="text"
							name="claname" id="claname" />
					</label></td>
					<td>同一学期的班级名称请不要起重复的名称</td>
					<td width="305" align="center"><font color="#FF0000" size="-1"><div
								id="num_hint"></div></font></td>
				</tr>
				<tr>
					<td>所属方向：</td>
					<td><select name="depInfo">
							<c:forEach var="deptName" items="${depList}">
								<option value="${deptName}">${deptName}</option>
							</c:forEach>
					</select></td>
					<td><font color="#FF0000" size="-1"><div id="ans_hint"></div></font></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><label> <input
							type="submit" name="button" id="button" class="btn_grey"
							value="增加班级" />
					</label></td>
					<td align="center">&nbsp;</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
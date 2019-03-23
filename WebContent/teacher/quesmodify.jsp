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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
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
<script>
	function anscheck(eeId) {
		var a = document.getElementById("ans").value;
		var re = /^[A-D]{1,4}$/;
		if (re.test(a)) {
			return true;
		} else {
			var msg = "正确答案只能为大写英文！";
			showErrorMsg(msg, eeId);
			return false;
		}
	}
	function isNotNull(uuid) {
		var value = document.getElementById(uuid).value;
		if (value == null || value == "") {
			return false;
		} else {
			return true;
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
		var obj = document.getElementById("type");
		var value = obj.selectedIndex;
		if (value == 2) {
			if (anscheck('ans_hint') && isNotNull('ques')
					&& isNotNull('choice_A') && isNotNull('choice_B')) {
				return true;
			} else {
				alert("添加失败，请将信息填写完整、正确！");
				return false;
			}
		} else {
			if (anscheck('ans_hint') && isNotNull('ques')
					&& isNotNull('choice_A') && isNotNull('choice_B')
					&& isNotNull('choice_C') && isNotNull('choice_D')) {
				return true;
			} else {
				alert("添加失败，请将信息填写完整、正确！");
				return false;
			}
		}
	}
	function selectChoice() {
		var obj = document.getElementById("type");
		var value = obj.selectedIndex;
		if (value == 2) {
			document.getElementById("choice_C").style.display = "none";
			document.getElementById("choice_D").style.display = "none";
		}
		if (value == 0 || value == 1) {
			document.getElementById("choice_A").style.display = "block";
			document.getElementById("choice_B").style.display = "block";
			document.getElementById("choice_C").style.display = "block";
			document.getElementById("choice_D").style.display = "block";
		}
	}
</script>
</head>

<body>
	<div class="text2">
		<form id="form1" name="form1" method="post"
			action='<%=path%>/questionModifyServlet'
			onsubmit="return verInput();">
			<input type="hidden" name = "id" value = "${questionMap.id}"/>
			<table width="462" border="0" align="center" class="word_darkGrey">
				<tr>
					<td width="100">科目：</td>
					<td><select name="courseId" id="courseId">
							<c:forEach var="course" items="${courseList}">
								<c:choose>
									<c:when test="${course.id == questionMap.courseId}">
										<option value=${course.id } selected="selected">${course.name}</option>
									</c:when>
									<c:otherwise>
										<option value=${course.id }>${course.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
					<td align="center">&nbsp;</td>
				</tr>
				<tr>
					<td>题目类型：</td>
					<td><select name="queType" id="queType">
							<option value="1" selected="selected">单项选择</option>
					</select></td>
					<td align="center">&nbsp;</td>
				</tr>
				<tr>
					<td width="90">题目：</td>
					<td width="376"><label> <textarea name="queTitle"
								id="queTitle" style="resize: none;">${questionMap.queTitle}</textarea>
					</label></td>
					<td width="182" align="center">&nbsp;</td>
				</tr>
				<tr>
					<td>选项A：</td>
					<td><label> <input type="text" name="choiceA"
							id="choiceA" value='${questionMap.choiceA}' />
					</label></td>
					<td align="center"></td>
				</tr>
				<tr>
					<td>选项B：</td>
					<td><label> <input type="text" name="choiceB"
							id="choiceB" value='${questionMap.choiceB}' />
					</label></td>
					<td align="center"></td>
				</tr>
				<tr>
					<td>选项C：</td>
					<td><label> <input type="text" name="choiceC"
							id="choiceC" value='${questionMap.choiceC}' />
					</label></td>
					<td align="center"></td>
				</tr>
				<tr>
					<td>选项D：</td>
					<td><label> <input type="text" name="choiceD"
							id="choiceD" value='${questionMap.choiceD}' />
					</label></td>
					<td align="center"></td>
				</tr>
				<tr>
					<td>正确答案：</td>
					<td><label> <input type="text" name="ans" id="ans"
							value='${questionMap.ans}' />
					</label></td>
					<td><font color="#FF0000" size="-1"><div id="ans_hint"></div></font></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><label> <input
							type="submit" name="button" id="button" class="btn_grey"
							value="修改试题" />
					</label></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
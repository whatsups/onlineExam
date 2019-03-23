<%@page import="com.hp.onlinexam.po.Question"%>
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
<title></title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
	document.onkeydown = function() {
		if (event.keyCode == 116) {
			event.keyCode = 0;
			event.returnValue = false;
		}
	};
	document.oncontextmenu = function() {
		event.returnValue = false;
	};

	<!--
	function KeyDown() {
		if ((window.event.altKey) && ((window.event.keyCode == 37) || //屏蔽   Alt+   方向键   ←   
		(window.event.keyCode == 39))) { //屏蔽   Alt+   方向键   →   
			alert("不准你使用ALT+方向键前进或后退网页！");
			event.returnValue = false;
		}

		if ((event.keyCode == 8) || //屏蔽退格删除键   
		(event.keyCode == 116)) { //屏蔽   F5   刷新键   
			event.keyCode = 0;
			event.returnValue = false;
		}
		if ((event.ctrlKey) && (event.keyCode == 78)) { //屏蔽   Ctrl+n   
			event.returnValue = false;
		}
		if ((event.shiftKey) && (event.keyCode == 121)) { //屏蔽   shift+F10   
			event.returnValue = false;
		}
	}

	-->
</script>
<style>
#fd {
	position: fixed;
	*position: absolute;
	width: 150px;
	height: 50px;
	top: 50%;
	left: 90%;
	margin: -50px 0 0 -50px;
}

p {
	text-indent: 10em;
}
</style>
</head>

<body onselectstart="return false">
	<script language="JavaScript">
		alert("考试期间禁止刷新页面，如若出错后果自负！");
		//禁止退格键
		/* document.onkeydown = check;
		 function check(e) {
		 var code;
		 if (!e) var e = window.event;
		 if (e.keyCode) code = e.keyCode;
		 else if (e.which) code = e.which;
		 if (((event.keyCode == 8) &&                                                    //BackSpace 
		 ((event.srcElement.type != "text" && 
		 event.srcElement.type != "textarea" && 
		 event.srcElement.type != "password") || 
		 event.srcElement.readOnly == true)) || 
		 ((event.ctrlKey) && ((event.keyCode == 78) || (event.keyCode == 82)) ) ||    //CtrlN,CtrlR 
		 (event.keyCode == 116) ) {                                                   //F5 
		 event.keyCode = 0; 
		 event.returnValue = false; 
		 }
		 return true;
		 } */
	</script>

	<img src="<%=path %>/img/logo.jpg" width="1340" align="top" />

	<div id="main_content">
		<div>
			<form id="form1" name="form1" method="post" action="<%=path %>/studentTest?&testId=${test.id}">
				<div id="fd">
					<span style="color: #ff0000">考试剩余时间</span><br /> <input size="12"
						value="45分00秒" name="input1" id="input1" readonly="readonly"
						style="text-align: center;" /><br />
					<script language="javascript">
						var sec = 59;
						var min = 44;
						var hou = 0;
						flag = 0;
						idt = window.setTimeout("update();", 1000);
						function update() { /*
						if (min==34 && sec==59) {alert("还剩10分钟，请抓紧时间答卷！");}  //当时间到35的时候就提示还有十分钟
						if (min==45) {alert("考试时间结束");FORM1.submit();}  //当到45分的时候就自动提交考卷。
						sec++;
						if(sec==60){sec=0;min+=1;}
						if(min==60){min=0;hou+=1;}
						if((min>0)&&(flag==0)){flag=1;}
						document.forms.input1.value=min+"分"+sec+"秒";
						idt=window.setTimeout("update();",1000);
						 */
							//以下是倒计时实现方式
							if (min == 9 && sec == 59) {
								alert("还剩10分钟，请抓紧时间答卷！");
							} //当时间到35的时候就提示还有十分钟
							if (min == 0 && sec == 0) {
								form1.submit();
							} //当到45分的时候就自动提交
							sec--;
							if (sec == 0 && min > 0) {
								sec = 60;
								min -= 1;
							}
							//if((min>0)&&(flag==0)){flag=1;}
							document.form1.input1.value = min + "分" + sec + "秒";
							idt = window.setTimeout("update();", 1000);
						}
					</script>
				</div>
				<h1>
					<center>${test.testName}</center>
				</h1>
				<div id="time"></div>
				<center>
					<p>${test.courseName} &nbsp;&nbsp;&nbsp; ${test.className}
						&nbsp;&nbsp;&nbsp;${user.name }</p>
				</center>
				<%
					//double sin_score = 100 / sin_ques.size();
					//session.setAttribute("sin_score", sin_score);
				%>
				<p>
					<b>一、单项选择题（${test.scores}分）（每小题${scoreperques}分，错选、未选均不得分。）
					</b>
				</p>
				<c:forEach var="que" items="${quesList}" varStatus="status">
					<p></p>
					<p>${status.index + 1}.${que.queTitle}</p>

					<p>A.${que.choiceA }</p>
					<p>B.${que.choiceB }</p>
					<p>C.${que.choiceC }</p>
					<p>D.${que.choiceD }</p>
					<p>
					A.<input type="radio" name = "ques_${que.id}" value = "A"/>
					B.<input type="radio" name = "ques_${que.id}" value = "B"/>
					C.<input type="radio" name = "ques_${que.id}" value = "C"/>
					D.<input type="radio" name = "ques_${que.id}" value = "D"/>
					</p>
				</c:forEach>

				<p>&nbsp;</p>

				<p class="text"></p>
				<p>&nbsp;</p>
				<label>
					<center>
						<input type="submit" name="button" id="button" value="交卷"
							onclick="javascript: return confirm('确认要交卷吗？');" />
					</center>
				</label> <input type="hidden" size="8" value="0时0分0秒" name="hidden1" />
				<script>
					var sec1 = 0;
					var min1 = 0;
					var hou1 = 0;
					flag1 = 0;
					idt1 = window.setTimeout("update22();", 1000);
					function update22() {
						sec1++;
						if (sec1 == 60) {
							sec1 = 0;
							min1 += 1;
						}
						if (min1 == 60) {
							min1 = 0;
							hou1 += 1;
						}
						if ((min1 > 0) && (flag1 == 0)) {
							flag1 = 1;
						}
						document.form1.hidden1.value = min1 + "分" + sec1 + "秒";
						idt1 = window.setTimeout("update22();", 1000);
					};
				</script>
			</form>
		</div>
	</div>

</body>
</html>
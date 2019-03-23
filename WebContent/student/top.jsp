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
    <script language="javaScript">
    <!--//
		now = new Date(),hour = now.getHours(); 
		if(hour < 6){document.write("凌晨好！");}
		else if (hour < 9){document.write("早上好！");} 
		else if (hour < 12){document.write("上午好！");} 
		else if (hour < 14){document.write("中午好！");} 
		else if (hour < 17){document.write("下午好！");} 
		else if (hour < 19){document.write("傍晚好！");} 
		else if (hour < 22){document.write("晚上好！");}
		else {document.write("夜里好！");}
	// -->
	</script>
   欢迎您，  同学！&nbsp;&nbsp;    
          今天是 
            <script language="JavaScript"><!--
	var dayNames = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
var Stamp = new Date();
document.write("" + Stamp.getFullYear() + "年"+(Stamp.getMonth() + 1) +"月"+Stamp.getDate()+ "日"+ " " + dayNames[Stamp.getDay()] +"");
// -->
</script>
    </div>
    <hr />
</body>
</html>
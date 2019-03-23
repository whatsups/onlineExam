<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>login.jsp</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="<%=path%>css/style.css" rel="stylesheet" type="text/css" />
<style>
#wrapper {
	background-image: url(img/login.jpg);
	background-repeat: no-repeat;
	background-position: 0px 0px;
	height: 348px;
	width: 684px;
	margin-top: 150px;
	margin-right: auto;
	margin-left: auto;
}

.login {
	height: 140px;
	width: 222px;
	float: right;
	margin-top: 93px;
	margin-right: 101px;
	padding-top: 50px;
	padding-left: 55px;
	display: inline;
}

.login div {
	margin-top: 15px;
	margin-bottom: 15px;
	height: 22px;
}

.login #type {
	font-family: Arial, "宋体";
	font-size: 12px;
}

.login #username {
	border: 1px solid #0F509F;
	width: 160px;
	height: 16px;
}

.login #password {
	border: 1px solid #0F509F;
	width: 160px;
	height: 16px;
}

.login .button {
	padding-left: 0px;
}

.login .button input {
	background-color: #999;
	height: 20px;
	width: 60px;
	font-family: Arial, "宋体";
	font-size: 12px;
	font-weight: bold;
	color: #FFFFFF;
	background-repeat: repeat-x;
	background-position: 0px 0px;
	border: 1px solid #999;
	line-height: 18px;
}
</style>
<script type="text/javascript">
	if(window != top){
		top.location.href = location.href;
	}
</script>
</head>

<body>
	<div id="wrapper">
		<form action="<%=path%>/loginServlet" method="post">
			<div class="login">
				<div>
					<input type="text" name="username" id="username" />
				</div>
				<div>
					<input type="password" name="password" id="password" />
				</div>
				<div>
					<label> <select name="role" id="role">
							<option value="admin">管理员</option>
							<option value="teacher" >教师</option>
							<option value="student" selected="selected" >学生</option>

							</select>
					</label>
				</div>
				<div class="button">
					<input type="submit" name="Submit" value="登录" /> <input
						type="reset" name="Submit" value="重置" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<script> 

//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error")%>';
  if(errori=='yes'){
   alert("用户名或密码错误!");
  }
</script>

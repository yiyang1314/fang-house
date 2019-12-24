<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
	String url=request.getScheme()+"://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/";
	//http://localhost:8080/dingingroom/

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WEB-INFO-修改用户信息</title>
	<link href="url" type="text/css">
	<link href="admin/css/adminstyle.css" rel="stylesheet">
	<style type="text/css">
		table{
			margin-left:45px;
			margin-top:45px;
			width:600px;
			border:solid 2px black;
		}
		th{
			border-right:solid 2px black;
			width:100px;
		}
		tr{
			border-right:solid 2px black;
			border-top:solid 2px black;
		}
	</style>
</head>
<body>

	<h1>在线修改</h1>
	<div class="w3ls-login box">
		<!-- form starts here -->
		<form action="user_save" method="post" style="width:850px;">
		
			<div class="agile-field-txt">
				用户名：<input type="text" name="username" value="${user.loginname}" />
			</div>
			<div class="agile-field-txt">
			 密码：<input type="password" name="password"  value="${user.loginpwd}" id="myInput" />
			</div>
			<div class="agile-field-txt">
				真实名称：<input type="text" name="realname" value="${user.realname}"  id="myInput" />
			</div>
			<input type="hidden" name="userid" value="${user.userid}"/>
			<div class="w3ls-bot">
				<input type="submit" value="保存">
			</div>
		</form>
	</div>	

	<!--copyright-->
	<div class="copy-wthree">
		<p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="#">版权专利</a></p>
	</div>
	<!--copyright-->
</body>
</html>
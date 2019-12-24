<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
	String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basepath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>WEB-INFO-马上注册</title>
		<link href="url" type="text/css">
		<link href="admin/css/adminstyle.css" rel="stylesheet">
	</head>
	<body>

	<h1>在线注册</h1>
	<div class="w3ls-login box">
		<!-- form starts here -->
		<form action="user_save" method="post">
			<input type="hidden" name="userid" value=""/>
			<div class="agile-field-txt">
				<input type="text" name="username" placeholder="用户名"/>
			</div>
			<div class="agile-field-txt">
				<input type="password" name="password"   placeholder="密码" id="myInput" />
			</div>
			<div class="agile-field-txt">
				<input type="password" name="pwd"   placeholder="确认密码"  id="myInput" />
			</div>
			<div class="agile-field-txt">
				<input type="text" name="realname"  placeholder="真实姓名"  id="myInput" />
			</div>
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
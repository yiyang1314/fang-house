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
		<title>紧急警告</title>
		<link href="url" type="text/css">
		<link href="admin/css/adminstyle.css" rel="stylesheet">
	</head>
	<body>

	<h1>${resultmap.msg} </h1>
	<h1>${msg} </h1>
	<!--copyright-->
	<div class="copy-wthree">
		<p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="#">版权专利</a></p>
	</div>
	<!--copyright-->
</body>
</html>
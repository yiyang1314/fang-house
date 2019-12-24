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
	<link href="url" type="text/css">
	<link href="admin/css/adminstyle.css" rel="stylesheet">
</head>
<body>
	<h1>在线 ${h.houseid==null?'添加':'修改' }</h1>
	<form action="house_save" method="post" style="width:850px;">
			<input type="hidden" name="houseid" value="${h.houseid }"/>
		<p class="w3ls-bot">标&nbsp;&nbsp;&nbsp;&nbsp;题：
			<input type="text" name="title" value="${h.title}"/> </p>
		<p class="w3ls-bot">图片路径：<input type="text" name="picpath" value="${h.picpath}"/> </p>
		<p class="w3ls-bot">房产简介：<input type="text" name="summary" value="${h.summary}"/> </p>
		<p class="w3ls-bot">内容路径：<input type="text" name="contentUrl" value="${h.contentUrl}"/> </p>
		<p class="w3ls-bot">菜单导航：<input type="text" name="menuid" value="${h.menuid}" /></p>
		<p class="w3ls-bot">状&nbsp;&nbsp;&nbsp;&nbsp;态：<input type="text" value="${h.houseStatus}" name="houseStatus" /> </p>
		<p class="w3ls-bot" style="text-align:center;">
			<input type="submit" value="&nbsp;保存&nbsp;" />
			<input type="reset" value="&nbsp;重&nbsp;置&nbsp;" />
		</p>
	</form>	
	
	<!--copyright-->
	<div class="copy-wthree">
		<p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="#">版权专利</a></p>
	</div>
	<!--copyright-->
</body>
</html>
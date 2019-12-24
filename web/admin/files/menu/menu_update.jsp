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
	<h1>菜单${menu.menuid==null?'添加':'修改'}</h1>${menus}
	<form action="menu_save" method="post" style="width:850px;">
			<input type="hidden" name="menuid" value="${menu.menuid }"/>
		<p class="w3ls-bot">菜单名称：
			<input type="text" name="menuName" value="${menu.menuName}"/> </p>
		<p class="w3ls-bot">图片路径：<input type="text" name="picpath" value="${menu.picpath}"/> </p>
		<p class="w3ls-bot">菜单链接：<input type="text" name="menuUrl" value="${menu.menuUrl}"/> </p>
		<p class="w3ls-bot">上级id：<input type="text" name="parentid" value="${menu.parentid}" /></p>
		<p class="w3ls-bot">启用状态：<input type="text" value="${menu.menuStatus}" name="menuStatus" /> </p>
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
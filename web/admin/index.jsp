<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//System.out.println("basepath:"+basepath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
	<head>
		<base href="<%=basepath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>房地产后台管理系统</title>
		<link rel="shortcut icon" href="favicon.ico"  type="image/x-icon" >
		<script type="text/javaScript">
		function getLoginname(username){
			if(username==''){
				location.href="admin/login.jsp";
			}else{
				alert("欢迎您，"+username+"进入后台管理主页");
			}
		}
		
		</script>
	</head>

<frameset rows="59,*" onload="getLoginname('${sessionScope.u.loginname}')" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="admin/files/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="213,*" frameborder="no" border="0" framespacing="0">
    <frame src="admin/files/left.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="admin/files/mainfra.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<noframes><body>
</body>
</noframes></html>

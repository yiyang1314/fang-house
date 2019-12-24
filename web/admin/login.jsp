<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//System.out.println("basepath:"+basepath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basepath%>" />
	<link rel="shortcut icon" href="favicon.ico"  type="image/x-icon" >
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>房产后台管理系统 www.fang.com</title>
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
	}
	-->
</style>
<script type="text/javaScript">

//刷新验证码
function changeImg(){
    document.getElementById("validateCodeImg").src="code?id="+Math.random();
    return ;
 }
//
function checkuser(username){
   if(username==''){
	  location.href="admin/index.jsp";
   }
 }

</script>
<link href="admin/css/css.css" rel="stylesheet" type="text/css" />
</head>

<body load="checkuser('${sessionScope.u.loginname}')">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="admin/images/top02.gif"><img src="admin/images/top03.gif" width="776" height="147" /></td>
  </tr>
</table>
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="admin/images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="admin/images/line01.gif" width="5" height="292" /></td>
      </tr>
    </table></td>
    <td>
    	<form action="user_login" method="post">
    		<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="31%" height="35" class="login-text02">用户名称：<br /></td>
						<td width="69%"><input name="username" type="text" size="30" /></td>
					</tr>
					<tr>
						<td height="35" class="login-text02">密 码：<br /></td>
						<td><input name="password" type="password" size="33" /></td>
					</tr>
					<tr>
						<td height="35" class="login-text02">验证码：<br /></td>
						<td>
						<img alt="验证码看不清，换一张" src="code" id="validateCodeImg" onclick="changeImg()" />
						<a href="javaScript:void(0)" onclick="changeImg()">看不清，换一张</a>
						</td>
					</tr>
					<tr>
						<td height="35" class="login-text02" >验证码：</td>
						<td>
							<input name="code" type="text" size="30" />
							
							
						</td>
					</tr>
					<tr>
						<td height="35">&nbsp;</td>
						<td>
							<input name="Submit2" type="submit" class="right-button01" value="确认登陆" /> 
							<input name="Submit232" type="reset" class="right-button02" value="重 置" />
							
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<span>${msg }</span>
						</td>
					</tr>
				</table>
			</form>		
		</td>
  </tr>
</table>
</body>
</html>
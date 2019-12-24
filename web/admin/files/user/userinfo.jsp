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
	<title>用户信息</title>
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
<script>
function update (id){
	if(confirm("你确定要修改信息吗?")){
		location.href='user_updateById?userid='+id;
	}
}

</script>
</head>
<body>

		<h1>WEB-INFO-用户管理列表</h1>

	<div class="w3ls-login box">
		

	
		<table border="2"  >
			<tr >
			 <th>用户名   	</th>
			  <td>${user.loginname }</td>
			</tr>
			<tr >
			 <th>密码   	</th>
 			 <td>${user.loginpwd}</td>
			</tr>	
			<tr >
			 <th>昵称		</th>
			  <td>${user.realname }</td>
			</tr>
			<tr >
			 <th>操作   	</th>
			 <td >
			 	<input type="button" value=" 修改" onclick="update(${user.userid })">
			 </td>
			</tr>	
	</table>
	</div>
	<!--copyright-->
	<div class="copy-wthree">
		<p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="#">版权专利</a></p>
	</div>
	<!--copyright-->
</body>
</html>
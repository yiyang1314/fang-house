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
		location.href='news_updateById?newsid='+id;
	}
}

</script>
</head>
<body>

		<h1>新闻信息</h1>
		<table border="2"  >
			<tr >
			 <th>标题：   	</th>
			  <td>${news.title }</td>
			</tr>
			<tr >
			 <th>图片路径	</th>
 			 <td>${news.picpath}</td>
			</tr>	
			<tr >
			 <th>新闻摘要	</th>
			  <td>${news.summary }</td>
			</tr>
						<tr >
			 <th>新闻地址 	</th>
			  <td>${news.contentUrl }</td>
			</tr>
			<tr >
			 <th>新闻类型</th>
 			 <td>${news.menuid}</td>
			</tr>
			<tr >
			 <th>发布时间</th>
			  <td>${news.publishTime}</td>
			</tr>	
			<tr >
			 <th>新闻状态</th>
			  <td>${news.newStatus}</td>
			</tr>
			<tr >
			 <th>操作   	</th>
			 <td >
			 	<input type="button" value=" 修改" onclick="update(${news.newid })">
			 </td>
			</tr>	
	</table>
	<!--copyright-->
	<div class="copy-wthree">
		<p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="#">版权专利</a></p>
	</div>
	<!--copyright-->
</body>
</html>
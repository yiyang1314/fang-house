<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//System.out.println("basepath:"+basepath);
%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basepath%>" />
			<title>房地产公司宽屏网站</title>
	<link href="client/e/templates/150716/style.css" type="text/css" rel="stylesheet" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
		<script src="client/e/js/function.js" type="text/javascript"></script>
		<script type="text/javascript">
		$(function() {
			Slide_Focus("js_slide_focus_13", 0, 5, 203,160, false);
			marquee("m_181_0", "left", 1500);
			
			//先获取first页面的内容的高度
			var h = document.documentElement.offsetHeight||document.body.offsetHeight;
			$(parent.document.getElementById("contactframe")).height(h);
			var  parentheight=$(parent.document.getElementById("contactframe")).height();
			
			$(parent.document.getElementById("contactframe")).parent().height(parentheight+2);
			//var hh=$(parent.parent.document.getElementById("aboutframe")).height();
			alert($(parent.document.getElementById("contactframe")).parent().height());
		});
		</script>
		<style type="text/css">
		.lxtable {
			border-collapse: collapse;
			border: 1px solid #cccccc;
			width: 100%
		}
		
		.lxtable td {
			border: 1px solid #cccccc;
			padding: 5px
		}
		</style>
	</head>	
<body>
<div class="sublanmu_content sublanmu_content_introduct">
		<style type="text/css">
	.lxtable {
		border-collapse: collapse;
		border: 1px solid #cccccc;
		width: 100%
	}
	
	.lxtable td {
		border: 1px solid #cccccc;
		padding: 5px
	}
	</style>
					<img src="client/e/upload/s1/fck/image/2015/05/25/1604425781.gif"
						alt="" height="122" vspace="5" width="520" /><br />
					<table class="lxtable ke-zeroborder" border="0" cellpadding="0"
						cellspacing="0" align="center">
						<tbody>
							<tr>
								<td height="21" bgcolor="#e8e8e8" width="20%">
									<div align="center">公司名称：</div>
								</td>
								<td height="21" width="80%">中山市华拓网络技术服务中心</td>
							</tr>
							<tr class="L15">
								<td bgcolor="#e8e8e8" width="20%">
									<div align="center">通讯地址：</div>
								</td>
								<td width="80%">广东省中山市南头金湾广场B座16号</td>
							</tr>
							<tr class="L15">
								<td bgcolor="#e8e8e8">
									<div align="center">邮政编码：</div>
								</td>
								<td>528427</td>
							</tr>
							<tr class="L15">
								<td bgcolor="#e8e8e8" width="20%">
									<div align="center">销售电话：</div>
								</td>
								<td width="80%">0760-22517083</td>
							</tr>
							<tr class="L15">
								<td bgcolor="#e8e8e8" width="20%">
									<div align="center">购买咨询：</div>
								</td>
								<td width="80%"><a target="_blank"
									href="http://wpa.qq.com/msgrd?V=1&amp;uin=14837715&amp;Site=pageadmin&amp;Menu=yes"><img
										src="http://wpa.qq.com/pa?p=1:14837715:4" alt="14837715"
										height="16" border="0" vspace="3" align="absMiddle" />14837715</a>（授权）
									&nbsp;&nbsp; <a target="_blank"
									href="http://wpa.qq.com/msgrd?V=1&amp;uin=190452532&amp;Site=pageadmin&amp;Menu=yes"><img
										src="http://wpa.qq.com/pa?p=1:190452532:4" alt="190452532"
										height="16" border="0" vspace="3" align="absMiddle" />190452532</a>（定制）
								</td>
							</tr>
							<tr class="L15">
								<td bgcolor="#e8e8e8" width="20%">
									<div align="center">传真号码：</div>
								</td>
								<td width="80%">0760-86744123</td>
							</tr>
						</tbody>
					</table>
					<p>&nbsp;</p>
					<br />
				</div>
</body>
</html>
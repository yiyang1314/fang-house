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
			//console.log(document.documentElement.offsetHeight);
			
			//进入父页面，设置iframe的height属性的值
			//parent.document.getElementById("mainframe").setAttribute("height",h);
			//$(parent.document.getElementById("mainframe")).attr("height",h);
			$(parent.document.getElementById("menuframe")).height(h);
		
			
		});
		</script>
	</head>	
<body>
	<div class="sublanmu_content sublanmu_content_introduct">
							<p style="display: block">
								<font color="#555555"><a target="_blank"
									href="http://www.pageadmin.net../e/upload/s1/fck/image/v2.jpg"><img
										vspace="5" hspace="5" border="0" align="right" alt=""
										src="../e/upload/s1/fck/image/2011-05/13163518[1].jpg" /></a></font>PageAdmin
								CMS是一款支持多分站、多语种，集成内容发布、信息发布、自定义表单、自定义模型、会员系统、业务管理等功能于一体的网站管理系统，于2009年正式发布，目前全国用户已经超过50万以上，被广泛用于企业、中小学、大专院校，政府部门的网站搭建。<br />
								&nbsp;<br /> <strong>PageAdmin特点</strong><br />
								&nbsp;&nbsp;&nbsp; 1、简单易用、强大灵活：以前开发一个网站只能找网络公司，
								做出的网站管理后台功能简单，导致后期维护、修改和扩展困难，甚至只能付费让制作公司维护，PageAdmin强大的功能、易用性、灵活扩展性完美的解决
								了这些问题。因为系统经过多年发展，其间综合了大量用户的切身使用体验，大大小小经过上百次的升级更新，在操作上不断追求人性化，功能上在也日趋完善，其
								中的自定义表单+自定义模型功能更是让用户可以轻松开发出自己的个性化功能。<br /> <br />
								&nbsp;&nbsp;&nbsp;
								2、高负载功能：一个网站负载功能在网站访问量或内容量巨大时至关重要，pageadmin通过生成静态化和数据库连接优化两个方面来提高网站的负载能力。<br />
								&nbsp;&nbsp;&nbsp;
								2.1、生成静态可以保证用户打开页面时不必连接数据库，从而大大提高页面访问速度和节约服务器资源；<br />
								&nbsp;&nbsp;&nbsp;
								2.2、采用特有的技术手段对每个表的连接都进行优化处理，保证无用字段数据不会被读取，通过实际测试，在采用sqlserver数据库的前提
								下，pageadmin的子栏目列表页读取100万数据表耗时3秒左右，实际应用中都是有条件的提取数据，所以速度会更快。
							</p>
							<p>&nbsp;&nbsp;&nbsp;
								3、样式和内容分离：系统主体框架div+css结构，遵循国际最新W3C网页设计标准，兼容IE系列、火狐等主流浏览器，内容和样式分离让网站风格可以轻松修改和更换，而不会导致内容和结构的破坏。</p>
							<p>&nbsp;&nbsp;&nbsp;
								4、周密的安全策略和攻击防护：对SQL参数进行敏感字符过滤、对密码、cookie进行了不可逆加密处理，数据库备份功能、对管理员权限的自由分配等，在方方面面保证了系统的安全和稳定。</p>
							
							<p>&nbsp;&nbsp;&nbsp;
								更多功能请下载系统自行体验，只要足够熟练，您想到的，PageAdmin就能做到......</p>
							<p style="display: block"></p>
						</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path=request.getContextPath();
	String url=request.getScheme()+"://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+"/";
	//http://localhost:8080/dingingroom/
%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html>
<html>
<head>
	<base href="<%=url%>" />
	<title>房地产公司宽屏网站</title>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
	<meta name="keywords" content="PageAdmin企业网站管理系统" />
	<meta name="Author" content="PageAdmin CMS" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<link href="client/e/templates/150716/style.css" type="text/css" rel="stylesheet" />
	<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
	<script src="client/e/js/function.js" type="text/javascript"></script>
	<script src="client/e/js/script.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(function() {
		
	});
	
	</script>
</head>
<body>
	<div class="page_style lanmupage page_l61">
		<!-- 头部导航部分开始 -->
		<div class="top_box">
			<div class="top_box_inner">
				<div class="topcontent">
					<div class="weibo">
						<a href="" class="xinl">新浪微博</a><a href="" class="tengx">腾讯微博</a>
					</div>
				</div>
				<div class="clear"></div>
				<div class="logo">
					<a href=""><img src="client/e/images/logo.jpg" border="0"></a>
				</div>
				<div class="menu_box" id="Menu">
					<ul>
						<li class="menu_style_homepage menu_current" id="MenuItem61" name="MenuItem">
							<a href="" class="menu">首页</a>
						</li>
						<c:forEach var="menu" items="${menu_list }" varStatus="index">
						<li class="menu_style" >
							<a href="${menu.menuUrl }"  target="mainframe" scrolling="no"    class="menu">${menu.menuName }</a>
						</li>
						
						</c:forEach>

						
						
					</ul>
				</div>
			</div>
		</div>
		<!-- 头部导航部分结束 -->
		
		<!-- 中间大图部分开始 -->
		<div class="banner">
			<div style="background: url(client/e/images/banner/tt33.jpg) no-repeat center top; height: 355px;">
				<div style="width: 980px; margin: 0 auto;">
					<div style="padding: 100px 0px 0 100px;">
						<div style="font-size: 30px; fint-weight: bold; color: white; font-family:'黑体';">
							筑造<span style="font-size: 26px; margin-left: 20px;">幸福中国</span>
						</div>
						<div style="font-size: 24px; fint-weight: bold; color: white;">
							BUILD HAPPY</div>
						<div style="font-size: 14px; fint-weight: bold; color: white;">
							没有目标的未来 只能由此止步</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 中间大图部分结束 -->
		
		<!-- 主体部分开始      scrolling="no" -->
		<iframe id="mainframe" name="mainframe"  src="client/firstpage/first.jsp" frameborder="0" width="100%"  ></iframe>
		
		<!-- 主体部分结束 -->
		
		<div class="bottom_box">
			<div class="db">
				<div class="db_1">
					<img src="client/e/images/home/db_logo.jpg" />
				</div>
				<div class="db_2">
					<div class="db_2_1">
						<a href="#">网站首页</a> | 
						<a href="#">关于我们</a> | 
						<a href="#">新闻中心</a> | 
						<a href="#">公司业务</a> | 
						<a href="#">人才招聘</a> | 
						<a href="#">联系我们</a>
					</div>
					<div class="db_2_2">电话：0760-22517081 地址：广东省中山市南头金湾广场B座16号</div>
				</div>
				<div class="db_3">
					<img src="client/e/images/home/ewm.jpg" />
				</div>
			</div>
			<p style="padding-bottom: 20px;" align="center">
				PageAdmin<a target="_blank" href="http://www.pageadmin.net/">网站管理系统</a>版权所有&nbsp;Copyright
				<span style="font-family: Arial;">&copy;</span>
				2008-2009&nbsp;&nbsp; 
				<a href="http://www.pageadmin.net/" target="_blank">www.pageadmin.net</a>
			</p>
		</div>
		<div align='center' style='padding: 5px'>
			Powered by <a href='http://www.pageadmin.net' target='_blank'><strong>PageAdmin CMS</strong></a>
		</div>
	</div>
</body>
</html>
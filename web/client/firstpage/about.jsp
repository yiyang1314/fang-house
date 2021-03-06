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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>公司简介-房地产公司宽屏网站模板</title>
		<meta name="Author" content="PageAdmin CMS" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<link href="client/e/templates/150716/style.css" type="text/css" rel="stylesheet" />
		<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
		<script src="client/e/js/function.js" type="text/javascript"></script>
		<script src="client/e/js/script.js" type="text/javascript"></script>
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
		$(parent.document.getElementById("mainframe")).height(h);
	
		
	});
	</script>
	</head>
<body>
			<!--关于我们--开始 -->
		<div class="main_box main_box_style1">
			<div class="main_box_inner">
			
				<div class="main_box_inner_left">
					<!--关于公司导航--开始 -->
					<div id="nav_104" class="nav_box nav_box_menu">

						<div class="nav_title">
							<span class="nav_sign">关于我们</span><span class="nav_more"></span>
						</div>
						<div id="nav_menu_104" class="nav_menu">
							<ul id="rootul_104">
<!-- 								<li id="sl564"><a href="#" class="sla564">公司简介</a></li> -->
<!-- 								<li id="sl565"><a href="#" class="sla565">组织架构</a></li> -->
<!-- 								<li id="sl566"><a href="#" class="sla566">发展历程</a></li> -->
<!-- 								<li id="sl625"><a href="#" class="sla625">公司场景</a></li> -->
<!-- 								<li id="sl636"><a href="#" class="sla636">公司荣誉</a></li> -->
								
								<c:forEach var="menu" items="${about_nemu_list}" >
									<li id="sl636" >
										<a target="aboutframe" href="${menu.menuUrl }?menuid=${menu.menuid}"  class="sla625">${menu.menuName }</a>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<!--关于公司导航--结束 -->
					<script type="text/javascript">
					//	shut_allsubnav("rootul_104");
					//	expand_subnav("sl564", "0");
					</script>
					<!-- 联系我们--开始 -->
					<div style="border: 1px solid #CCCCCC; margin-top: 20px;">
						<div style="padding-top: 5px;:">
							<img src="client/e/images/home/call.gif">
						</div>
						<div style="padding: 10px;">
							<ul>
								<li>热线：0854-8888888</li>
								<li>邮箱：feiqqe@163.com</li>
								<li>传真：0554-tx83989385</li>
								<li>地址：中国某某市某某区某某街某某栋某某号</li>
							</ul>
						</div>
					</div>
					<!-- 联系我们--结束 -->

				</div>
				<!--公司右侧--开始 -->
				<div class="main_box_inner_right">
					<!--banner--开始 -->
					<div class="smallbanner">
						<div style="border: 1px solid #CBCBCB; padding: 3px 3px 0 3px;">
							<img src="client/e/images/home/nut_2.jpg">
						</div>
					</div>
					<!--banner--结束 -->
					<!--导航位置   --开始 -->
					<div class="current_location current_location_564">
						<ul>
							<li class="current_location_1">当前位置：<a href= />首页</a> &gt; <a
								href="../about/">关于我们</a> &gt; <a href="#">公司简介</a></li>
							<li class="current_location_2">公司简介</li>
						</ul>
					</div>
					<!--导航位置   --结束 -->
					
					<!--内容面板---开始 -->
					<div class="sublanmu_box sublanmu_box_564">
						<iframe id="aboutframe" name="aboutframe" src="client/firstpage/about/container_about.jsp" 
						onload="this.height=this.contentWindow.document.documentElement.scrollHeight" 
						frameborder="0" width="100%"   >
						</iframe>
						
					</div>
					<!--内容面板---结束 -->
				</div>
				<!--公司右侧--结束 -->
			</div>
			<div class="clear main_box_inner_bottom"></div>
		</div>
		<!--关于我们--结束 -->
</body>
</html>
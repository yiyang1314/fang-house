<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//System.out.println("basepath:"+basepath);
%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basepath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>房地产公司宽屏网站</title>
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
<div class="main_box main_box_style1">
			<div class="main_box_inner">
				<div class="main_box_inner_left">
					<div id="nav_106" class="nav_box nav_box_menu">

						<div class="nav_title">
							<span class="nav_sign">项目展示</span><span class="nav_more"></span>
						</div>
						<div id="nav_menu_106" class="nav_menu">
							<ul id="rootul_106">
<!-- 								<li id="sl653"><a href="#" class="sla653">精品住宅</a> -->
<!-- 								<ul> -->
<!-- 										<li id="sl658"><span></span><a href="#" class="sla658">高层至尊</a></li> -->
<!-- 										<li id="sl659"><span></span><a href="#" class="sla659">田园别墅</a></li> -->
<!-- 									</ul></li> -->
<!-- 								<li id="sl654"><a href="#" class="sla654">商务办公</a> -->
<!-- 								<ul> -->
<!-- 										<li id="sl660"><span></span><a href="#" class="sla660">东部地区</a></li> -->
<!-- 										<li id="sl661"><span></span><a href="#" class="sla661">西部地区</a></li> -->
<!-- 									</ul></li> -->
<!-- 								<li id="sl655"><a href="#" class="sla655">高端休闲</a> -->
<!-- 								<ul> -->
<!-- 										<li id="sl662"><span></span><a href="#" class="sla662">东部地区</a></li> -->
<!-- 										<li id="sl663"><span></span><a href="#" class="sla663">西部地区</a></li> -->
<!-- 									</ul></li> -->
<!-- 								<li id="sl656"><a href="#" class="sla656">商贸会展</a> -->
<!-- 								<ul> -->
<!-- 										<li id="sl664"><span></span><a href="#" class="sla664">东部地区</a></li> -->
<!-- 										<li id="sl665"><span></span><a href="#" class="sla665">西部地区</a></li> -->
<!-- 									</ul></li> -->
								<c:forEach items="${server_nemu_list}" var="menu">
								<li id="sl657"><a href="${menu.menuUrl }?menuid=${menu.menuid}" target="serverframe"    class="sla657">${menu.menuName }</a>
<!-- 								<ul> -->
<!-- 										<li id="sl666"><span></span><a href="#" class="sla666">东部地区</a></li> -->
<!-- 										<li id="sl667"><span></span><a href="#" class="sla667">西部地区</a></li> -->
<!-- 								</ul> -->
								</li>
								</c:forEach>
							</ul>
						</div>
					</div>
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

				</div>
				<div class="main_box_inner_right">
					<div class="smallbanner">
						<div style="border: 1px solid #CBCBCB; padding: 3px 3px 0 3px;">
							<img src="client/e/images/home/nut_4.jpg">
						</div>
					</div>
					<div class="current_location current_location_658">
						<ul>
							<li class="current_location_1">当前位置：<a href= />首页</a> &gt; <a
								href="../server/" class="cl_1">项目展示</a> &gt; <a href="#">精品住宅</a>
								&gt; <a href="#">高层至尊</a></li>
							<li class="current_location_2">高层至尊</li>
						</ul>
					</div>
					<div class="sublanmu_box sublanmu_box_658">
						<iframe id="serverframe" 
						onload="this.height=this.contentWindow.document.documentElement.scrollHeight"
						name="serverframe" src="client/firstpage/server/container_server.jsp" frameborder="0" width="100%"   >
						</iframe>
					</div>
				</div>
			</div>
			<div class="clear main_box_inner_bottom"></div>
		</div>

</body>
</html>
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
					<div id="nav_105" class="nav_box nav_box_menu">

						<div class="nav_title">
							<span class="nav_sign">新闻资讯</span><span class="nav_more"></span>
						</div>
						<div id="nav_menu_105" class="nav_menu">
							<ul id="rootul_105">
<!-- 								<li id="sl547"><a href="#" class="sla547">公司新闻</a></li> -->
<!-- 								<li id="sl647"><a href="#" class="sla647">行业动态</a></li> -->
<!-- 								<li id="sl648"><a href="#" class="sla648">媒体报道</a></li> -->
								<c:forEach items="${product_nemu_list}" var="menu">
									<li ><a target="productframe" href="${menu.menuUrl }?menuid=${menu.menuid}" class="sla648">${menu.menuName }</a></li>
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
							<img src="client/e/images/home/nut_3.jpg">
						</div>
					</div>
					<div class="current_location current_location_649">
						<ul>
							<li class="current_location_1">当前位置：<a href= />首页</a> &gt; <a
								href="../product/">业务服务</a> &gt; <a href="#">业务服务</a></li>
							<li class="current_location_2">业务服务</li>
						</ul>
					</div>
					<div class="sublanmu_box sublanmu_box_649">
						<iframe onload="this.height=this.contentWindow.document.documentElement.scrollHeight"
						id="productframe" name="productframe" scrolling="no" src="client/firstpage/product/container_product.jsp" frameborder="0" width="100%"   >
						</iframe>
					</div>
				</div>
			</div>
			<div class="clear main_box_inner_bottom"></div>
		</div>
</body>
</html>
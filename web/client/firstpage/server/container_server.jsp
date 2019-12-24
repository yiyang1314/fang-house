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
			$(parent.document.getElementById("serverframe")).height(h);
			
			var  parentheight=$(parent.document.getElementById("serverframe")).height();
			$(parent.document.getElementById("serverframe")).parent().height(parentheight+2);
			
			
		});
		</script>
	</head>	
<body>
	<div class="sublanmu_content sublanmu_content_article">
		<ul class="tw_article">
		
			<li><span class="pic"><a href="#" target="_self"><img
						src="client/e/upload/s1/article/image/2015/07/t_15144639.jpg"
						border="0" style="width: 150px; height: 150px;"></a></span> <span
				class="title"><a href="#" target="_self" title="XX胜景"
					style="">XX胜景</a></span>
				<p class="introduct">XX康居——城市家庭的健康人居
					幸福在哪里？它来自一点一滴的积累，当它包围在你身边的时候，你感觉不到它的存在，这是难以言说的一种温情，它是如此简单而难得。</p>
			</li>
		
			<li><span class="pic"><a href="#" target="_self"><img
						src="client/e/upload/s1/article/image/2015/07/t_15143424.jpg"
						border="0" style="width: 150px; height: 150px;"></a></span> <span
				class="title"><a href="#" target="_self" title="XX胜景"
					style="">XX胜景</a></span>
				<p class="introduct">XX康居——城市家庭的健康人居
					幸福在哪里？它来自一点一滴的积累，当它包围在你身边的时候，你感觉不到它的存在，这是难以言说的一种温情，它是如此简单而难得。</p>
			</li>
		
			<li><span class="pic"><a href="#" target="_self"><img
						src="client/e/upload/s1/article/image/2015/07/t_15143446.jpg"
						border="0" style="width: 150px; height: 150px;"></a></span> <span
				class="title"><a href="#" target="_self" title="XX胜景"
					style="">XX胜景</a></span>
				<p class="introduct">XX康居——城市家庭的健康人居
					幸福在哪里？它来自一点一滴的积累，当它包围在你身边的时候，你感觉不到它的存在，这是难以言说的一种温情，它是如此简单而难得。</p>
			</li>
		
			<li><span class="pic"><a href="#" target="_self"><img
						src="client/e/upload/s1/article/image/2015/07/t_15143513.jpg"
						border="0" style="width: 150px; height: 150px;"></a></span> <span
				class="title"><a href="#" target="_self" title="XX胜景"
					style="">XX胜景</a></span>
				<p class="introduct">XX康居——城市家庭的健康人居
					幸福在哪里？它来自一点一滴的积累，当它包围在你身边的时候，你感觉不到它的存在，这是难以言说的一种温情，它是如此简单而难得。</p>
			</li>
		
			<li><span class="pic"><a href="#" target="_self"><img
						src="client/e/upload/s1/article/image/2015/07/t_15143545.jpg"
						border="0" style="width: 150px; height: 150px;"></a></span> <span
				class="title"><a href="#" target="_self" title="XX胜景"
					style="">XX胜景</a></span>
				<p class="introduct">XX康居——城市家庭的健康人居
					幸福在哪里？它来自一点一滴的积累，当它包围在你身边的时候，你感觉不到它的存在，这是难以言说的一种温情，它是如此简单而难得。</p>
			</li>
		
			<li><span class="pic"><a href="#" target="_self"><img
						src="client/e/upload/s1/article/image/2015/07/t_15143620.jpg"
						border="0" style="width: 150px; height: 150px;"></a></span> <span
				class="title"><a href="#" target="_self" title="XX胜景"
					style="">XX胜景</a></span>
					<p class="introduct">XX康居——城市家庭的健康人居
						幸福在哪里？它来自一点一滴的积累，当它包围在你身边的时候，你感觉不到它的存在，这是难以言说的一种温情，它是如此简单而难得。</p>
				</li>
		
			</ul>
		
		</div>
					
</body>
</html>
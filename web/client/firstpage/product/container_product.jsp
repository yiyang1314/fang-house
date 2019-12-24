<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//System.out.println("basepath:"+basepath);
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basepath%>" />
<title>房地产公司宽屏网站</title>
<link href="client/e/templates/150716/style.css" type="text/css"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
<script src="client/e/js/function.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		Slide_Focus("js_slide_focus_13", 0, 5, 203, 160, false);
		marquee("m_181_0", "left", 1500);

		//先获取first页面的内容的高度
		var h = document.documentElement.offsetHeight
				|| document.body.offsetHeight;
		$(parent.document.getElementById("productframe")).height(h);

		var parentheight = $(parent.document.getElementById("productframe"))
				.height();
		$(parent.document.getElementById("productframe")).parent().height(
				parentheight + 2);

	});
</script>
</head>
<body>
	<div class="sublanmu_content sublanmu_content_introduct">
		<div class="wp-title_content"
			style="word-wrap: break-word; padding: 10px; border-color: #CCCCCC; border-width: 1px; width: 664px; display: block; border-style: solid;">
			<span style="font-size: 14px; line-height: 200%;"><strong>物业管理</strong></span>
			<br /> 
			<span style="line-height: 200%;">公司与有关政府部门及各个业主立案法团紧密合作，为旗下各主要住宅项目内的住客，提供优质的管理服务</span><br />
			<br /> 
			
			<c:forEach var="house" items="${houseMenuid_list }">
				<br>
				<li>
					<h1>${house.title }</h1>
					
					<p><img style="vertical-align:middle;" src="${house.picpath}" width="100" height="100">${house.summary }</p>
					<a href="${house.contentUrl }">${house.contentUrl }</a>
				</li>
				<hr />
			</c:forEach>
			
			<p>
				<br /> <span style="line-height: 200%;"></span>
			</p>
		</div>
	</div>
</body>
</html>
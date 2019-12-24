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
			//先获取first页面的内容的高度
			var h = document.documentElement.offsetHeight||document.body.offsetHeight;
			var w = document.documentElement.offsetWidth||document.body.offsetWidth;

			$(parent.document.getElementById("newsframe")).height(600);
			$(parent.document.getElementById("newsframe")).width(700);
			
			var  parentheight=$(parent.document.getElementById("newsframe")).height();
			var width=$(parent.document.getElementById("newsframe")).width();
			
			$(parent.document.getElementById("newsframe")).parent().height(parentheight);
			$(parent.document.getElementById("newsframe")).parent().width(width);

		});
		</script>
	</head>	
<body>
<div class="sublanmu_content sublanmu_content_article">
	<ul class="article">

		<li><span class="title"> <a href="#" target="_self"
				title="2014年北京不限购项目成交盘点珠江四季悦城榜上有名" style="">2014年北京不限购项目成交盘点珠江四季悦城榜上有名</a></span>
			<span class="date">2015-07-21</span></li>

		<li><span class="title"> <a href="#" target="_self"
				title="东贸珠宝城翡翠嘉年华京东掀热浪" style="">东贸珠宝城翡翠嘉年华京东掀热浪</a></span> <span
			class="date">2015-07-21</span></li>

		<li><span class="title"> <a href="#" target="_self"
				title="公积金贷款新政释放利好 元旦假期北京二手房买卖火爆" style="">公积金贷款新政释放利好
					元旦假期北京二手房买卖火爆</a></span> <span class="date">2015-07-21</span></li>



		<c:forEach var="news" items="${newsMenuid_list}">
			<li><span class="title" > 
			<a href="${news.menuid }" target="_self"
				title="${news.title}" style="">
				${fn:substring(news.summary, 0,15)}${fn:length(news.summary)>15?'...':''}
				</a>
				</span> <span class="date">${news.publishTime}</span>
			
			<a href="${news.contentUrl}"> ${news.summary}</a>
			<img src="${news.picpath}" alt="找不到" width="100" height="100"/>
				
			</li>
		
		</c:forEach>



		<li><span class="title"> <a href="#" target="_self"
				title="2014中国六大城市群排名:京津冀第三" style="">2014中国六大城市群排名:京津冀第三</a></span> <span
			class="date">2015-07-21</span></li>

	</ul>

</div>
					
</body>
</html>
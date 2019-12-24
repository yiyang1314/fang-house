<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//System.out.println("basepath:"+basepath);
%>
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
<div class="main_box main_box_style">
			<div class="main_box_inner">
				<!-- 主体部分-关于我们 开始 -->
				<div class="ab_us">
					<div class="tit">
						<img src="client/e/images/home/ab_us.gif" />
					</div>
					<div class="con">
						<div class="wp-title_content" style="word-wrap: break-word; padding: 0px; border-color: #CCCCCC; border-width: 0px; height: 132px; width: 259px; display: block; border-style: solid; text-align: left;">
							<div align="center">
								<img src="client/e/images/home/ab_us_2.gif" />
							</div>
							<span style="line-height: 180%;" id="LoadContact">XXXXXXXX
								地产开发有限公司成立于2015年。公司自成立以来，本着团结、创新、务实的精神，立足于XXX地产业，在稳定中求发展，以雄厚的资金为后盾，灵
								活的经营在XXXX的地产业得以快速成长。目前热销中的“XXXXXX”项目除了取得一定的经济效益外还取得……</span>
						</div>
						<a style="color: #cc0000;" href="about/"></a>
					</div>
				</div>
				<!-- 主体部分-关于我们 结束  -->

				<!-- 新闻中心开始 -->
				<div class="news">
					<div class="tit">
						<img src="client/e/images/home/new.gif">
					</div>
					<div class="con">
						<div>
							<ul class="tw_article">
								<li>
									<span class="pic">
										<a href="#" target="_self">
											<img src="client/e/upload/s1/article/image/2015/07/21173435.jpg" border="0" style="width: 70px; height: 70px;">
										</a>
									</span> 
									<span class="title">
										<a href="#" target="_self" title="2014年北京不限购项目成交盘点珠江四季悦城榜上有名" style="">2014年北京不限购项目成交盘点珠江四季悦城榜上有名</a>
									</span>
									<p class="introduct">2014年中国六个城市群综合指数水...</p>
								</li>
							</ul>
						</div>
						<div>
							<div class="article">
								<ul>
									<li>
										<span class="title"> 
											<a href="#" target="_self" title="2014年北京不限购项目成交盘点珠江四季悦城榜上有名" style="">2014年北京不限购项目成交盘点珠江四季悦城榜上有名</a>
										</span>
										<span class="date">07-21</span>
									</li>

									<li>
										<span class="title"> 
											<a href="#" target="_self" title="东贸珠宝城翡翠嘉年华京东掀热浪" style="">东贸珠宝城翡翠嘉年华京东掀热浪</a>
										</span> 
										<span class="date">07-21</span>
									</li>

									<li>
										<span class="title"> 
											<a href="#" target="_self" title="公积金贷款新政释放利好 元旦假期北京二手房买卖火爆" style="">公积金贷款新政释放利好元旦假期北京二手房买卖火爆</a>
										</span> 
										<span class="date">07-21</span>
									</li>

								</ul>
							</div>

						</div>
					</div>
				</div>
				<!-- 新闻中心结束 -->




				<div class="tp">
					<!-- 主体部分-右边轮播图开始 -->
					<div>
						<div id="js_slide_focus_13" class="slide_focus focus_style2" style="height:160px">
							<ul class="inner">
								<li>
									<a href="#" target="_self" title="XX胜景">
										<img src="client/e/upload/s1/article/image/2015/07/t_15144639.jpg">
										<em>XX胜景</em>
									</a>
								</li>
								
								<li>
									<a href="#" target="_self" title="XX胜景">
										<img src="client/e/upload/s1/article/image/2015/07/t_15143653.jpg">
										<em>XX胜景</em>
									</a>
								</li>
								
								<li>
									<a href="#" target="_self" title="XX胜景">
										<img src="client/e/upload/s1/article/image/2015/07/t_15143716.jpg">
										<em>XX胜景</em>
									</a>
								</li>
							</ul>
						</div>
					</div>
					<!-- 主体部分-右边轮播图结束 -->
					<!-- 右边人才招聘 -->
					<div style="margin-top: 8px;">
						<a href="rczp/"><img src="client/e/images/home/rencai.gif" /></a>
					</div>
				</div>
				<!-- 项目展示部分开始 -->
				<div class="xmzs">
					<div class="tit">
						<img src="client/e/images/home/xiangmu.gif" >
					</div>
					<div class="com">
						<div class="marquee_pic marquee" id="m_181_0">
							<a class="prev"></a><a class="next"></a>
							<!--控制按钮-->
							<div class="inner">
								<ul>
									<li class="hx">
										<a href="#" target="_self">
											<img src="client/e/upload/s1/article/image/2015/07/t_15144639.jpg" border="0" style="width: 150px; height: 150px;" />
										</a> 
										<br /> 
										<a href="#" target="_self" title="XX胜景">XX胜景</a>
									</li>

									<li class="hx">
										<a href="#" target="_self">
											<img src="client/e/upload/s1/article/image/2015/07/t_15143653.jpg" border="0" style="width: 150px; height: 150px;">
										</a> 
										<br>
										<a href="#" target="_self" title="XX胜景">XX胜景</a>
									</li>

									<li class="hx"><a href="#" target="_self"><img
											src="client/e/upload/s1/article/image/2015/07/t_15143424.jpg"
											border="0" style="width: 150px; height: 150px;"></a> <br>
										<a href="#" target="_self" title="XX胜景">XX胜景</a>
									</li>

									<li class="hx"><a href="#" target="_self"><img
											src="client/e/upload/s1/article/image/2015/07/t_15143716.jpg"
											border="0" style="width: 150px; height: 150px;"></a> <br>
										<a href="#" target="_self" title="XX胜景">XX胜景</a></li>

									<li class="hx"><a href="#" target="_self"><img
											src="client/e/upload/s1/article/image/2015/07/t_15143446.jpg"
											border="0" style="width: 150px; height: 150px;"></a> <br>
										<a href="#" target="_self" title="XX胜景">XX胜景</a></li>

									<li class="hx"><a href="#" target="_self"><img
											src="client/e/upload/s1/article/image/2015/07/t_15143740.jpg"
											border="0" style="width: 150px; height: 150px;"></a> <br>
										<a href="#" target="_self" title="XX胜景">XX胜景</a></li>

									<li class="hx"><a href="#" target="_self"><img
											src="client/e/upload/s1/article/image/2015/07/t_15143803.jpg"
											border="0" style="width: 150px; height: 150px;"></a> <br>
										<a href="#" target="_self" title="XX胜景">XX胜景</a>
									</li>

								</ul>
							</div>
						</div>
					</div>
				</div>
				<!-- 项目展示部分结束 -->
			</div>
			<div class="clear main_box_inner_bottom"></div>
		</div>
</body>
</html>
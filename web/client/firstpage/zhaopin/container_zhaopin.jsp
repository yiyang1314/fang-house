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
			$(parent.document.getElementById("zhaopinframe")).height(h);
			
			var  parentheight=$(parent.document.getElementById("zhaopinframe")).height();
			$(parent.document.getElementById("zhaopinframe")).parent().height(parentheight+2);
			
			
			
		});
		</script>
	</head>	
<body>
	<div class="sublanmu_content sublanmu_content_introduct">
		<div class="wp-title_content"
			style="word-wrap: break-word; padding: 10px; border-color: #CCCCCC; border-width: 1px; width: 664px; display: block; border-style: solid;">
			<p>
				<strong><span style="color: #CC0000; font-size: 13px;">房地产销售人员&nbsp;&nbsp;
						5人</span></strong>
			</p>
			<p>
				<br />
			</p>
			<p>
				<strong>办公地点：全国</strong>
			</p>
			<p>
				<br />
			</p>
			<p>
				<strong>详细描述：</strong>
			</p>
			<p>销售，21世纪全球最庞大的职业类别；各个行业的命脉；</p>
			全球身价在“10亿美元”以上的497名超级富豪中，竟有237名是白手起家，从销售做起；<br />
			它可以剖析每一个人，深可见骨；它又可以分解每一个人，让他死去；它还可以重组每一个人，让他重生！不可理喻，又不可言表。<br />
			<p>如果你还不懂销售，请慎重选择未来！</p>
			<p>
				<br />
			</p>
			<p>
				1、优越的薪酬<br /> 无责任高底薪1800-4000 +高额提成<br />
				提成8%~35%，更提供带薪年假+带薪培训+月度、季度现金奖+全套保险（社保+商保）<br />
				全公司近20000名业务人员平均月薪7000元以上。<br /> 2、快速的晋升，广阔的平台<br />
				公平、广阔的晋升空间，所有运营体系管理岗位均从内部优秀员工中提拔产生。<br />
				见习置业顾问（3个月-6个月）--门店经理--（6个月-1年）--区域经理（2-4年）--总监（4-8年）--分公司总经理。目前北京公司已培养、提拔2300多名店经理，200名区域经理、26名大区总监，7名城市总经理。2013年1500名店经理虚位以待！<br />
				店经理底薪3000元-6500元/月+提成8%-24%，月均1.5万-3万；<br />
				区经理底薪6000元-10500元+提成，月均2万-4万。<br /> 3、完善的培训体系<br />
				拥有专有培训基地，学院，专业培训讲师。新人训—在职经纪人能力提升衔接培训—新任店经理培训—店经理管理培训等，一整套完善的培训机制。
				<br /> 一系列人才的标准化培养：经纪人的一天、店经理十六步、带看九要素、奇妙等式等，快速的学习和成长。
			</p>
		</div>
	</div>
</body>
</html>
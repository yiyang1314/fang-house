<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//System.out.println("basepath:"+basepath);
	
%>
<html>
<head>
<base href="<%=basepath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目管理系统 by www.mycodes.net</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(admin/images/left.gif);
}
-->
</style>
<link href="admin/css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
	function tupian(idt){
	    var nametu="xiaotu"+idt;
	    var tp = document.getElementById(nametu);
	    tp.src="admin/images/ico05.gif";//图片ico04为白色的正方形
		
		for(var i=1;i<30;i++)
		{
		  
		  var nametu2="xiaotu"+i;
		  if(i!=idt*1)
		  {
		    var tp2=document.getElementById('xiaotu'+i);
			if(tp2!=undefined)
		    {tp2.src="admin/images/ico06.gif";}//图片ico06为蓝色的正方形
		  }
		}
	}
	
	function list(idstr){
		var name1="subtree"+idstr;
		var name2="img"+idstr;
		var objectobj=document.all(name1);
		var imgobj=document.all(name2);
		
		
		//alert(imgobj);
		
		if(objectobj.style.display=="none"){
			for(i=1;i<10;i++){
				var name3="img"+i;
				var name="subtree"+i;
				var o=document.all(name);
				if(o!=undefined){
					o.style.display="none";
					var image=document.all(name3);
					//alert(image);
					image.src="admin/images/ico04.gif";
				}
			}
			objectobj.style.display="";
			imgobj.src="admin/images/ico03.gif";
		}
		else{
			objectobj.style.display="none";
			imgobj.src="admin/images/ico04.gif";
		}
	}
	

</SCRIPT>

<body >
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <TD>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="207" height="55" background="admin/images/nav01.gif">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="2"><img src="admin/images/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01">您好，<span class="left-font02">${sessionScope.u.realname }</span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a href="user_logout" target="_top" class="left-font01">退出</a>&nbsp;]</td>
				  </tr>
				</table>
			</td>
		  </tr>
		</table>
		


		<!--  菜单管理开始    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img8" id="img8" src="admin/images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('8');" >菜单管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree8" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu20" src="admin/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="admin/files/menu/menu_update.jsp" target="mainFrame" class="left-font03" onClick="tupian('20');">创建菜单</a></td>
				</tr>
				<tr>
				  <td width="9%" height="21" ><img id="xiaotu21" src="admin/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="menu_sub" target="mainFrame" class="left-font03" onClick="tupian('21');">菜单管理</a></td>
				</tr>
      </table>
		<!--  任务系统结束    -->

		<!--  用户管理开始    -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img7" id="img7" src="admin/images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('7');" >用户管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree7" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu17" src="admin/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
						<a href="user_page" target="mainFrame" class="left-font03" onClick="tupian('17');">修改密码</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu18" src="admin/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
					<a href="admin/files/user/register.jsp" target="mainFrame" class="left-font03" onClick="tupian('18');">添加用户</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu19" src="admin/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%">
						<a href="user_page" target="mainFrame" class="left-font03" onClick="tupian('19');">用户管理
							</a></td>
				</tr>
      </table>
		<!--  用户管理结束    -->

	 <!--  房源管理开始    -->
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="8%" height="12"><img name="img3" id="img3" src="admin/images/ico04.gif" width="8" height="11" /></td>
                  <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('3');" >房源管理</a></td>
                </tr>
            </table></td>
          </tr>
      </table>
	  
	  <table id="subtree3" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
		<tr>
          <td width="9%" height="20" ><img id="xiaotu9" src="admin/images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="admin/files/house/house_update.jsp" target="mainFrame" class="left-font03" onClick="tupian('9');">发布房源</a></td>
        </tr>
		<tr>
          <td width="9%" height="20" ><img id="xiaotu10" src="admin/images/ico06.gif" width="8" height="12" /></td>
          <td width="91%"><a href="house_page" target="mainFrame" class="left-font03" onClick="tupian('10');">房源管理</a></td>
        </tr>
      </table>
	  <!--  房源管理 结束    -->

		<!-- 新闻管理  开始 -->
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="admin/images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('1');" >新闻管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<table id="subtree1" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu1" src="admin/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="admin/files/news/news_update.jsp" target="mainFrame" class="left-font03" onClick="tupian('1');">发布新闻</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu4" src="admin/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="news_page" target="mainFrame" class="left-font03" onClick="tupian('4');">分页管理</a></td>
				</tr>
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu2" src="admin/images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="news_findAll" target="mainFrame" class="left-font03" onClick="tupian('2');">新闻管理</a></td>
				</tr>
      </table>
		<!--  新闻管理结束    -->
	  </TD>
  </tr>
  
</table>
</body>
</html>

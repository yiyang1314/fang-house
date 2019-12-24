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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basepath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.mycodes.net</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="admin/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript" src="admin/js/deletelist.js"></script>
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>

	function update(menuid){
		if(confirm("您确定要修改"+menuid+"吗？")){
			location.href="menu_updateById?menuid="+menuid;
		}
		   
	}
	
	
	function del(menuid){
		if(confirm("您确定要删除"+menuid+"吗？")){
			location.href="menu_delete?menuid="+menuid;
		}
		   
	}
	
	function add(){
		   location.href="admin/files/menu/menu_update.jsp";
	}
</SCRIPT>

<body>
<form name="fom" id="fom" method="post">

<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="admin/images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="24"><img src="admin/images/ico07.gif" width="20" height="18" />

			  
			  </td>
			  <td width="519"><label>公司名称:
			      <input name="text" type="text" nam="gongs" />
			  </label>
			    </input>
			    <input name="Submit" type="button" class="right-button02" value="查 询" /></td>
			   <td width="679" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr style="margin:20px 20px">
          	<td>
          		 <c:if test="${menu_list[0].parentid!=0 }">
					====》<a href="menu_parentlist?parentid=${parentid }">回到上级${parentid }</a>
				</c:if>
          	</td>
          </tr>
           	 <tr>
               <td height="20"><span class="newfont07">选择：
               <a href="javaScript:void(0)" class="right-font08" onclick="selectAll();">全选</a>-
               <a href="javaScript:void(0)" class="right-font08" onclick="unselectAll();">反选</a></span>
		           <input name="Submit" type="button" class="right-button08"  title="已禁用" value="批量删除"   onclick="delids('menu',this)" /> <input name="Submit" type="button" class="right-button08" value="添加" onclick="add();" />
		           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	              </td>
          </tr>

              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					<tr>
                    <td height="20" colspan="14" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;菜单详细列表 &nbsp;</td>
                    </tr>
                  <tr>
				    <td width="8%" align="center" bgcolor="#EEEEEE">选择</td>
					<td width="12%" height="20" align="center" bgcolor="#EEEEEE">菜单编号</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">菜单名</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">上级菜单编号</td>
                    <td width="14%" align="center" bgcolor="#EEEEEE">图片路径</td>
					<td width="8%" align="center" bgcolor="#EEEEEE">菜单状态</td>
					<td width="10%" align="center" bgcolor="#EEEEEE">菜单地址</td>
                    <td width="11%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr> 
                  
              <c:forEach items="${menu_list }" var="menu">
				   <tr>
						<td bgcolor="#FFFFFF"><input type="checkbox" name="delid" value="${menu.menuid}"/></td>
						<td height="20" bgcolor="#FFFFFF"><a href="#">${menu.menuid}</a></td>
						<td bgcolor="#FFFFFF"><a href="menu_findById?menuid=${menu.menuid}">${menu.menuName }</a></td>
						<td height="20" bgcolor="#FFFFFF">${menu.parentid }</td>
						<td bgcolor="#FFFFFF">${menu.picpath }</td>
						<td bgcolor="#FFFFFF">${menu.menuStatus }</td>
						<td bgcolor="#FFFFFF">${menu.menuUrl }</td>
						<td bgcolor="#FFFFFF">
						<a href="javaScript:void(0)" onclick="del(${menu.menuid})">删除</a>&nbsp;|&nbsp;
						<a href="javaScript:void(0)"  onclick="update(${menu.menuid})">修改</a>&nbsp;|&nbsp;
						<a href="menu_sub?parentid=${menu.menuid}">查看下级</a></td>
					</tr>
              </c:forEach>    
                
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
</td>
  </tr>
</table>
</form>
<jsp:include page="../comm_page/page.jsp">
	<jsp:param value="menu_page" name="action"/>
	<jsp:param value="${enablePage}" name="enablePage"/>
	<jsp:param value="${column}" name="column"/>
	<jsp:param value="${enableSearch }" name="enableSearch"/>
	<jsp:param value="${count}" name="count"/>
</jsp:include>
</body>
</html>

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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<script type="text/JavaScript" src="admin/js/deletelist.js">

</script>
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />

</head>
<SCRIPT language=JavaScript>

	//修改
	function update(userid){
		if(confirm("您确定要修改"+userid+"吗？")){
			location.href="user_updateById?userid="+userid;
		}
		   
	}
	
	//删除
	function del(userid){
		if(confirm("您确定要删除"+userid+"吗？")){
			location.href="user_delete?userid="+userid;
		}
		   
	}
	
	
	function add(){
		   location.href="admin/files/user/register.jsp";
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
			  
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">选择：
               <a href="javaScript:void(0)" class="right-font08" onclick="selectAll();">全选</a>-
               <a href="javaScript:void(0)" class="right-font08" onclick="unselectAll();">反选</a></span>
		           <input name="Submit" type="button" class="right-button08" title="已禁用" value="批量删除"   onclick="delids('user',this)"/> <input name="Submit" type="button" class="right-button08" value="添加" onclick="add();" />
		           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	              </td>
          </tr>
              <tr>
                <td height="40" class="font42">
                <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
					                  <tr>
                    <td height="20" colspan="14" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户详细列表 &nbsp;</td>
                    </tr>
                  <tr>
				    <td width="4%" align="center" bgcolor="#EEEEEE">选择</td>
					 <td width="12%" height="20" align="center" bgcolor="#EEEEEE">用户名</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">密码</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">真实名称</td>
                    <td width="11%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr> 
              <c:forEach items="${user_list }" var="user">
				 <tr>
				   	<td bgcolor="#FFFFFF"><input type="checkbox" name="delid" value="${user.userid} "/></td>
					<td height="20" bgcolor="#FFFFFF"><a href="user_findById?userid=${user.userid}">${user.loginname}</a></td>
                    <td bgcolor="#FFFFFF"><a href="#">${user.loginpwd}</a></td>
                    <td height="20" bgcolor="#FFFFFF">${user.realname}</td>
                    <td bgcolor="#FFFFFF">
	                    <a href="javaScript:void(0)" onclick="del(${user.userid})">删除</a>&nbsp;|&nbsp;
	                    <a href="javaScript:void(0)" onclick="update(${user.userid})">修改</a>
                    </td>
                  </tr>
              </c:forEach>    
                
                </table>
                </td>
              </tr>
            </table>
            </td>
        </tr>
      </table>
      </td>
  </tr>
</table>
</form>


<jsp:include page="../comm_page/page.jsp">
	<jsp:param value="user_page" name="action"/>
	<jsp:param value="${enablePage}" name="enablePage"/>
	<jsp:param value="${column}" name="column"/>
	<jsp:param value="${enableSearch }" name="enableSearch"/>
	<jsp:param value="${count}" name="count"/>
</jsp:include>



</body>
</html>

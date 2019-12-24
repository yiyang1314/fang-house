<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//System.out.println("basepath:"+basepath);
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basepath%>" />
		<meta charset="UTF-8">
		<title>马上登录！</title>
		<style>
			body{
				margin:0px;
				padding:0px;
				background-color:green;
			}
			fieldset{
				width:550px;
				margin-top:120px;
				margin-left:350px;
				background-color:buttonhighlight;
			}
		</style>
		<script type="text/javascript">
		var socket;
		function createhttp(){
			if (window.XMLHttpRequest)
			  {// code for IE7+, Firefox, Chrome, Opera, Safari
				socket=new XMLHttpRequest();
			  }
			else
			  {// code for IE6, IE5
				socket=new ActiveXObject("Microsoft.XMLHTTP");
			  }
		}
		function checkName(){
			var val=document.getElementById("username").value;
			console.log(val);
			if(val==null||val==''){
				return ;
			}
			createhttp();
			socket.open("post","user_reg?username="+val);
			socket.onreadystatechange=checkCallBack;
			socket.send();
		}
		
		function checkCallBack(){
			if(socket.readyState==4&&socket.status==200){

				//console.log(JSON.stringify(m));
				var status=eval(socket.responseText);
				
				
				if(status=='200'){
					document.getElementById("tip-user").innerHTML = "<font color='green' size='2' ><b>用户名可以使用</b></font>";
				}else{
					
					document.getElementById("tip-user").innerHTML = "<font color='red' size='2' ><b>用户名已经存在了</b></font>";
				}
			}
		}
		
		function checkPWD(){
			
			var pwd1=document.getElementById("pwd1").value;
			var pwd2=document.getElementById("pwd2").value;
			if(pwd1==''||pwd2==''){
				alert("不能为空！");
				return ;
			}
			if(pwd1==pwd2){
				document.getElementById("tip-pwd2").innerHTML = "<font color='green' size='2' ><b>密码正确</b></font>";
			}else{
				document.getElementById("tip-pwd2").innerHTML = "<font color='red' size='2' ><b>用户名已经存在了</b></font>";
			}
		}
		
		var data="";
		
		var xmlhttp;
		function AJAX(method,url,param){
			if (window.XMLHttpRequest)
			  {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp=new XMLHttpRequest();
			  }else{
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
				xmlhttp.open(method,url);
				xmlhttp.onreadystatechange=function(){
					if(xmlhttp.readyState==4&&xmlhttp.status==200){
data="dsdfg";
					}
				};
				xmlhttp.send();			
		}
		
		function search(){
			AJAX("post","province_list",null);
			alert(data);
		}
		</script>
		
		
		
		
	</head>
	<body>
		<fieldset>
			<legend>用户登录</legend>
			<form action="">
				<p>姓名：<input type="text" name="username" onKeyup="checkName()" id="username"><span id="tip-user"></span></p>
				<p>密码：<input type="password" name="password" id="pwd1"><span id="tip-pwd1"></span></p>
				<p>确认密码：<input type="password" name="pwd" onfocus="checkPWD()" id="pwd2"><span id="tip-pwd2"></span></p>
				<p>地址：<select name="province" onchange="getProvince(this.value)">
							<option value="-1" >----请选择----</option>
						</select>
						<select name="city" onchange="getCity(this.value)">
							<option value="-1">----请选择----</option>
						</select>
						<select name="area" >
								<option value="-1">----请选择----</option>
						</select>
					<button onclick="search()">heelo</button>
				</p>
				
				
				
				<p>性别：
					<input type="radio" name="interst">男
					<input type="radio" name="interst">女
					<input type="radio" name="interst">保密
				<p><input type="checkbox" name="remeber">记住</p>
				<p><input type="submit" value="登录">
				<input type="reset" value="重置"></p>
			</form>
		</fieldset>
	</body>
</html>
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
		
		var ajaxja={
				"method":"post",
				"type":"json",
				"param":{"username":"tangyi"},
				"url":"menu_nav",
				"status":"200",
				"ajax":function post(){
					var xmlhttp;
					if (window.XMLHttpRequest)
					  {// code for IE7+, Firefox, Chrome, Opera, Safari
						xmlhttp=new XMLHttpRequest();
					  }
					else
					  {// code for IE6, IE5
						xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
					  }
					socket.open(this.method,this.url);
					socket.onreadystatechange=function(){
						if(xmlhttp.readyState==4&&xmlhttp.status==200){
							this.data=xmlhttp.responseText;
							alert(this.data);
							this.success(xmlhttp.responseText);
						}else{
							alert("error");
						}
					};
					socket.send(ajax.param);

				},
				"success":function(rep){
					alert(rep);
				},
				"data":""
		}
		

		
		

		
		
		
		
		
		
		
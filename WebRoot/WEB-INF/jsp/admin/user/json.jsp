<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'json.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#profile").click(function() {
				profile();
			});
			$("#login").click(function() {
				login();
			});
		});
		function profile() {
			var url = 'http://localhost:8080/SpringMVC/user/profile/';
			var query = $('#id').val();
			url += query;
			alert(url);
			$.get(url, function(data) {
				alert("id: " + data.id + "\nuserName: " + data.userName + "\npassword: "
						+ data.password + "\nage: " + data.age);
			});
		}
		function login() {
			var mydata = '{"userName":"' + $('#userName').val() + '","id":"'
					+ $('#id').val() + '","age":"' + $('#age').val() + '"}';
			alert(mydata);
			$.ajaxSetup({  
		        contentType : 'application/json'  
		    });
		    
		    $.post('http://localhost:8080/SpringMVC/user/porfileAjax', mydata,  
            function(data) {  
                alert("id: " + data.id + "\nuserName: " + data.name + "\nage: " + data.age + "\npassword: " + data.password);
            }, 'json');
            
            //或者
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : 'http://localhost:8080/SpringMVC/user/porfileAjax',
				processData : false,
				dataType : 'json',
				data : mydata,
				success : function(data) {
					alert("id: " + data.id + "\nuserName: " + data.name + "\nage: "
							+ data.age + "\npassword: " + data.password);
				},
				error : function() {
					alert('Err...');
				}
			});
		}
	</script>

  </head>
  
  <body>
    <table>
		<tr>
			<td>id</td>
			<td><input id="id" value="1" /></td>
		</tr>
		<tr>
			<td>name</td>
			<td><input id="userName" value="snowolf" /></td>
		</tr>
		<tr>
			<td>status</td>
			<td><input id="age" value="23" /></td>
		</tr>
		<tr>
			<td><input type="button" id="profile" value="Profile——GET" /></td>
			<td><input type="button" id="login" value="Login——POST" /></td>
		</tr>
	</table>
  </body>
</html>

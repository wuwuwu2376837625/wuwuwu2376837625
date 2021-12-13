<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>主页面</title>
<style type="text/css">
*{
			padding: 0;
			margin: 0;
			border: 0;
			font-size: 14px;
			color: black;
			font-weight: normal;
			font-style: normal;
			text-decoration: none;
			list-style: none;
		}
		.wrapper {
			background: linear-gradient(to bottom right, #50a3a2 0%, #53e3a6 100%);
			opacity: 0.8;
			position: absolute;
			top: 50%;
			left: 0;
			width: 100%;
			height: 365px;
			margin-top: -200px;
			overflow: hidden;
		}
		.container {
			max-width: 450px;
			margin: 0 auto;
			padding: 80px 0;
			height: 400px;
			text-align: center;
		}
		h1{
			color: black;
			font-size: 2em;
			font-weight: bold;
			margin-top: 60px;
		}
		body{
			text-align: center;
		}
		form {
			padding-top: 0px;
			position: relative;
			z-index: 2;
		}
		.box1{
			margin: 120px auto;
			border: solid 1px cadetblue;
			font-size: 20px;
		}
		.box2{
			margin: -123px auto;
			border: solid 1px cadetblue;
			font-size: 20px;
			width: 440px;
		}
		table tr td{
			border: 1px solid black;
			width: 300px;
			height: 30px;
			font-size: 20px;
		}
		table tr td input{
			height: 100%;
			font-size: 18px;
			width: 100%;
			color: white;
			background-color: #74c9b5;
		}
		table tr td select{
			height: 100%;
			font-size: 18px;
			width: 100%;
			color: white;
			background-color: #75d9b7;
		}
		select option{
			color: white;
			font-size: 18px;
		}
		.box{
			font-size: 20px;
			margin: -110px 5px;
		}
		a{
			font-size: 18px;
			color: white;
		}
		table td {
			-webkit-appearance: none;
			-moz-appearance: none;
			appearance: none;
			outline: 0;
			border: 1px solid rgba(255, 255, 255, 0.4);
			background-color: rgba(255, 255, 255, 0.2);
			width: 250px;
			border-radius: 3px;
			padding: 10px 15px;
			margin: 0 auto 10px auto;
			text-align: center;
			font-size: 18px;
			color: white;
			-webkit-transition-duration: 0.25s;
			transition-duration: 0.25s;
			font-weight: 300;
		}
</style>
</head>
<script type="text/javascript">
function getNo() {
	document.form2.No.value=document.form1.No.value;
}
</script>
<body>
<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<div class="box">
				<form name="form1" action="TeFind.do" method="post">
					<table border="1" class="box1">
						<tr>
							<td>当前登录的教师账号</td>
							<td ><input type="text" name="No" id="No" readonly="readonly" value="${No}"></td>
						</tr>
							<tr>
								<td colspan="2"><input type="submit" value="查看教师详细信息"></td>
							</tr>
					</table>
				</form>
				<form name="form2" action="FindAllSt.do" method="post">
					<table border="1" class="box2">
					<tr>
						<td colspan="2"><input type="submit" name="No" value="查看所有学生信息" onclick="getNo()"></td>
					</tr>
						<tr>
							<td colspan="2"><a href="TeLogin.jsp">返回登录页面</a></td>
						</tr>
						</table>
				</form>
			</div>
		</div>
	</div>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
	<h1>信息管理系统主页面</h1>
</div>
</body>
</html>
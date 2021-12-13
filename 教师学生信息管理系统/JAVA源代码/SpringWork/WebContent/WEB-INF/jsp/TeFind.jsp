<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>教师信息详情</title>
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
			background: #50a3a2;
			background: -webkit-linear-gradient(top left, #50a3a2 0%, #53e3a6 100%);
			background: linear-gradient(to bottom right, #50a3a2 0%, #53e3a6 100%);
			opacity: 0.8;
			position: absolute;
			top: 50%;
			left: 0;
			width: 100%;
			height: 470px;
			margin-top: -200px;
			overflow: hidden;

		}
		.container {
			max-width: 600px;
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
		table{
			margin: 170px auto;
			border: solid 1px cadetblue;
			font-size: 20px;
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
			background-color: #75d9b7;
		}
		.box{
			font-size: 20px;
			margin: -50px 5px;
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
		.box1{
			margin: 0px auto;
			border: solid 1px cadetblue;
			font-size: 20px;
		}
		.box2{
			margin: 0px auto;
			border: solid 1px cadetblue;
			font-size: 20px;
			width: 590px;
		}
	</style>
</head>
<body>
<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<div class="box">
				<form action="toTeUpdata.do" method="post">
					<table border="1" class="box1">
						<c:forEach items="${telist}" var="telist">
							<tr>
								<td>姓名 </td>
								<td>${telist.name }</td>
							</tr>
							<tr>
								<td>学号</td>
								<td>${telist.no }</td>
							</tr>
							<tr>
								<td>密码</td>
								<td>${telist.password }</td>
							</tr>
							<tr>
								<td>性别</td>
								<td>${telist.sex }</td>
							</tr>
							<tr>
								<td>注册时间</td>
								<td>${telist.created }</td>
							</tr>
							<tr>
								<td>最近修改时间</td>
								<td>${telist.updated }</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="修改教师信息"></td>
							</tr>
						</c:forEach>
					</table>
				</form>
				<form action="ToMain.do" method="post">
					<table border="1" class="box2">
						<tr>
							<td colspan="2"><input type="submit" value="返回主页面"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
	<h1>教师信息详情</h1>
</div>
</body>
</html>
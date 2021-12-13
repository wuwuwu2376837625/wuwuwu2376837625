<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改学生信息页面</title>
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
			margin: -55px 5px;
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
		#No{
			background-color: #74c9b5;
		}
		#name,#teNo,#sex{
			background-color: #7494c9;
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
				<form action="StUpdata.do" method="post">
					<table border="1" class="box1">
						<c:forEach items="${stlist}" var="list">
						<c:if test="${list.no eq StNo }">
							<tr>
								<td>工号</td>
								<td><input type="text" name="No" id="No" readonly="readonly" value="${list.no }"></td>
							</tr>
							<tr>
								<td>姓名</td>
								<td><input type="text" name="name" id="name" value="${list.name}"></td>
							</tr>
							<tr>
								<td>性别</td>
								<td>
									<select name="sex" id="sex">
									<option value="${list.sex}" selected="selected">${list.sex}</option>
									<c:if test="${list.sex=='男'}"><option value="女">女</option></c:if>
									<c:if test="${list.sex=='女'}"><option value="男">男</option></c:if>
									</select>
								</td>
							</tr>
							<tr>
								<td>教师编号</td>
								<td><input type="text" name="teNo" id="teNo" value="${list.teNo}"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="保存并返回学生信息页面"></td>
							</tr>
							</c:if>
						</c:forEach>
					</table>
				</form>
				<form name="form2" action="FindAllSt.do" method="post">
					<table border="1" class="box2">
						<tr>
							<td colspan="2"><input type="submit" value="取消并返回学生信息页面"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
	<h1>学生信息更新</h1>
</div>
</body>
</html>
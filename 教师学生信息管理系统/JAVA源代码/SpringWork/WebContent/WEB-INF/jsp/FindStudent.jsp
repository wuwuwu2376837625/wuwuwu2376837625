<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询到的学生信息</title>
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
			top: 100px;
			left: 0;
			width: 100%;
			height: 520px;
			overflow: hidden;

		}
		.container {
			max-width: 910px;
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
			margin: -50px 0;
			width: 950px;
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
			width: 250px;
			
		}
		.box2 input{
			background-color: #75d1b640;
		}
		.dividpage{
        	font-size: 20px;
        	color: white;
        }
	</style>
</head>
<body>
<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<div class="box">
				<form action="" method="post">
					<table border="1" class="box1">
						<tr>
							<td>姓名 </td>
							<td>学号</td>
							<td>性别</td>
							<td>教师号</td>
							<td>注册时间</td>
							<td>最近修改时间</td>
							<td colspan="2">操作</td>
						</tr>
						<c:forEach items="${studentlist}" var="list">
						<c:if test="${not empty list.no}">
							<tr>
								<td>${list.name}</td>
								<td>${list.no}</td>
								<td>${list.sex}</td>
								<td>${list.teNo}</td>
								<td>${list.created}</td>
								<td>${list.updated}</td>
								<td>
							 		<a href="ToStUpdata.do?StNo=${list.no}">修改</a>
							 	</td>
							 	<td>
							 		<a href="StDelete.do?StNo=${list.no}">删除</a>
							 	</td>
							</tr>
							</c:if>
						</c:forEach>
					</table>
				</form>
		<!--分页 -->
      		<div class="dividpage">
      			<c:if test="${pagebean.currentPage ne 1}">
      				<a href = "FindPaSt.do?currentPage=1" >首页</a>&nbsp;&nbsp;
      				<a href = "FindPaSt.do?currentPage=${pagebean.currentPage-1}" >&laquo;&laquo;</a>
      			</c:if>
      			<c:if test="${pagebean.currentPage eq 1}">
      				<a>首页</a>&nbsp;&nbsp;
      				<a>&laquo;&laquo;</a>
      			</c:if>&nbsp;
      			第&nbsp;${pagebean.currentPage}&nbsp;页/共&nbsp;${pagebean.totalPage}&nbsp;页&nbsp;
      			<c:if test="${pagebean.currentPage ne pagebean.totalPage}">
					<a href = "FindPaSt.do?currentPage=${pagebean.currentPage+1}" >&raquo;&raquo;</a>&nbsp;&nbsp;
					<a href = "FindPaSt.do?currentPage=${pagebean.totalPage}">尾页</a>
				</c:if>
				<c:if test="${pagebean.currentPage eq pagebean.totalPage}">
					<a>&raquo;&raquo;</a>&nbsp;&nbsp;
					<a>尾页</a>
				</c:if>
    		 </div>
     <!-- 分页结束 -->
				<form action="FindAllSt.do" method="post">
					<table border="1" class="box2">
						<tr>
							<td colspan="5"><input type="submit" value="返回学生信息页面"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
	<h1>查询到的学生信息</h1>
</div>
</body>
</html>
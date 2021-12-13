<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link href="styles.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <h1>Welcome</h1>
            <form class="form" action="TeLogin.do" method="post">
                <input type="text" name="No" id="No" placeholder="Username" value="${cookie.No.value}">
                <input type="password" name="password" id="password" placeholder="Password" value="${cookie.pw.value}">
                <input type="submit" id="login-button" value="登录">
                <p><input type="checkbox" name="isAuto" id="isAuto" value="1">记住账号密码</p>
            </form>
        </div>
        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</div>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
    <h1>数据管理系统</h1>
</div>
</body>
</html>
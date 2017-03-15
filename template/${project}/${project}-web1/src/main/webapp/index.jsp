<%--
  Created by IntelliJ IDEA.
  User: Allen
  Date: 2016/11/16
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<#assign ff = "$">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理系统——用户登录</title>
    <link rel="stylesheet" href="${ff}{pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${ff}{pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="login-box">
    <ul>
        <li class="login-title">
            <img src="${ff}{pageContext.request.contextPath}/images/title.png"/>
        </li>
        <li>
            用户名<input id="username" type="text"/>
        </li>
        <li>
            密　码<input id="password" type="password"/>
        </li>
        <li>
            <input id="btnLogin" type="button" value="登 录" onclick="onLogin();"/>
        </li>
        <li>
            <div style="color: red;font-size: 12px;" id="msg"></div>
        </li>
    </ul>
</div>
</body>
</html>
<script>
    function onLogin() {

        var username = ${ff}("#username");
        if(username.val()==''){
            alert("请输入用户名");
            username.focus();
            return;
        }

        var password = ${ff}("#password");
        if(password.val()==''){
            alert("请输入密码");
            password.focus();
            return;
        }

        //加载内容列表
        <%--var url = "${ff}{pageContext.request.contextPath}/user/login";--%>
        <%--${ff}.ajax({--%>
            <%--type: "post",--%>
            <%--url:url,--%>
            <%--data:{--%>
                <%--userName:username.val(),--%>
                <%--passWord:password.val()--%>
            <%--},--%>
            <%--success: function (data) {--%>
                <%--${ff}("#msg").html(data.msg)--%>
                <%--setTimeout(function () {--%>
                    <%--${ff}("#msg").html("");--%>
                <%--},3000)--%>
                <%--if(data.code==1){--%>
                    <%--setTimeout(function () {--%>
                        <%--location.href =  url;--%>
                    <%--},500)--%>
                <%--}--%>
            <%--}--%>
        <%--});--%>


    }
</script>

<#assign ff = "$">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="top">
    <img src="${ff}{pageContext.request.contextPath}/images/logo.png" class="logo"/>
    <div class="user-info">
        欢迎您，${ff}{pageContext.session.getAttribute('user_session').userName}　 <a href="javascript:;" onclick="loginout()">退出登录</a>
    </div>
</div>
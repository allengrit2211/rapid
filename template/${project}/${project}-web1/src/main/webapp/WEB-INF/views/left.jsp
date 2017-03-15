<#assign ff = "$">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="left">
    <ul>
        <!--generator-insert-location-->
        <li><a class="icon1" href="${ff}{pageContext.request.contextPath}/${classNameLower}/${classNameLower}List">${table.tableAlias}管理</a></li>
        <!--generator-insert-location-->
    </ul>
    <input type="button" value="退出登录" class="btnExit" onclick="loginout()"/>
</div>
<script type="text/javascript">
    ${ff}(function () {
        var contextPath = '${ff}{pageContext.request.contextPath}';
        var tmp = contextPath+window.location.href.split(contextPath)[1].split("?")[0];
        ${ff}("a[href*='"+tmp+"']").parent("li").addClass("active")
    })

</script>
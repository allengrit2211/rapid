<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign ff = "$">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="stag" uri="http://${project}-tags.sf.net" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理系统——${table.tableAlias}列表</title>
    <c:import url="../base.jsp"/>
</head>
<body>
<c:import url="../top.jsp"/>
<div id="body">
    <c:import url="../left.jsp"/>
    <div id="body_right" class="right">
        <div class="content">
            <form method="get" action="${ff}{pageContext.request.contextPath}/${classNameLower}/${classNameLower}List">
                <div class="search-box">
                    <input id="phone" type="text" name="phone" value="${ff}{phone}" placeholder="请输入手机号码"/>

                    <input id="search_btn" type="submit" value="查询" style="margin-left: 10px;"/>
                </div>
            </form>
            <div id="msg" style="color: red;font-size: 12px;"></div>
            <table class="table-list" cellspacing="0">
                <tr class="header">
                    <#list table.columns as column>
                        <td>${column.columnAlias}</td>
                    </#list>
                    <td>操作</td>
                </tr>
                <c:forEach items="${ff}{pageView.records}" var="item">
                    <tr id="tr_${ff}{item.id}">
                        <#list table.columns as column>
                            <td>${ff}{item.${column.columnNameLower}}</td>
                        </#list>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="20">
                        <jsp:useBean id='parameterMap' class='java.util.HashMap' scope="page"/>
                        <c:set target="${ff}{parameterMap}" property="phone" value="${ff}{phone}"/>
                        <stag:PageViewTag baseUrl="${ff}{pageContext.request.contextPath}/${classNameLower}/${classNameLower}List"
                                          pageView="${ff}{pageView}" parameterMap="${ff}{parameterMap}"/>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>

<script>

</script>
</body>
</html>
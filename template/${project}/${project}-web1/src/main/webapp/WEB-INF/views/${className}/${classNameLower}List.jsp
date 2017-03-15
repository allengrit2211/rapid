<#assign ff = "$">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="stag" uri="http://simland-tags.sf.net" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>平台后台管理系统——APP会员列表</title>
    <c:import url="../base.jsp"/>
</head>
<body>
<c:import url="../top.jsp"/>
<div id="body">
    <c:import url="../left.jsp"/>
    <div id="body_right" class="right">
        <div class="content">
            <form method="get" action="${ff}{pageContext.request.contextPath}/consumer/consumerList">
                <div class="search-box">
                    <input id="phone" type="text" name="phone" value="${ff}{phone}" placeholder="请输入手机号码"/>
                    <input id="invitePhone" type="text" name="invitePhone" value="${ff}{invitePhone}"
                           placeholder="请输入推荐人手机号码" style="margin-left: 10px;"/>

                    <select id="s_province" name="city" style="margin-left: 10px;" value="${ff}{city}">
                        <option value="">请选择城市</option>
                        <option value="北京市">北京市</option>
                        <option value="天津市">天津市</option>
                        <option value="上海市">上海市</option>
                        <option value="重庆市">重庆市</option>
                        <option value="河北省">河北省</option>
                        <option value="山西省">山西省</option>
                        <option value="内蒙古">内蒙古</option>
                        <option value="辽宁省">辽宁省</option>
                        <option value="吉林省">吉林省</option>
                        <option value="黑龙江省">黑龙江省</option>
                        <option value="江苏省">江苏省</option>
                        <option value="浙江省">浙江省</option>
                        <option value="安徽省">安徽省</option>
                        <option value="福建省">福建省</option>
                        <option value="江西省">江西省</option>
                        <option value="山东省">山东省</option>
                        <option value="河南省">河南省</option>
                        <option value="湖北省">湖北省</option>
                        <option value="湖南省">湖南省</option>
                        <option value="广东省">广东省</option>
                        <option value="广西">广西</option>
                        <option value="海南省">海南省</option>
                        <option value="四川省">四川省</option>
                        <option value="贵州省">贵州省</option>
                        <option value="云南省">云南省</option>
                        <option value="西藏">西藏</option>
                        <option value="陕西省">陕西省</option>
                        <option value="甘肃省">甘肃省</option>
                        <option value="青海省">青海省</option>
                        <option value="宁夏">宁夏</option>
                        <option value="新疆">新疆</option>
                        <option value="香港">香港</option>
                        <option value="澳门">澳门</option>
                        <option value="台湾省">台湾省</option>
                    </select>


                    <input id="search_btn" type="submit" value="查询" style="margin-left: 10px;"/>
                </div>
            </form>
            <div id="msg" style="color: red;font-size: 12px;"></div>
            <table class="table-list" cellspacing="0">
                <tr class="header">
                    <td>ID</td>
                    <td>手机号码</td>
                    <td>注册日期</td>
                    <td>城市</td>
                    <td>邀请码</td>
                    <td>邀请人ID</td>

                </tr>
                <c:forEach items="${ff}{pageView.records}" var="item">
                    <tr id="tr_${ff}{item.id}">
                        <td>${ff}{item.id}</td>
                        <td>${ff}{item.phone}</td>
                        <td>${ff}{item.city}</td>
                        <td><fmt:formatDate value="${ff}{item.regTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                        <td>
                            <c:if test="${ff}{item.inviteCode!=null}">
                                ${ff}{item.inviteCode}${ff}{item.id}
                            </c:if>
                        </td>
                        <td>${ff}{item.inviteUid}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="20">
                        <jsp:useBean id='parameterMap' class='java.util.HashMap' scope="page"/>
                        <c:set target="${ff}{parameterMap}" property="phone" value="${ff}{phone}"/>
                        <c:set target="${ff}{parameterMap}" property="invitePhone" value="${ff}{invitePhone}"/>
                        <c:set target="${ff}{parameterMap}" property="city" value="${ff}{city}"/>
                        <stag:PageViewTag baseUrl="${ff}{pageContext.request.contextPath}/consumer/consumerList"
                                          pageView="${ff}{pageView}" parameterMap="${ff}{parameterMap}"/>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>

<script>
    ${ff}(function () {
        var city = '${ff}{city}';

        ${ff}("#s_province").val(city);
    })
</script>
</body>
</html>
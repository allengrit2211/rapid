<#assign ff = "$">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="left">
    <ul>
        <c:choose>
            <c:when test="${ff}{pageContext.session.getAttribute('user_session').type==1}">
                <li><a class="icon1" href="${ff}{pageContext.request.contextPath}/category/categoryList">分类管理</a></li>
                <li><a class="icon2" href="${ff}{pageContext.request.contextPath}/commodity/manageCommodityList">商品管理</a></li>
                <li><a class="icon3" href="${ff}{pageContext.request.contextPath}/timePurchase/timePurchaseList">限时抢购</a></li>
                <li><a class="icon5" href="${ff}{pageContext.request.contextPath}/user/userList">用户列表</a></li>
                <li><a class="icon6" href="${ff}{pageContext.request.contextPath}/recommend/recommendList">今日推荐</a></li>
                <li><a class="icon7" href="${ff}{pageContext.request.contextPath}/consumer/consumerList">APP会员</a></li>
                <li><a class="icon8" href="${ff}{pageContext.request.contextPath}/order/orderList">订单列表</a></li>
                <li><a class="icon9" href="${ff}{pageContext.request.contextPath}/infoRelease/infoReleaseShow">首页内容</a></li>
                <li><a class="icon10" href="${ff}{pageContext.request.contextPath}/bulletin/bulletinList">公告管理</a></li>
                <li><a class="icon11" href="${ff}{pageContext.request.contextPath}/keywords/keywordsList">关键字</a></li>
            </c:when>
            <c:when test="${ff}{pageContext.session.getAttribute('user_session').type==2}">
                <li><a class="icon2" href="${ff}{pageContext.request.contextPath}/commodity/manageCommodityList">商品管理</a></li>
            </c:when>
            <c:otherwise>
                <li><a class="icon4" href="${ff}{pageContext.request.contextPath}/commodity/commodityList">商品列表</a></li>
            </c:otherwise>
        </c:choose>
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
<#assign ff = "$">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="left">
    <ul>
        <c:import url="../menu.jsp"/>
    </ul>
    <input type="button" value="退出登录" class="btnExit" onclick="loginout()"/>
</div>
<script type="text/javascript">
    $(function () {
        var url = window.location.href;
        $(".left ul li a").each(function (i,e) {
            if(url.indexOf($(e).attr("href"))>-1){
                $(e).parent("li").addClass("active")
            }
        })
        var _height = ${ff}(".back-gray").height();//可见区域高度
        $(".left").css("min-height",_height);
    })

</script>
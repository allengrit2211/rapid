<#assign ff = "$">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${ff}{pageContext.request.contextPath}/css/style.css"/>
<script type="text/javascript" src="${ff}{pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>

<link rel="stylesheet" href="${ff}{pageContext.request.contextPath}/js/jquery.confirm/jquery.confirm.css" />
<script src="${ff}{pageContext.request.contextPath}/js/jquery.confirm/jquery.confirm.js"></script>
<script src="${ff}{pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="text/javascript" src="${ff}{pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
<link type="text/css" href="${ff}{pageContext.request.contextPath}/css/pageView.css" rel="stylesheet"  />

<script type="text/javascript">

    ${ff}(function(){
        // 设置jQuery Ajax全局的参数
        ${ff}.ajaxSetup({
            cache: false,
            error: function (data, df, d) {
                alert("网络请求失败，请检查您的网络设置");
            }
        });
    });


    function loginout() {
        var url = "${ff}{pageContext.request.contextPath}/user/loginout";
        ${ff}.ajax({
            type: "get",
            url:url,
            dataType: 'json',
            success: function (data) {
                if(data.code==1){
                    window.location.href="${ff}{pageContext.request.contextPath}/";
                }
            }
        });
    }

    function outMsg(id,msg){
        ${ff}("#"+id).html(msg);
        try{
            setTimeout(function () {
                ${ff}("#"+id).html("");
            },5000)
        }catch (e){};
    }


</script>
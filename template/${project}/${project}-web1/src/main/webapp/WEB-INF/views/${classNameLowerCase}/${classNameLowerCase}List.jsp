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
                    <input id="add_btn" type="button" class="button-normal" value="新增" />
                </div>
            </form>
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
                        <td><input type="button" value="编辑" onclick="popupShow(${ff}{item.id},{<#list table.columns as column>'${column.columnNameLower}':'${ff}{item.${column.columnNameLower}}'<#if column_has_next>,</#if></#list>});"/><input type="button" value="删除" onclick="deleteItem(${ff}{item.id});"/></td>
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

<div id="popupLimit" class="popup-box">
    <div id="msg11"></div>
    <form id="addForm" method="post" action="${ff}{pageContext.request.contextPath}/${classNameLower}/${classNameLower}Edit">
        <input type="hidden" id="h_id" name="id">
        <div class="close" onclick="popupClose();" title="关闭"></div>
        <p class="title">添加</p>
        <ul>
            <#list table.notPkColumns as column>
                <li>
                    <span>${column.columnAlias}</span><input type="text" id="tb_${column.columnNameLower}" name="${column.columnNameLower}"/>
                </li>
            </#list>
        </ul>
        <div class="button-box">
            <input type="button" value="取消" onclick="popupClose();" class="btn_cancel"/><input id="btn_submit" type="button" value="保存"/>
        </div>
    </form>
</div>

<div class="back-gray"></div>

<script>

    var w = ${ff}(".back-gray").width();//可见区域宽度
    var h = ${ff}(".back-gray").height();//可见区域高度
    var pLeft = (w-660)/2;
    var pTop = (h-506)/2;

    ${ff}("#add_btn").click(function(){
        popupShow();
    });

    function popupShow(id,obj){ //打开编辑框

        if(id){
            ${ff}("#h_id").val(id);
            <#list table.notPkColumns as column>
            $("#tb_${column.columnNameLower}").val(obj.${column.columnNameLower});
            </#list>
            $("#addForm .title").text("编辑")
        }else{
            $("#addForm .title").text("添加")
        }

        ${ff}(".back-gray").show();
        ${ff}("#popupLimit").css({"top":pTop+"px","left":pLeft+"px"}).show();
    }

    $("#btn_submit").click(function(){
        //新增或编辑
        if($("#popupLimit").attr("value")){
            //alert("这是修改状态");

        }else{
            //alert("这是新增状态");

        }

        edit${className}();
    });


    function edit${className}() {

        var url = "${ff}{pageContext.request.contextPath}/${classNameLower}/${classNameLower}Edit";
        $.ajax({
            type: "post",
            data:$("#addForm").serialize(),
            url:url,
            success: function (data) {
                if(data.code==1){
                    toast(data.msg)
                    setTimeout(function () {
                        window.location.reload()
                    },1000)
                    popupClose()
                }else{
                    toast(data.msg)
                }
            }
        });
    }

    function popupClose(){ //关闭编辑框
        ${ff}("#popupLimit").hide();
        ${ff}(".back-gray").hide();
    }

    function deleteItem(id) {
        if(id){
            $.confirm({
                'title'	: '消息框',
                'message'	: '是否删该记录？',
                'buttons'	:{
                    '确认':{
                        'class' : 'btn_ok',
                        'action': function(){
                            var url = "${ff}{pageContext.request.contextPath}/${classNameLower}/${classNameLower}Del";
                            $.ajax({
                                type: "post",
                                data:{id:id},
                                url:url,
                                success: function (data) {
                                    if(data.code==1){
                                        toast(data.msg)
                                        setTimeout(function () {
                                            window.location.reload()
                                        },1000)
                                        popupClose()
                                    }else{
                                        toast(data.msg)
                                    }
                                }
                            });
                        }
                    },
                    '取消':{
                        'class' : 'gray',
                        'action': function(){

                        }
                    }
                }
            });
        }
    }


</script>
</body>
</html>
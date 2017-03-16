
<#assign ff = "$">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<li><a class="icon1" href="${ff}{pageContext.request.contextPath}/${classNameLower}/${classNameLower}List">${table.tableAlias}管理</a></li>
<!--  generator-insert-location -->
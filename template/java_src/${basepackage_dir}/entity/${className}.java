<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameStr = className+'Controller'>
package ${basepackage}.entity;

import java.util.*;
import java.math.BigDecimal;

<#include "/info.include">
public class ${className} implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	<#list table.columns as column>
	<#include "/columnAlias.include">
	private ${column.javaType} ${column.columnNameLower};
	</#list>
	
	<#list table.columns as column>
	public ${column.javaType} get${column.columnName}(){
		return this.${column.columnNameLower};
	}
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	</#list>

//	public String toString() {
//		return new StringBuilder(super.toString()).append("=").append("[\n")
//		<#list table.columns as column>
//		.append("${column.columnName}=").append("<").append(get${column.columnName}()).append(">\n")
//		</#list>
//		.append("]")
//		.toString();
//	}

}

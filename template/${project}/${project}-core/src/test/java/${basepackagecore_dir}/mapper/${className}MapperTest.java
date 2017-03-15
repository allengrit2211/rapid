<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackagecore}.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


import ${basepackagecore}.entity.${className};
import ${basepackagecore}.mapper.${className}Mapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config.xml"}, inheritLocations = false)
@Transactional
public class ${className}MapperTest{

	@Autowired
	private ${className}Mapper ${classNameLower}Mapper;

	@Test
	@Rollback(true)
	public void testInsert${className}(){
		${className} i${classNameLower} = new ${className}();
		<#list table.columns as column>
		<#if (column.javaType?index_of("Integer")>0) >
			i${classNameLower}.set${column?cap_first}(0);
		<#elseif (column.javaType?index_of("String")>0) >
			i${classNameLower}.set${column?cap_first}("xxx");
		<#elseif (column.javaType?index_of("Date")>0) >
			i${classNameLower}.set${column?cap_first}(new Date());
		<#elseif (column.javaType?index_of("Short")>0) >
			i${classNameLower}.set${column?cap_first}((short)0);
		</#if>
		</#list>
		${classNameLower}Mapper.insert${className}(i${classNameLower});
	}

	@Test
	@Rollback(true)
	public void testUpdate${className}(){
		${className} u${classNameLower} = new ${className}();

		<#list table.columns as column>
			<#if (column.javaType?index_of("Integer")>0) >
				u${classNameLower}.set${column?cap_first}(0);
			<#elseif (column.javaType?index_of("String")>0) >
				u${classNameLower}.set${column?cap_first}("xxx");
			<#elseif (column.javaType?index_of("Date")>0) >
				u${classNameLower}.set${column?cap_first}(new Date());
			<#elseif (column.javaType?index_of("Short")>0) >
				u${classNameLower}.set${column?cap_first}((short)0);
			</#if>
		</#list>
		${classNameLower}Mapper.update${className}(u${classNameLower});
	}

	@Test
	@Rollback(true)
	public void testDelete${className}(){
		${classNameLower}Mapper.delete${className}(1);
	}

	@Test
	@Rollback(true)
	public void testGet${className}ById(){
		${classNameLower}Mapper.get${className}ById(1);
	}

	@Test
	@Rollback(true)
	public void testGet${className}(){
		Map param = new HashMap<>();
		param.put("id",1);
		${classNameLower}Mapper.get${className}(param);
	}

	@Test
	@Rollback(true)
	public void testGet${className}List(){
		Map param = new HashMap<>();
		${classNameLower}Mapper.get${className}List(param);
	}

	@Test
	@Rollback(true)
	public void testGet${className}Count(){
		Map param = new HashMap<>();
		${classNameLower}Mapper.get${className}Count(param);
	}

	@Test
	@Rollback(true)
	public void testGetSplit${className}List(){
		Map param = new HashMap<>();
		param.put("endSize",0);
		param.put("pageSize",100);
		${classNameLower}Mapper.getSplit${className}List(param);
	}

}

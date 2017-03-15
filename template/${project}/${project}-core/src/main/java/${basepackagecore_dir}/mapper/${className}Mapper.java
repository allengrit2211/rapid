<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameStr = className+'Mapper'>
package ${basepackagecore}.mapper;

import java.util.List;
import java.util.Map;

import ${basepackagecore}.entity.${className};

<#include "/info.include">
public interface ${className}Mapper{
	
	public Integer insert${className}(${className} ${classNameLower});  	
	
	public Integer update${className}(${className} ${classNameLower});
	
	public Integer delete${className}(Integer id);

	public ${className} get${className}ById(Integer id);

	public ${className} get${className}(Map param);
	
	public List get${className}List(Map param);

	public Integer get${className}Count(Map param);
	
	public List getSplit${className}List(Map param);

}

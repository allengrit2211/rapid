<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameStr = className+'ServiceImpl'>
package ${basepackagecore}.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import ${basepackagecore}.mapper.${className}Mapper;
import ${basepackagecore}.entity.${className};
import ${basepackagecore}.service.I${className}Service;

<#include "/info.include">
@Transactional(readOnly=true)
@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements I${className}Service{

	@Autowired
	private ${className}Mapper ${classNameLower}Mapper;
	
	@Transactional(readOnly=false)
	public Integer insert${className}(${className} ${classNameLower}) {
		return ${classNameLower}Mapper.insert${className}(${classNameLower});
	}

	@Transactional(readOnly=false)
	public Integer insertBatch${className}(List<${className}> ${classNameLower}s){
		return ${classNameLower}Mapper.insertBatch${className}(${classNameLower}s);
	}

	@Transactional(readOnly=false)
	public Integer update${className}(${className} ${classNameLower}) {
		return ${classNameLower}Mapper.update${className}(${classNameLower});
	}
	
	@Transactional(readOnly=false)
	public Integer delete${className}(Integer id) {
		return ${classNameLower}Mapper.delete${className}(id);
	}

	public ${className} get${className}ById(Integer id){
		return ${classNameLower}Mapper.get${className}ById(id);
	}
	
	public ${className} get${className}(Map param) {
		return ${classNameLower}Mapper.get${className}(param);
	}
	
	public List<${className}> get${className}List(Map param) {
		return ${classNameLower}Mapper.get${className}List(param);
	}
	
	public Integer get${className}Count(Map param) {
		return (Integer)${classNameLower}Mapper.get${className}Count(param);
	}
	
	public List<${className}> getSplit${className}List(Map param) {
		return ${classNameLower}Mapper.getSplit${className}List(param);
	}
	
}

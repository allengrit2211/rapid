<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameStr = className+'Controller'>
package ${basepackage}.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


import ${basepackage}.entity.${className};
import ${basepackage}.service.I${className}Service;

<#include "/info.include">
@Controller
public class ${className}Controller {

	public static final Log logger = LogFactory.getLog(${className}Controller.class);

	@Autowired
	private I${className}Service ${classNameLower}Service;

	@RequestMapping(value = "/${classNameLower}/add")
	public String add(HttpServletRequest request, Model model) {
		return "/${className}/add";
	}
	
	@RequestMapping(value = "/${className}/del")
	public String del() {
		return "/${className}/del";
	}
	
	@RequestMapping(value = "/${className}/update")
	public String update() {
		return "/${className}/update";
	}
	
	@RequestMapping(value = "/${classNameLower}/list")
	public String list(HttpServletRequest request, Model model, PageView pageView) {
		
		Map<String, Object> param = new HashMap<String, Object>();

		int totalRecord = ${classNameLower}Service.get${className}Count(param);
		if (totalRecord == 0) {
			return "/${classNameLower}/list";
		}

		pageView.setPageSize(10);

		param.put("endSize", pageView.getFirstResult());
		param.put("pageSize", pageView.getPageSize());

		List list = ${classNameLower}Service.getSplit${className}List(param);
		pageView.setTotalRecord(totalRecord);
		pageView.setRecords(list);
		model.addAttribute("pageView", pageView);	
		
		return "/${classNameLower}/list";
	}

}

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
import org.common5iq.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.ModelMap;

import ${basepackagecore}.base.page.PageView;
import ${basepackagecore}.entity.${className};
import ${basepackagecore}.service.I${className}Service;

<#include "/info.include">
@Controller
public class ${className}Controller {

	public static final Log logger = LogFactory.getLog(${className}Controller.class);

	@Autowired
	private I${className}Service ${classNameLower}Service;

	@RequestMapping(value = "/${classNameLower}/${classNameLower}List")
	public String ${classNameLower}List(HttpServletRequest request,Model model) {

		int currentPage = Utils.toInteger(request.getParameter("currentPage"));

		PageView pageView = new PageView();
		model.addAttribute("pageView", pageView);
		Map<String, Object> param = new HashMap<String, Object>();

		int totalRecord = ${classNameLower}Service.get${className}Count(param);
		if (totalRecord == 0) {
		    return "/${classNameLower}/${classNameLower}List";
		}


		pageView.setCurrentPage(currentPage);
		pageView.setTotalRecord(totalRecord);
		pageView.setPageSize(${pageSize});

		param.put("endSize", pageView.getFirstResult());
		param.put("pageSize", pageView.getPageSize());

		List list = ${classNameLower}Service.getSplit${className}List(param);
		pageView.setTotalRecord(totalRecord);
		pageView.setRecords(list);
		model.addAttribute("pageView", pageView);

		return "/${classNameLower}/${classNameLower}List";
	}


	@RequestMapping(value = "/${classNameLower}/${classNameLower}Edit")
	@ResponseBody
	public ModelMap ${classNameLower}Edit(HttpServletRequest request,${className} ${classNameLower}) {

		ModelMap modelMap = new ModelMap();

		int id = 0;
		if(${classNameLower}.getId()==null){
			id = ${classNameLower}Service.insert${className}(${classNameLower});
		}else{
			id = ${classNameLower}Service.update${className}(${classNameLower});
		}
		if(id>0){
			modelMap.put("code",1);
			modelMap.put("msg","保存成功");
		}else{
			modelMap.put("code",2);
			modelMap.put("msg","保存失败");
		}
		return modelMap;
	}

	@RequestMapping(value = "/${classNameLower}/${classNameLower}Del")
	@ResponseBody
	public ModelMap ${classNameLower}Del(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		int id = Utils.toInteger(request.getParameter("id"));
		int _id = ${classNameLower}Service.delete${className}(id);
		if (_id > 0) {
			modelMap.put("code", 1);
			modelMap.put("msg", "刪除成功");
		} else {
			modelMap.put("code", 2);
			modelMap.put("msg", "刪除失败");
		}
		return modelMap;
	}




}

/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package net.uchoice.conveyor.modules.template.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.uchoice.conveyor.common.config.Global;
import net.uchoice.conveyor.common.persistence.Page;
import net.uchoice.conveyor.common.web.BaseController;
import net.uchoice.conveyor.common.utils.StringUtils;
import net.uchoice.conveyor.modules.template.entity.ConveyorMsgTemplate;
import net.uchoice.conveyor.modules.template.service.ConveyorMsgTemplateService;

/**
 * 消息模板Controller
 * @author seam
 * @version 2017-08-12
 */
@Controller
@RequestMapping(value = "${adminPath}/template/conveyorMsgTemplate")
public class ConveyorMsgTemplateController extends BaseController {

	@Autowired
	private ConveyorMsgTemplateService conveyorMsgTemplateService;
	
	@ModelAttribute
	public ConveyorMsgTemplate get(@RequestParam(required=false) String id) {
		ConveyorMsgTemplate entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = conveyorMsgTemplateService.get(id);
		}
		if (entity == null){
			entity = new ConveyorMsgTemplate();
		}
		return entity;
	}
	
	@RequiresPermissions("template:conveyorMsgTemplate:view")
	@RequestMapping(value = {"list", ""})
	public String list(ConveyorMsgTemplate conveyorMsgTemplate, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ConveyorMsgTemplate> page = conveyorMsgTemplateService.findPage(new Page<ConveyorMsgTemplate>(request, response), conveyorMsgTemplate); 
		model.addAttribute("page", page);
		return "modules/template/conveyorMsgTemplateList";
	}

	@RequiresPermissions("template:conveyorMsgTemplate:view")
	@RequestMapping(value = "form")
	public String form(ConveyorMsgTemplate conveyorMsgTemplate, Model model) {
		model.addAttribute("conveyorMsgTemplate", conveyorMsgTemplate);
		return "modules/template/conveyorMsgTemplateForm";
	}

	@RequiresPermissions("template:conveyorMsgTemplate:edit")
	@RequestMapping(value = "save")
	public String save(ConveyorMsgTemplate conveyorMsgTemplate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, conveyorMsgTemplate)){
			return form(conveyorMsgTemplate, model);
		}
		conveyorMsgTemplateService.save(conveyorMsgTemplate);
		addMessage(redirectAttributes, "保存消息模板成功");
		return "redirect:"+Global.getAdminPath()+"/template/conveyorMsgTemplate/?repage";
	}
	
	@RequiresPermissions("template:conveyorMsgTemplate:edit")
	@RequestMapping(value = "delete")
	public String delete(ConveyorMsgTemplate conveyorMsgTemplate, RedirectAttributes redirectAttributes) {
		conveyorMsgTemplateService.delete(conveyorMsgTemplate);
		addMessage(redirectAttributes, "删除消息模板成功");
		return "redirect:"+Global.getAdminPath()+"/template/conveyorMsgTemplate/?repage";
	}

}
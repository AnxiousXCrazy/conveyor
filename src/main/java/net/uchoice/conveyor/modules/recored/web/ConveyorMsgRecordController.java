/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package net.uchoice.conveyor.modules.recored.web;

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
import net.uchoice.conveyor.modules.recored.entity.ConveyorMsgRecord;
import net.uchoice.conveyor.modules.recored.service.ConveyorMsgRecordService;

/**
 * 消息记录Controller
 * @author seam
 * @version 2017-08-12
 */
@Controller
@RequestMapping(value = "${adminPath}/recored/conveyorMsgRecord")
public class ConveyorMsgRecordController extends BaseController {

	@Autowired
	private ConveyorMsgRecordService conveyorMsgRecordService;
	
	@ModelAttribute
	public ConveyorMsgRecord get(@RequestParam(required=false) String id) {
		ConveyorMsgRecord entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = conveyorMsgRecordService.get(id);
		}
		if (entity == null){
			entity = new ConveyorMsgRecord();
		}
		return entity;
	}
	
	@RequiresPermissions("recored:conveyorMsgRecord:view")
	@RequestMapping(value = {"list", ""})
	public String list(ConveyorMsgRecord conveyorMsgRecord, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ConveyorMsgRecord> page = conveyorMsgRecordService.findPage(new Page<ConveyorMsgRecord>(request, response), conveyorMsgRecord); 
		model.addAttribute("page", page);
		return "modules/recored/conveyorMsgRecordList";
	}

	@RequiresPermissions("recored:conveyorMsgRecord:view")
	@RequestMapping(value = "form")
	public String form(ConveyorMsgRecord conveyorMsgRecord, Model model) {
		model.addAttribute("conveyorMsgRecord", conveyorMsgRecord);
		return "modules/recored/conveyorMsgRecordForm";
	}

	@RequiresPermissions("recored:conveyorMsgRecord:edit")
	@RequestMapping(value = "save")
	public String save(ConveyorMsgRecord conveyorMsgRecord, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, conveyorMsgRecord)){
			return form(conveyorMsgRecord, model);
		}
		conveyorMsgRecordService.save(conveyorMsgRecord);
		addMessage(redirectAttributes, "保存消息记录成功");
		return "redirect:"+Global.getAdminPath()+"/recored/conveyorMsgRecord/?repage";
	}
	
	@RequiresPermissions("recored:conveyorMsgRecord:edit")
	@RequestMapping(value = "delete")
	public String delete(ConveyorMsgRecord conveyorMsgRecord, RedirectAttributes redirectAttributes) {
		conveyorMsgRecordService.delete(conveyorMsgRecord);
		addMessage(redirectAttributes, "删除消息记录成功");
		return "redirect:"+Global.getAdminPath()+"/recored/conveyorMsgRecord/?repage";
	}

}
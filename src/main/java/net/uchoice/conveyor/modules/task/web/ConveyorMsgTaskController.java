/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package net.uchoice.conveyor.modules.task.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.uchoice.conveyor.common.config.Global;
import net.uchoice.conveyor.common.persistence.Page;
import net.uchoice.conveyor.common.utils.StringUtils;
import net.uchoice.conveyor.common.web.BaseController;
import net.uchoice.conveyor.modules.task.entity.ConveyorMsgTask;
import net.uchoice.conveyor.modules.task.service.ConveyorMsgTaskService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 发送任务Controller
 * @author seam
 * @version 2017-08-12
 */
@Controller
@RequestMapping(value = "${adminPath}/task/conveyorMsgTask")
public class ConveyorMsgTaskController extends BaseController {

	@Autowired
	private ConveyorMsgTaskService conveyorMsgTaskService;
	
	@ModelAttribute
	public ConveyorMsgTask get(@RequestParam(required=false) String id) {
		ConveyorMsgTask entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = conveyorMsgTaskService.get(id);
			parseSendTypeList(entity);
		}
		if (entity == null){
			entity = new ConveyorMsgTask();
		}
		return entity;
	}
	
	@RequiresPermissions("task:conveyorMsgTask:view")
	@RequestMapping(value = {"list", ""})
	public String list(ConveyorMsgTask conveyorMsgTask, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ConveyorMsgTask> page = conveyorMsgTaskService.findPage(new Page<ConveyorMsgTask>(request, response), conveyorMsgTask); 
		if (null != page.getList()) {
			for (ConveyorMsgTask task : page.getList()) {
				parseSendTypeList(task);
			}
		}
		model.addAttribute("page", page);
		return "modules/task/conveyorMsgTaskList";
	}

	@RequiresPermissions("task:conveyorMsgTask:view")
	@RequestMapping(value = "form")
	public String form(ConveyorMsgTask conveyorMsgTask, Model model) {
		model.addAttribute("conveyorMsgTask", conveyorMsgTask);
		return "modules/task/conveyorMsgTaskForm";
	}

	@RequiresPermissions("task:conveyorMsgTask:edit")
	@RequestMapping(value = "save")
	public String save(ConveyorMsgTask conveyorMsgTask, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, conveyorMsgTask)){
			return form(conveyorMsgTask, model);
		}
		parseSendTypeString(conveyorMsgTask);
		conveyorMsgTaskService.save(conveyorMsgTask);
		addMessage(redirectAttributes, "保存发送任务成功");
		return "redirect:"+Global.getAdminPath()+"/task/conveyorMsgTask/?repage";
	}
	
	@RequiresPermissions("task:conveyorMsgTask:edit")
	@RequestMapping(value = "delete")
	public String delete(ConveyorMsgTask conveyorMsgTask, RedirectAttributes redirectAttributes) {
		conveyorMsgTaskService.delete(conveyorMsgTask);
		addMessage(redirectAttributes, "删除发送任务成功");
		return "redirect:"+Global.getAdminPath()+"/task/conveyorMsgTask/?repage";
	}

	private void parseSendTypeList(ConveyorMsgTask conveyorMsgTask) {
		if (null != conveyorMsgTask && StringUtils.isNoneBlank(conveyorMsgTask.getSendType())) {
			conveyorMsgTask.setSendTypes(conveyorMsgTask.getSendType().split(","));
		}
	}

	private void parseSendTypeString(ConveyorMsgTask conveyorMsgTask) {
		if (null != conveyorMsgTask && null != conveyorMsgTask.getSendTypes()) {
			conveyorMsgTask.setSendType(StringUtils.join(conveyorMsgTask.getSendTypes(), ","));
		}
	}
}
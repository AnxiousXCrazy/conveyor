/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package net.uchoice.conveyor.modules.template.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.uchoice.conveyor.common.persistence.Page;
import net.uchoice.conveyor.common.service.CrudService;
import net.uchoice.conveyor.modules.template.entity.ConveyorMsgTemplate;
import net.uchoice.conveyor.modules.template.dao.ConveyorMsgTemplateDao;

/**
 * 消息模板Service
 * @author seam
 * @version 2017-08-12
 */
@Service
@Transactional(readOnly = true)
public class ConveyorMsgTemplateService extends CrudService<ConveyorMsgTemplateDao, ConveyorMsgTemplate> {

	public ConveyorMsgTemplate get(String id) {
		return super.get(id);
	}
	
	public List<ConveyorMsgTemplate> findList(ConveyorMsgTemplate conveyorMsgTemplate) {
		return super.findList(conveyorMsgTemplate);
	}
	
	public Page<ConveyorMsgTemplate> findPage(Page<ConveyorMsgTemplate> page, ConveyorMsgTemplate conveyorMsgTemplate) {
		return super.findPage(page, conveyorMsgTemplate);
	}
	
	@Transactional(readOnly = false)
	public void save(ConveyorMsgTemplate conveyorMsgTemplate) {
		super.save(conveyorMsgTemplate);
	}
	
	@Transactional(readOnly = false)
	public void delete(ConveyorMsgTemplate conveyorMsgTemplate) {
		super.delete(conveyorMsgTemplate);
	}
	
}
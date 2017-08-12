/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package net.uchoice.conveyor.modules.task.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.uchoice.conveyor.common.persistence.Page;
import net.uchoice.conveyor.common.service.CrudService;
import net.uchoice.conveyor.modules.task.entity.ConveyorMsgTask;
import net.uchoice.conveyor.modules.task.dao.ConveyorMsgTaskDao;

/**
 * 发送任务Service
 * @author seam
 * @version 2017-08-12
 */
@Service
@Transactional(readOnly = true)
public class ConveyorMsgTaskService extends CrudService<ConveyorMsgTaskDao, ConveyorMsgTask> {

	public ConveyorMsgTask get(String id) {
		return super.get(id);
	}
	
	public List<ConveyorMsgTask> findList(ConveyorMsgTask conveyorMsgTask) {
		return super.findList(conveyorMsgTask);
	}
	
	public Page<ConveyorMsgTask> findPage(Page<ConveyorMsgTask> page, ConveyorMsgTask conveyorMsgTask) {
		return super.findPage(page, conveyorMsgTask);
	}
	
	@Transactional(readOnly = false)
	public void save(ConveyorMsgTask conveyorMsgTask) {
		super.save(conveyorMsgTask);
	}
	
	@Transactional(readOnly = false)
	public void delete(ConveyorMsgTask conveyorMsgTask) {
		super.delete(conveyorMsgTask);
	}
	
}
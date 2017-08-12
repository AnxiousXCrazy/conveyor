/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package net.uchoice.conveyor.modules.recored.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.uchoice.conveyor.common.persistence.Page;
import net.uchoice.conveyor.common.service.CrudService;
import net.uchoice.conveyor.modules.recored.entity.ConveyorMsgRecord;
import net.uchoice.conveyor.modules.recored.dao.ConveyorMsgRecordDao;

/**
 * 消息记录Service
 * @author seam
 * @version 2017-08-12
 */
@Service
@Transactional(readOnly = true)
public class ConveyorMsgRecordService extends CrudService<ConveyorMsgRecordDao, ConveyorMsgRecord> {

	public ConveyorMsgRecord get(String id) {
		return super.get(id);
	}
	
	public List<ConveyorMsgRecord> findList(ConveyorMsgRecord conveyorMsgRecord) {
		return super.findList(conveyorMsgRecord);
	}
	
	public Page<ConveyorMsgRecord> findPage(Page<ConveyorMsgRecord> page, ConveyorMsgRecord conveyorMsgRecord) {
		return super.findPage(page, conveyorMsgRecord);
	}
	
	@Transactional(readOnly = false)
	public void save(ConveyorMsgRecord conveyorMsgRecord) {
		super.save(conveyorMsgRecord);
	}
	
	@Transactional(readOnly = false)
	public void delete(ConveyorMsgRecord conveyorMsgRecord) {
		super.delete(conveyorMsgRecord);
	}
	
}
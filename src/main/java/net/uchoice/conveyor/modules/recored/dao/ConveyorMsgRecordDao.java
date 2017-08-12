/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package net.uchoice.conveyor.modules.recored.dao;

import net.uchoice.conveyor.common.persistence.CrudDao;
import net.uchoice.conveyor.common.persistence.annotation.MyBatisDao;
import net.uchoice.conveyor.modules.recored.entity.ConveyorMsgRecord;

/**
 * 消息记录DAO接口
 * @author seam
 * @version 2017-08-12
 */
@MyBatisDao
public interface ConveyorMsgRecordDao extends CrudDao<ConveyorMsgRecord> {
	
}
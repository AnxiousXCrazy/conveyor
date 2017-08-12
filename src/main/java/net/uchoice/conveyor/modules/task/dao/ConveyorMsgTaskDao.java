/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package net.uchoice.conveyor.modules.task.dao;

import net.uchoice.conveyor.common.persistence.CrudDao;
import net.uchoice.conveyor.common.persistence.annotation.MyBatisDao;
import net.uchoice.conveyor.modules.task.entity.ConveyorMsgTask;

/**
 * 发送任务DAO接口
 * @author seam
 * @version 2017-08-12
 */
@MyBatisDao
public interface ConveyorMsgTaskDao extends CrudDao<ConveyorMsgTask> {
	
}
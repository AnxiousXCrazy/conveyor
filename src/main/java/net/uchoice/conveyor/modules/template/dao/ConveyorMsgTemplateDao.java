/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package net.uchoice.conveyor.modules.template.dao;

import net.uchoice.conveyor.common.persistence.CrudDao;
import net.uchoice.conveyor.common.persistence.annotation.MyBatisDao;
import net.uchoice.conveyor.modules.template.entity.ConveyorMsgTemplate;

/**
 * 消息模板DAO接口
 * @author seam
 * @version 2017-08-12
 */
@MyBatisDao
public interface ConveyorMsgTemplateDao extends CrudDao<ConveyorMsgTemplate> {
	
}
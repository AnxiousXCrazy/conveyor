/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package net.uchoice.conveyor.modules.template.entity;

import org.hibernate.validator.constraints.Length;
import net.uchoice.conveyor.modules.sys.entity.User;

import net.uchoice.conveyor.common.persistence.DataEntity;

/**
 * 消息模板Entity
 * @author seam
 * @version 2017-08-12
 */
public class ConveyorMsgTemplate extends DataEntity<ConveyorMsgTemplate> {
	
	private static final long serialVersionUID = 1L;
	private String source;		// 来源
	private String title;		// 标题
	private String content;		// 内容
	private String params;		// 参数
	private String auditStatus;		// 审核状态
	private User auditBy;		// 审核人
	
	public ConveyorMsgTemplate() {
		super();
	}

	public ConveyorMsgTemplate(String id){
		super(id);
	}

	@Length(min=1, max=100, message="来源长度必须介于 1 和 100 之间")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Length(min=1, max=100, message="标题长度必须介于 1 和 100 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
	
	@Length(min=0, max=20, message="审核状态长度必须介于 0 和 20 之间")
	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	
	public User getAuditBy() {
		return auditBy;
	}

	public void setAuditBy(User auditBy) {
		this.auditBy = auditBy;
	}
	
}
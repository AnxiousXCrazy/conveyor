/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package net.uchoice.conveyor.modules.task.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import net.uchoice.conveyor.common.persistence.DataEntity;

/**
 * 发送任务Entity
 * @author seam
 * @version 2017-08-12
 */
public class ConveyorMsgTask extends DataEntity<ConveyorMsgTask> {
	
	private static final long serialVersionUID = 1L;
	private String recName;		// 接收人
	private String recEmail;		// 接收人邮箱
	private String recMobile;		// 接收人手机
	private String msgTemplate;		// 消息模板
	private String sendType;		// 发送类型
	private String[] sendTypes;		// 发送类型(多个)
	private String sendStatus;		// 发送状态
	private String taskType;		// 任务类型
	private Date sendDateLmtSt;		// 发送日期限制起
	private Date sendDateLmtEd;		// 发送日期限制止
	private String sendTimeLmt;		// 发送时间限制
	private Integer priority;		// 优先级
	
	public ConveyorMsgTask() {
		super();
	}

	public ConveyorMsgTask(String id){
		super(id);
	}

	@Length(min=1, max=100, message="接收人长度必须介于 1 和 100 之间")
	public String getRecName() {
		return recName;
	}

	public void setRecName(String recName) {
		this.recName = recName;
	}
	
	@Length(min=1, max=100, message="接收人邮箱长度必须介于 1 和 100 之间")
	public String getRecEmail() {
		return recEmail;
	}

	public void setRecEmail(String recEmail) {
		this.recEmail = recEmail;
	}
	
	@Length(min=1, max=20, message="接收人手机长度必须介于 1 和 20 之间")
	public String getRecMobile() {
		return recMobile;
	}

	public void setRecMobile(String recMobile) {
		this.recMobile = recMobile;
	}
	
	@Length(min=1, max=64, message="消息模板长度必须介于 1 和 64 之间")
	public String getMsgTemplate() {
		return msgTemplate;
	}

	public void setMsgTemplate(String msgTemplate) {
		this.msgTemplate = msgTemplate;
	}
	
	@Length(min=1, max=20, message="发送类型长度必须介于 1 和 20 之间")
	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	
	@Length(min=1, max=20, message="发送状态长度必须介于 1 和 20 之间")
	public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}
	
	@Length(min=1, max=10, message="任务类型长度必须介于 1 和 10 之间")
	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSendDateLmtSt() {
		return sendDateLmtSt;
	}

	public void setSendDateLmtSt(Date sendDateLmtSt) {
		this.sendDateLmtSt = sendDateLmtSt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSendDateLmtEd() {
		return sendDateLmtEd;
	}

	public void setSendDateLmtEd(Date sendDateLmtEd) {
		this.sendDateLmtEd = sendDateLmtEd;
	}
	
	@Length(min=0, max=100, message="发送时间限制长度必须介于 0 和 100 之间")
	public String getSendTimeLmt() {
		return sendTimeLmt;
	}

	public void setSendTimeLmt(String sendTimeLmt) {
		this.sendTimeLmt = sendTimeLmt;
	}
	
	@NotNull(message="优先级不能为空")
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String[] getSendTypes() {
		return sendTypes;
	}

	public void setSendTypes(String[] sendTypes) {
		this.sendTypes = sendTypes;
	}
	
}
/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package net.uchoice.conveyor.modules.recored.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import net.uchoice.conveyor.common.persistence.DataEntity;

/**
 * 消息记录Entity
 * @author seam
 * @version 2017-08-12
 */
public class ConveyorMsgRecord extends DataEntity<ConveyorMsgRecord> {
	
	private static final long serialVersionUID = 1L;
	private String msgType;		// 消息类型
	private String msgTemplate;		// 消息模板
	private String msgTask;		// 发送任务
	private String target;		// 发送对象
	private String title;		// 标题
	private String content;		// 内容
	private Date sendTime;		// 发送时间
	private Date sendTimeSt;		// 发送时间
	private Date sendTimeEd;		// 发送时间
	private String sendResult;		// 发送结果
	private Date createTime;		// 记录时间
	
	public ConveyorMsgRecord() {
		super();
	}

	public ConveyorMsgRecord(String id){
		super(id);
	}

	@Length(min=1, max=10, message="消息类型长度必须介于 1 和 10 之间")
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	@Length(min=1, max=64, message="消息模板长度必须介于 1 和 64 之间")
	public String getMsgTemplate() {
		return msgTemplate;
	}

	public void setMsgTemplate(String msgTemplate) {
		this.msgTemplate = msgTemplate;
	}
	
	@Length(min=1, max=64, message="发送任务长度必须介于 1 和 64 之间")
	public String getMsgTask() {
		return msgTask;
	}

	public void setMsgTask(String msgTask) {
		this.msgTask = msgTask;
	}
	
	@Length(min=1, max=100, message="发送对象长度必须介于 1 和 100 之间")
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="发送时间不能为空")
	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
	@Length(min=0, max=10, message="发送结果长度必须介于 0 和 10 之间")
	public String getSendResult() {
		return sendResult;
	}

	public void setSendResult(String sendResult) {
		this.sendResult = sendResult;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getSendTimeSt() {
		return sendTimeSt;
	}

	public void setSendTimeSt(Date sendTimeSt) {
		this.sendTimeSt = sendTimeSt;
	}

	public Date getSendTimeEd() {
		return sendTimeEd;
	}

	public void setSendTimeEd(Date sendTimeEd) {
		this.sendTimeEd = sendTimeEd;
	}
	
}
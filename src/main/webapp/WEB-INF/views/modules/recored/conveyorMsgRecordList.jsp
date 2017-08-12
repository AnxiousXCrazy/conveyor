<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>消息记录管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/recored/conveyorMsgRecord/">消息记录列表</a></li>
		<shiro:hasPermission name="recored:conveyorMsgRecord:edit"><li><a href="${ctx}/recored/conveyorMsgRecord/form">消息记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="conveyorMsgRecord" action="${ctx}/recored/conveyorMsgRecord/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>消息ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>消息类型：</label>
				<form:select path="msgType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('msg_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>消息模板：</label>
				<form:input path="msgTemplate" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>发送任务：</label>
				<form:input path="msgTask" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>发送对象：</label>
				<form:input path="target" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>发送时间：</label>
				<input name="sendTimeSt" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${conveyorMsgRecord.sendTimeSt}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
					- 
				<input name="sendTimeEd" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${conveyorMsgRecord.sendTimeEd}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</li>
			<li><label>发送结果：</label>
				<form:select path="sendResult" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('send_result')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>消息ID</th>
				<th>消息类型</th>
				<th>消息模板</th>
				<th>发送任务</th>
				<th>发送对象</th>
				<th>标题</th>
				<th>发送时间</th>
				<th>发送结果</th>
				<th>记录时间</th>
				<shiro:hasPermission name="recored:conveyorMsgRecord:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="conveyorMsgRecord">
			<tr>
				<td><a href="${ctx}/recored/conveyorMsgRecord/form?id=${conveyorMsgRecord.id}">
					${conveyorMsgRecord.id}
				</a></td>
				<td>
					${fns:getDictLabel(conveyorMsgRecord.msgType, 'msg_type', '')}
				</td>
				<td>
					${conveyorMsgRecord.msgTemplate}
				</td>
				<td>
					${conveyorMsgRecord.msgTask}
				</td>
				<td>
					${conveyorMsgRecord.target}
				</td>
				<td>
					${conveyorMsgRecord.title}
				</td>
				<td>
					<fmt:formatDate value="${conveyorMsgRecord.sendTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(conveyorMsgRecord.sendResult, 'send_result', '')}
				</td>
				<td>
					<fmt:formatDate value="${conveyorMsgRecord.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="recored:conveyorMsgRecord:edit"><td>
    				<a href="${ctx}/recored/conveyorMsgRecord/form?id=${conveyorMsgRecord.id}">修改</a>
					<a href="${ctx}/recored/conveyorMsgRecord/delete?id=${conveyorMsgRecord.id}" onclick="return confirmx('确认要删除该消息记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>发送任务管理</title>
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
		<li class="active"><a href="${ctx}/task/conveyorMsgTask/">发送任务列表</a></li>
		<shiro:hasPermission name="task:conveyorMsgTask:edit"><li><a href="${ctx}/task/conveyorMsgTask/form">发送任务添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="conveyorMsgTask" action="${ctx}/task/conveyorMsgTask/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>任务ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>接收人：</label>
				<form:input path="recName" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>消息模板：</label>
				<form:input path="msgTemplate" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>发送类型：</label>
				<form:checkboxes path="sendTypes" items="${fns:getDictList('msg_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>发送状态：</label>
				<form:select path="sendStatus" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('send_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>任务类型：</label>
				<form:select path="taskType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('task_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>创建人：</label>
				<sys:treeselect id="createBy" name="createBy.id" value="${conveyorMsgTask.createBy.id}" labelName="" labelValue="${conveyorMsgTask.createBy.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>任务ID</th>
				<th>接收人</th>
				<th>消息模板</th>
				<th>发送类型</th>
				<th>发送状态</th>
				<th>任务类型</th>
				<th>优先级</th>
				<th>创建人</th>
				<th>创建时间</th>
				<shiro:hasPermission name="task:conveyorMsgTask:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="conveyorMsgTask">
			<tr>
				<td><a href="${ctx}/task/conveyorMsgTask/form?id=${conveyorMsgTask.id}">
					${conveyorMsgTask.id}
				</a></td>
				<td>
					${conveyorMsgTask.recName}
				</td>
				<td>
					${conveyorMsgTask.msgTemplate}
				</td>
				<td>
					<c:forEach items="${conveyorMsgTask.sendTypes}" var="sendType">
						${fns:getDictLabel(sendType, 'msg_type', '')},
					</c:forEach>
				</td>
				<td>
					${fns:getDictLabel(conveyorMsgTask.sendStatus, 'send_status', '')}
				</td>
				<td>
					${fns:getDictLabel(conveyorMsgTask.taskType, 'task_type', '')}
				</td>
				<td>
					${conveyorMsgTask.priority}
				</td>
				<td>
					${conveyorMsgTask.createBy.name}
				</td>
				<td>
					<fmt:formatDate value="${conveyorMsgTask.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="task:conveyorMsgTask:edit"><td>
    				<a href="${ctx}/task/conveyorMsgTask/form?id=${conveyorMsgTask.id}">修改</a>
					<a href="${ctx}/task/conveyorMsgTask/delete?id=${conveyorMsgTask.id}" onclick="return confirmx('确认要删除该发送任务吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>消息模板管理</title>
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
		<li class="active"><a href="${ctx}/template/conveyorMsgTemplate/">消息模板列表</a></li>
		<shiro:hasPermission name="template:conveyorMsgTemplate:edit"><li><a href="${ctx}/template/conveyorMsgTemplate/form">消息模板添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="conveyorMsgTemplate" action="${ctx}/template/conveyorMsgTemplate/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>模板ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>来源：</label>
				<form:input path="source" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>审核人：</label>
				<sys:treeselect id="auditBy" name="auditBy.id" value="${conveyorMsgTemplate.auditBy.id}" labelName="" labelValue="${conveyorMsgTemplate.auditBy.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>创建人：</label>
				<sys:treeselect id="createBy" name="createBy.id" value="${conveyorMsgTemplate.createBy.id}" labelName="" labelValue="${conveyorMsgTemplate.createBy.name}"
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
				<th>模板ID</th>
				<th>来源</th>
				<th>标题</th>
				<th>审核状态</th>
				<th>审核人</th>
				<th>创建人</th>
				<th>创建时间</th>
				<shiro:hasPermission name="template:conveyorMsgTemplate:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="conveyorMsgTemplate">
			<tr>
				<td>
					${conveyorMsgTemplate.id}
				</td>
				<td>
					${conveyorMsgTemplate.source}
				</td>
				<td>
					<a href="${ctx}/template/conveyorMsgTemplate/form?id=${conveyorMsgTemplate.id}">
					${conveyorMsgTemplate.title}
				</a></td>
				<td>
					${fns:getDictLabel(conveyorMsgTemplate.auditStatus, 'template_audit_status', '')}
				</td>
				<td>
					${conveyorMsgTemplate.auditBy.name}
				</td>
				<td>
					${conveyorMsgTemplate.createBy.name}
				</td>
				<td>
					<fmt:formatDate value="${conveyorMsgTemplate.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="template:conveyorMsgTemplate:edit"><td>
    				<a href="${ctx}/template/conveyorMsgTemplate/form?id=${conveyorMsgTemplate.id}">修改</a>
					<a href="${ctx}/template/conveyorMsgTemplate/delete?id=${conveyorMsgTemplate.id}" onclick="return confirmx('确认要删除该消息模板吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
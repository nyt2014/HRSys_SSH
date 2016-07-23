<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Employee List</title>
</head>

<body>
	<!-- 将自定义的头文件引入 -->
	<jsp:include page="/WEB-INF/page/head.jsp"/>
	<s:form  action="employee_searchEmpls.action" method="post" theme="simple" >
		<table border="1" align="center" width="80%" cellpadding="5"
			cellspacing="0" >
			<tr>
				<td colspan="2">
				<s:textfield name="empName" id="empName" value=""/>
				<s:submit value="Search EmployeeName"/> 
				</td>
			</tr>
		</table>
	</s:form>
	<table border="1" align="center" width="80%" cellpadding="5"
		cellspacing="0"  >
		<tr>
			<th>Order</th>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Employee Salary</th>
			<th>Location Department</th>
			<th>Operate</th>
		</tr>

		<s:if test="#request.empls!=null">
			<s:iterator var="empl" value="#request.empls" status="st">
				<tr>
					<td><s:property value="#st.count" /></td>
					<td><s:property value="#empl.id" /></td>
					<td><s:property value="#empl.empName" /></td>
					<td><s:property value="#empl.salary" /></td>
					<td><s:property value="#empl.dept.name" /></td>
					
					<td>
						<s:a href="employee_updateEmplView.action?id=%{#empl.id}">Update</s:a>
						<s:a href="employee_deleteEmpl.action?id=%{#empl.id}">Delete</s:a>
					</td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="5">对不起，没有你要找的数据！请先添加！</td>
			</tr>
		</s:else>
	</table>
</body>
</html>

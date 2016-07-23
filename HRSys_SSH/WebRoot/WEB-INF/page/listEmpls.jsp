<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Employee List</title>
</head>

<body>
	<diV align="center" style="width:80%">
		<s:a href="employee_addEmplView.action">Add a Employee</s:a>
		<s:a href="employee_#####">Add a Department(NULL)</s:a>
	</diV>

	<table border="1" align="center" width="80%" cellpadding="5"
		cellspacing="0">
		<tr>
			<th>Order</th>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Employee Salary</th>
<!-- 			<th>Location Dapartment</th> -->
			<th>Operate</th>
		</tr>

		<s:if test="#request.empls!=null">
			<s:iterator var="empl" value="#request.empls" status="st">
				<tr>
					<td><s:property value="#st.count" /></td>
					<td><s:property value="#empl.id" /></td>
					<td><s:property value="#empl.empName" /></td>
					<td><s:property value="#empl.salary" /></td>
<!-- 					<s:if test="#empl.dept!=null"> -->
<!-- 						<s:iterator var="dept" value="#reuqest.depts"> -->
								<td><s:property value="#empl.id" /></td>
<!-- 						</s:iterator> -->
<!-- 					</s:if> -->
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

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Add Employee</title>
</head>

<body>
	<jsp:include page="/WEB-INF/page/head.jsp"/>
	
	<s:form action="/employee_saveEmpl.action" method="post" theme="simple">
		<table border="1" align="center" width="80%" cellpadding="5"
		cellspacing="0">
			<tr>
				<td>Employee Name</td>
				<td>
					<s:textfield name="empName" id="empName"  value=""/>
				</td>
			</tr>
			
			<tr>
				<td>Employee Salary</td>
				<td>
					<s:textfield name="salary" id="salary" value=""/>
				</td>
			</tr>
			
			<tr>
				<td>Select Department</td>
				<td>
					<s:select 
						name="deptId"
						headerKey="-1"
						headerValue="请选择"
						list="#request.depts"
						listKey="id"
						listValue="name"
						value="-1"
							/>
				</td>
			</tr>
			<tr>
				<td colspan="2"> 
					<s:submit value="Add Employee"/>
				</td>
			</tr>
			
		</table>
	</s:form>
</body>
</html>

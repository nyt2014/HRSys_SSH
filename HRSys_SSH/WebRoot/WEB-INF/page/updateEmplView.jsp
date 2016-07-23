<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Add Employee</title>
</head>

<body>
	<s:form action="/employee_updateEmpl.action" method="post" theme="simple">
		<table border="1" align="center" width="80%" cellpadding="5"
		cellspacing="0">
		<!-- 设置隐藏域，保存员工的id(直接获取了已压入栈顶的部门对象的id) -->
		<s:hidden name="id" id="id" value="%{id}"/>
			<tr>
				<td>Employee Name</td>
				<td>
					<!-- 这里的id是个什么鬼 ，这里直接获取的事栈顶对象的属性值-->
					<s:textfield name="empName" id="empName"/>
				</td>
			</tr>
			
			<tr>
				<td>Employee Salary</td>
				<td>
					<s:textfield name="salary" id="salary"/>
				</td>
			</tr>
			
			<tr>
				<td>Select Department</td>
				<td>
				<!-- 
  	 			 		value  默认选择的项的设置 
  	 			 			   即设置要显示的对象的主键,这里取出栈顶对象中部门对象的引用获取部门id
  	 			 			  (根元素取值)
  	 			  -->
					<s:select 
						name="deptId"
						headerKey="-1"
						headerValue="请选择"
						list="#request.depts"
						listKey="id"
						listValue="name"
						value="dept.id"
							/>
				</td>
			</tr>
			<tr>
				<td colspan="2"> 
					<s:submit value="Update Employee"/>
				</td>
			</tr>
			
		</table>
	</s:form>
</body>
</html>

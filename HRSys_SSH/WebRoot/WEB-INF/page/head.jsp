<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<div align="center" style="width: 80%">

	<!-- 若是用户已登录 -->
	<s:if test="#session.admin!=null">
	WelCome back! <s:property value="#session.admin.adminName" /> &nbsp;
	<s:a href="admin_logout.action">Logout</s:a>
		<s:a href="employee_addEmplView.action">AddEmployee</s:a>
		<s:a href="department_addDeptView.action">AddDepartment</s:a>
	</s:if>
	<!-- 用户没有登陆 -->
	<s:else>
		<s:a href="admin_login.action">Login</s:a>
	</s:else>
	<s:a href="register.action">Register</s:a>
</div>

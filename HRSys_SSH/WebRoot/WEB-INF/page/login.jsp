<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Administrator Please Login</title>

</head>

<body>
	<div align="center" style="width: 90%">Welcome!Please Login.</div>
	<s:form action="admin_login.action" method="post" theme="simple">
		<table border="1" align="center" cellpadding="5" cellspacing="0">
			<tr>
				<td>Administrator Account</td>
				<td><s:textfield name="adminName" id="adminName" value="" />
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><s:password name="pwd" id="pwd" value="" />
				</td>
			</tr>
			<tr>
				<td><s:submit value="Login" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>

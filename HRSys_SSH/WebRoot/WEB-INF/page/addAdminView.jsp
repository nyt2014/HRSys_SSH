<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Register Administrator</title>
  </head>
  
  <body>
  	<s:form action="admin_adminRegister.action" method="post" theme="simple">
  		<table border="1" align="center" width="80%" cellpadding="5"
		cellspacing="0">
  			<tr>
  				<td>UserName</td>
  				<td><s:textfield name="adminName" id="adminName" value=""/> </td>
  			</tr>
  			<tr>
  				<td>Password</td>
  				<td><s:password name="pwd" id="pwd" value=""/> </td>
  			</tr>
  			<tr>
  				<td colspan="2"><s:submit value="Register"/> </td>
  			</tr>
  		</table>		
  	</s:form>
  </body>
</html>

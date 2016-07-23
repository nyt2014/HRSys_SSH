<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Add Department</title>
  </head>
  
  <body>
  	<s:form action="department_addDept.action" method="post" theme="simple">
  		<table border="1" align="center" width="80%" cellpadding="5"
		cellspacing="0">
  			<tr>
  				<td>DepartmentName</td>
  				<td><s:textfield name="name" id="name" value=""/> </td>
  			</tr>
  			<tr>
  				<td colspan="2"><s:submit value="Confirm"/> </td>
  			</tr>
  		</table>		
  	</s:form>
  </body>
</html>

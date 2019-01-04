<%@page import="java.util.List"%>
<%@page import="com.bean.*"%>
<%@page import="com.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>

<% 

	Emp e = (Emp)request.getAttribute("Emp");
	Dept dp = e.getDept();
	
%>
<form name="frm" method="post" action="ActionController">
	<table cellspacing="5" cellpadding="5">
		<tr>
			<td><input type="hidden" name="eid" value="<%=e.getEmpId()  %>"></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="ename" value="<%= e.getEmpName() %>"></td>
		</tr>
		<tr>
			<td>Select Department</td>
			<td><select name="deptno">
		<%
		List<Dept> list = Emp_Dept_Dao.getAllDept();
			for(Dept d:list)
			{
		%>
				<option value="<%=d.getDeptno() %>" <% if(d.getDeptno() == dp.getDeptno()){ %> selected <% } %>><%=d.getDeptName() %></option>
		<%	
			}
		%>
			</select></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Update">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
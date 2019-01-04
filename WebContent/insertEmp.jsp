<%@page import="com.dao.*"%>
<%@page import="com.bean.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<Dept> list=Emp_Dept_Dao.getAllDept();
%>
<form name="frm" method="post" action="ActionController">
	<table>
		<tr>
			<td>Select Department</td>
			<td><select name="deptno">
				<option>---Select Department---</option>
		<%
			for(Dept d:list)
			{
		%>
				<option value="<%=d.getDeptno() %>"><%=d.getDeptName() %></option>
		<%	
			}
		%>
			</select></td>
		</tr>
		<tr>
			<td>Emp Name</td>
			<td><input type="text" name="ename"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Insert Emp">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
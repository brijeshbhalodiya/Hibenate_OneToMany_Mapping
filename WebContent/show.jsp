<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.bean.*"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

List<Emp> list= Emp_Dept_Dao.getAll();

%>
<table border="1" width="100%">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>DEPARTMENT NUMBER</th>
		<th>DEPARTMENT NAME</th>
		<th>EDIT</th>
		<th>DELETE</th>
	</tr>
	<%
		for(Emp e:list)
		{
			Dept d = e.getDept();
	%>
	<tr>
		<td><%=e.getEmpId() %></td>
		<td><%=e.getEmpName() %></td>
		<td><%=d.getDeptno() %></td>
		<td><%=d.getDeptName() %></td>
		<td>
			<form name="edit" method="post" action="ActionController">
				<input type="hidden" name="eid" value="<%=e.getEmpId()%>">
				<input type="submit" name="action" value="Edit">
			</form>
		</td>
		<td>
			<form name="delete" method="post" action="ActionController">
				<input type="hidden" name="eid" value="<%=e.getEmpId()%>">
				<input type="submit" name="action" value="Delete">
			</form>
		</td>
	</tr>
	<%
		}
	%>
</table>

<h3><a href="InsertDept.jsp">Insert Department</a></h3><br>
<h3><a href="insertEmp.jsp">Insert Employee</a></h3><br>
</body>
</html>
package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Dept;
import com.bean.Emp;
import com.dao.Emp_Dept_Dao;

@WebServlet("/ActionController")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("Insert Dept")) {
			Dept d = new Dept();
			d.setDeptName(request.getParameter("dname"));
			Emp_Dept_Dao.addDept(d);
			response.sendRedirect("index.jsp");
		}else if(action.equalsIgnoreCase("Insert Emp")) {
			
			Dept d = new Dept();
			d.setDeptno(Integer.parseInt(request.getParameter("deptno")));
			
			Emp e = new Emp();
			e.setEmpName(request.getParameter("ename"));
			e.setDept(d);
			
			Emp_Dept_Dao.addEmp(e);
			response.sendRedirect("show.jsp");
		}else if(action.equalsIgnoreCase("edit")) {
			int eid = Integer.parseInt(request.getParameter("eid"));
			Emp e = Emp_Dept_Dao.findEmpById(eid);
			
			request.setAttribute("Emp", e);
			request.getRequestDispatcher("update.jsp").forward(request, response);
			
		}else if(action.equalsIgnoreCase("update")) {
			int eid = Integer.parseInt(request.getParameter("eid"));
			Emp e = Emp_Dept_Dao.findEmpById(eid);
			e.setEmpName(request.getParameter("ename"));
			Dept d= e.getDept();
			d.setDeptno(Integer.parseInt(request.getParameter("deptno")));
			e.setDept(d);
			
			Emp_Dept_Dao.doUpdate(e);
			response.sendRedirect("show.jsp");
		}else if(action.equalsIgnoreCase("delete")) {
			int eid = Integer.parseInt(request.getParameter("eid"));
			Emp_Dept_Dao.deleteEmp(eid);
			response.sendRedirect("show.jsp");
		}
	}

}

package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Dept;
import com.bean.Emp;
import com.util.Emp_Dept_Util;

public class Emp_Dept_Dao {

	public static void addDept(Dept d) {
		
		Session session = Emp_Dept_Util.getConnection();
		Transaction tr = session.beginTransaction();
		session.save(d);
		tr.commit();
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Dept> getAllDept(){
		Session session = Emp_Dept_Util.getConnection();
		List<Dept> d = session.createQuery("from Dept").list();
		session.close();
		return d;
	}

	public static void addEmp(Emp e) {
		
		Session session = Emp_Dept_Util.getConnection();
		Transaction tr = session.beginTransaction();
		session.save(e);
		tr.commit();
		session.close();
		
	}
	
	
	public static List<Emp> getAll() {
		Session session = Emp_Dept_Util.getConnection();
		List<Emp> e = session.createQuery("from Emp").list();
		session.close();
		return e;
	}

	public static Emp findEmpById(int eid) {
		Emp e = new Emp();
		Session session = Emp_Dept_Util.getConnection();
		e = (Emp)session.get(Emp.class, eid);
		session.close();
		return e;
	}

	public static void doUpdate(Emp e) {
		
		Session session = Emp_Dept_Util.getConnection();
		Transaction tr = session.beginTransaction();
		session.update(e);
		tr.commit();
		session.close();
		
	}

	public static void deleteEmp(int eid) {
		Emp e = findEmpById(eid);
		Session session = Emp_Dept_Util.getConnection();
		Transaction tr = session.beginTransaction();
		session.delete(e);
		tr.commit();
		session.close();
	}

}

package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Dept;
import com.bean.Emp;

public class Emp_Dept_Util {
	
	public static Session getConnection() {
		Session session=null;
		SessionFactory sf = null;
		sf = new Configuration()
				.addAnnotatedClass(Emp.class)
				.addAnnotatedClass(Dept.class)
				.configure()
				.buildSessionFactory();
		
		session = sf.openSession();
		return session;
	}

}

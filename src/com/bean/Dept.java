package com.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="dept")
public class Dept {

	private int deptno;
	private String deptName;
	private Set<Emp> employees;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="dept")
	public Set<Emp> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Emp> employees) {
		this.employees = employees;
	}
	
	
	
	@Id
	@GenericGenerator(name="inc", strategy="increment")
	@GeneratedValue(generator="inc")
	@Column(name="deptno")
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
	
	@Column(name="deptname")
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
}

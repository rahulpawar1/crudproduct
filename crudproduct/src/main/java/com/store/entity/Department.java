package com.store.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT_TBL")
public class Department {
	
	@Id
	@GeneratedValue
	private int id;
	private String deptCode;
	private String departName;
	private boolean status;
	
	public Department() {
		
	}

	public Department(int id, String deptCode, String departName, boolean status) {
		super();
		this.id = id;
		this.deptCode = deptCode;
		this.departName = departName;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptCode=" + deptCode + ", departName=" + departName + ", status=" + status
				+ "]";
	}	
	
}

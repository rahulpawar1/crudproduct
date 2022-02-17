package com.store.service;

import java.util.List;

import com.store.entity.Department;

public interface DepartmentService {
	
	public Department addDept(Department department);
	
	public List<Department> getDeptList();
	
}

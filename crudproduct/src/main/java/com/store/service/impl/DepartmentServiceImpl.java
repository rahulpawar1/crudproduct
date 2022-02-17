package com.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.entity.Department;
import com.store.repository.DepartmentRepository;
import com.store.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository departmentRepo;
	
	@Override
	public Department addDept(Department department) {

		return departmentRepo.save(department);
	}

	@Override
	public List<Department> getDeptList() {
		return departmentRepo.findAll();
	}
	
	
}

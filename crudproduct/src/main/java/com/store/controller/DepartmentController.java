package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.entity.Department;
import com.store.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/add")
	public ResponseEntity<Department> addDept(@RequestBody Department department){
		
		Department savedDept = departmentService.addDept(department);
		return new ResponseEntity<>(savedDept, HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Department>> listDept(){
		List<Department> deptList = departmentService.getDeptList();
		return new ResponseEntity<>(deptList, HttpStatus.OK);
	}
}

package com.example.department.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository repo;

	@PostMapping("/")
	public Department saveDept(@RequestBody Department department)
	{
		repo.save(department);
		return department;		
	}
	
	@GetMapping("/{id}")
	public Department findDept(@PathVariable("id")int deptId)
	{
		Department department = repo.findById(deptId).get();
		return department;
	}
}

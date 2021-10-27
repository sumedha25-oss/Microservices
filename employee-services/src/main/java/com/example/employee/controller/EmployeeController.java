package com.example.employee.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.employee.VO.Department;
import com.example.employee.VO.ResponseTemplate;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/")
	public Employee saveEmp(@RequestBody Employee employee)
	{
		repo.save(employee);
		return employee;
	}
	/*
	@GetMapping("/{id}")
	public Employee findEmp(@PathVariable("id")int employeeid)
	{
		Employee employee = repo.findById(employeeid).get();
		return employee;
	}*/
	
	
	@GetMapping("/{id}")
	public ResponseTemplate getUserWithDepartment(@PathVariable("id")int employeeId) 
	{
        
        ResponseTemplate vo = new ResponseTemplate();
        Employee employee = repo.findById(employeeId).get();

        /*Department department =restTemplate.getForObject("http://localhost:8081/departments/" + employee.getDeptId()
                        ,Department.class);*/
        
        Department department =restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + employee.getDeptId()
        ,Department.class);

        //System.out.println(employee);
        vo.setEmployee(employee);
        vo.setDepartment(department);
         
        return vo; 
        //return employee;
    }
}

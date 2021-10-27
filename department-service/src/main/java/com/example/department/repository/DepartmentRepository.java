package com.example.department.repository;
import org.springframework.data.repository.CrudRepository;
import com.example.department.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department,Integer>{

}

package com.pavan.microservices.department.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.microservices.department.entity.Department;
import com.pavan.microservices.department.repository.DepartmentRepository;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		department.setCreatedAt(LocalDateTime.now());
		return departmentRepository.save(department);
	}
	
	public Optional<Department> getDepartmentById(Long id){
		return departmentRepository.findById(id);
	}
	
	public List<Department> getAllDepartments(){
		return departmentRepository.findAll();
	}
}

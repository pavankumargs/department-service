package com.pavan.microservices.department.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.microservices.department.entity.Department;
import com.pavan.microservices.department.exception.DepartmentNotFoundException;
import com.pavan.microservices.department.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		department.setCreatedAt(LocalDateTime.now());
		return departmentRepository.save(department);
	}

	public Department getDepartmentById(Long id) {
		return departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException("Department Not Found"));
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
}

package com.pavan.microservices.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.microservices.department.entity.Department;
import com.pavan.microservices.department.exception.DepartmentNotFoundException;
import com.pavan.microservices.department.exception.EmployeeNotFoundException;
import com.pavan.microservices.department.repository.DepartmentRepository;
import com.pavan.microservices.employee.entity.Employee;
import com.pavan.microservices.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	public Employee saveEmployee(Employee employee, Long departmentId) {
		Department department = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new DepartmentNotFoundException("Department Id Not Found"));
		employee.setDepartment(department);
		return employeeRepository.save(employee);
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee ID Not Found"));
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(Long id, Employee employee) {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee ID Not Found."));
		if (employee.getEmployeeName() != null) {
			existingEmployee.setEmployeeName(employee.getEmployeeName());
		}
		if (employee.getEmail() != null) {
			existingEmployee.setEmail(employee.getEmail());
		}
		if (employee.getSalary() != null) {
			existingEmployee.setSalary(employee.getSalary());
		}
		if (employee.getEmployeeCode() != null) {
			existingEmployee.setEmployeeCode(employee.getEmployeeCode());
		}
		if (employee.getJoiningDate() != null) {
			existingEmployee.setJoiningDate(employee.getJoiningDate());
		}
		if (employee.getPhoneNumber() != null) {
			existingEmployee.setPhoneNumber(employee.getPhoneNumber());
		}
		if (employee.getDesignation() != null) {
			existingEmployee.setDesignation(employee.getDesignation());
		}
		if (employee.getStatus() != null) {
			existingEmployee.setStatus(employee.getStatus());
		}
		return employeeRepository.save(existingEmployee);
	}
	
	public void deleteEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
		employeeRepository.delete(employee);
	}
}

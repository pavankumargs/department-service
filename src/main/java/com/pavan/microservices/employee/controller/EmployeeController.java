package com.pavan.microservices.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.microservices.employee.dto.EmployeeResponseDTO;
import com.pavan.microservices.employee.entity.Employee;
import com.pavan.microservices.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/{departmentId}")
	public Employee saveEmployee(@Valid @RequestBody Employee employee, @PathVariable Long departmentId) {
		return employeeService.saveEmployee(employee, departmentId);
	}

	@GetMapping("/{id}")
	public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping
	public List<EmployeeResponseDTO> getAllEmployees() {
		List<EmployeeResponseDTO> allEmployees = employeeService.getAllEmployees();
		return allEmployees;
	}

	@PutMapping("/{id}")
	public Employee updateEmployeeById(@Valid @RequestBody Employee employee, @PathVariable Long id) {
		return employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "Employee Deleted Successfully";
	}
}

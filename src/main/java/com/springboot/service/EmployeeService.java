package com.springboot.service;

import java.util.List;

import com.springboot.model.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee deleteEmployee(long id);
	public Employee findById (long id);
	public Employee updateById(Employee employee, long id);
}

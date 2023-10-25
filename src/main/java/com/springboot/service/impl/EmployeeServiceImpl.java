package com.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;
import com.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> el = employeeRepository.findAll();
		if (el.size() == 0) throw new ResourceNotFoundException("Employees dosen't exist");
	return el;
	}

	@Override
	public Employee deleteEmployee(long id) {
		Employee e = employeeRepository.findById(id).get();
		employeeRepository.deleteById(id);
		return e;
	}

	@Override
	public Employee findById(long id) {
		Employee e = employeeRepository.findById(id).get();
		return e;
	}

	@Override
	public Employee updateById(Employee employee, long id) {
		Employee e = employeeRepository.findById(id).get();
		e.setFirstName(employee.getFirstName());
		e.setEmail(employee.getEmail());
		
		Employee e1 = employeeRepository.save(e);
		return e1;
	}
}

	
	

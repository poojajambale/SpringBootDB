package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//building create employee REST API
	@PostMapping("/add")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		employee = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> removeEmployee(@PathVariable int id) {

		ResponseEntity<Employee> response = null;
		Employee employee = employeeService.findById(id);
		if (employee == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			employeeService.deleteEmployee(id);
			response = new ResponseEntity<>(employee, HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> findById(@PathVariable long id){
		Employee e = employeeService.findById(id);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<Employee> updateById(@RequestBody Employee employee, @PathVariable long id){
		Employee e = employeeService.updateById(employee, id);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
}


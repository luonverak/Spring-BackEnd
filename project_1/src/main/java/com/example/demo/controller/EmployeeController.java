package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResurceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return  employeeRepository.findAll();
	}
	@PostMapping("")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	//find by id
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable long id){
		Employee employee=employeeRepository.findById(id)
				.orElseThrow( () -> new ResurceNotFoundException("Employee not exist with id :"+id));
		return ResponseEntity.ok(employee);
	}
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployeeByID(@PathVariable long id,@RequestBody Employee employeeDetail){
		Employee updaetEmployee=employeeRepository.findById(id)
				.orElseThrow( () -> new ResurceNotFoundException("Employee not exist with id :"+id));
		
		updaetEmployee.setFirstName(employeeDetail.getFirstName());
		updaetEmployee.setLastName(employeeDetail.getLastName());
		updaetEmployee.setEmail(employeeDetail.getEmail());
		
		employeeRepository.save(updaetEmployee);
		return ResponseEntity.ok(updaetEmployee);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeByID(@PathVariable long id){
		Employee employee=employeeRepository.findById(id)
				.orElseThrow( () -> new ResurceNotFoundException("Employee not exist with id :"+id));
		employeeRepository.delete(employee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
}

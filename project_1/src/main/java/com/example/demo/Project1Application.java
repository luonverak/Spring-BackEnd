package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootApplication
public class Project1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
//		Employee employee=new Employee();
//		employee.setFirstName("Verak");
//		employee.setLastName("Luon");
//		employee.setEmail("luonverak@gmail.com");
//		
//		employeeRepository.save(employee); 
	}

}

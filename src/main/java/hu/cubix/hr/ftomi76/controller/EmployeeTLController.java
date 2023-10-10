package hu.cubix.hr.ftomi76.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hu.cubix.hr.ftomi76.dto.EmployeeDto;

@Controller
//controller method for handling Thymeleaf server side rendering
public class EmployeeTLController {

	private List<EmployeeDto> employees = new ArrayList<>();

	// employee attributes ->
	// long 			id;
	// String 			job;
	// Integer 			salary;
	// LocalDateTime 	workstarted;
	
	// initialize block for now instead of using constructor
	{
		employees.add(new EmployeeDto(1L, "Big Boss", 999999, LocalDateTime.of(2001, 6, 6, 6, 0, 0))); // 2001-06-06T06:00:00);
	}

	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("employees", employees);
		model.put("newEmployee", new EmployeeDto());	//create a newEmployee that will be populated by thymeleaf from index.html
														//When the user Creates a new employee from the main page by pressing Create
														//button, a post request will be sent that is handled by the method below
														//createEmployee()
		System.out.println(employees.size());
		return "index";									//when http://localhost:8080/ is called from the browser this method will
														//handle the request, and the server will render the response from index.html
	}
	
	@PostMapping("/employee")
	public String createEmployee(EmployeeDto employeeDto) {
		employees.add(employeeDto);
		return "redirect:/";	//server side rendering pattern for dealing with duplicate
								//post requests when pressing refresh in browser (F5)
								//makes the browser get a new page after post, so the last
								//action would be a get req. - therefore when refreshing the
								//page no duplicate post will occur
	}	

}

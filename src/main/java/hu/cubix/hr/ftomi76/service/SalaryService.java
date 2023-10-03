package hu.cubix.hr.ftomi76.service;

import org.springframework.stereotype.Service;

import hu.cubix.hr.ftomi76.model.Employee;

@Service
public class SalaryService {

	// dependency injection
	private EmployeeService employeeService;

	// dep. inj. by constructor
	public SalaryService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public void setEmployeeSalary (Employee employee) {
		employee.setSalary(Math.round(employee.getSalary() * (employeeService.getPayRaisePercent(employee)/100.0f + 1)));
	}
}

package hu.cubix.hr.ftomi76.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.cubix.hr.ftomi76.service.EmployeeService;
import hu.cubix.hr.ftomi76.service.SmartEmployeeService;

@Configuration
@Profile("smart") //this will only be used if the "smart" profile is active
public class SmartConfiguration {
	@Bean
	public EmployeeService employeeService() {
		return new SmartEmployeeService();
	}
}
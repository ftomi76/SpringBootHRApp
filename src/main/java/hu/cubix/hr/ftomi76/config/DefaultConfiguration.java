package hu.cubix.hr.ftomi76.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.cubix.hr.ftomi76.model.Employee;
import hu.cubix.hr.ftomi76.service.DefaultEmployeeService;
import hu.cubix.hr.ftomi76.service.EmployeeService;

@Configuration
@Profile("!smart")
public class DefaultConfiguration {
	@Bean
	public EmployeeService employeeService() {
		return new DefaultEmployeeService();
//		return new EmployeeService() {
//			
//			@Override
//			public int getPayRaisePercent(Employee employee) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		};
	}
}
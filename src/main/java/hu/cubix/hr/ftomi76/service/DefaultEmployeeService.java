package hu.cubix.hr.ftomi76.service;

import org.springframework.stereotype.Service;

import hu.cubix.hr.ftomi76.model.Employee;

@Service
public class DefaultEmployeeService implements EmployeeService {

	@Override
	public int getPayRaisePercent(Employee employee) {
		return 5;
	}

}

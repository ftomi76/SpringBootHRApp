package hu.cubix.hr.ftomi76.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.hr.ftomi76.config.HRConfigurationProperties;
import hu.cubix.hr.ftomi76.model.Employee;

//@Service
public class SmartEmployeeService implements EmployeeService {

	@Autowired
	private HRConfigurationProperties config;

	@Override
	public int getPayRaisePercent(Employee employee) {

		LocalDateTime now = LocalDateTime.now();

		long worktime = employee.getWorkstarted().until(now, ChronoUnit.YEARS);

		// get the lowest possible pay-raise based on lowest worktime at the company
		if (worktime < config.getSmartPayraise().getWorktime().getLimit1()) {
			return config.getSmartPayraise().getWorktime().getRaisepercent1();
		}
		// pay-raise based on worktime between 1st and 2nd limits
		else if (config.getSmartPayraise().getWorktime().getLimit1() <= worktime
				&& worktime < config.getSmartPayraise().getWorktime().getLimit2()) {
			return config.getSmartPayraise().getWorktime().getRaisepercent2();
		}
		// pay-raise based on worktime between 2nd and 3rd limits
		else if (config.getSmartPayraise().getWorktime().getLimit2() <= worktime
				&& worktime < config.getSmartPayraise().getWorktime().getLimit3()) {
			return config.getSmartPayraise().getWorktime().getRaisepercent3();
		}
		// employee deserves highest possible raise based on highest worktime limit
		else if (config.getSmartPayraise().getWorktime().getLimit3() < worktime) {
			return config.getSmartPayraise().getWorktime().getRaisepercent4();
		} else
			return 0; // not sure if this is ok, but for now it will remain here as it is forever :P

	}

}

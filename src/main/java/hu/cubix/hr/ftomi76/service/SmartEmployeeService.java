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
		int noLimits = config.getSmartPayraise().getWorktime().getLimit().length;
		long worktime = employee.getWorkstarted().until(now, ChronoUnit.YEARS);

		// application.properties arrays - algorithm assumes values to be increasing
		// order
		// hr.smartpayraise.worktime.limit=2.5, 5, 10
		// hr.smartpayraise.worktime.raisepercent1=0, 2, 5, 10

		// get the lowest possible pay-raise based on lowest worktime at the company
		if (worktime < config.getSmartPayraise().getWorktime().getLimit()[0]) {
			return config.getSmartPayraise().getWorktime().getRaisepercent()[0];
		}
		// employee deserves highest possible raise based on highest worktime limit
		else if (config.getSmartPayraise().getWorktime().getLimit()[noLimits-1] <= worktime) {
			return config.getSmartPayraise().getWorktime().getRaisepercent()[noLimits];
		}

		for (int i = 1; i < noLimits; ++i) {

			// pay-raise based on worktime between n. and n+1. limits
			if (/*config.getSmartPayraise().getWorktime().getLimit()[i - 1] <= worktime
					&&*/ worktime < config.getSmartPayraise().getWorktime().getLimit()[i]) {
				return config.getSmartPayraise().getWorktime().getRaisepercent()[i];
			}
		}
		return 0;
		
		//x<[0]
		//x>=[max-1]
		//i=1 [0]<=x && x<[1]
		//i=2 [1]<=x && x[2]
	}

}

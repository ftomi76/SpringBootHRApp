package hu.cubix.hr.ftomi76;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.cubix.hr.ftomi76.model.Employee;
import hu.cubix.hr.ftomi76.service.SalaryService;

@SpringBootApplication
public class HRApplication implements CommandLineRunner {

	@Autowired
	SalaryService salaryService;

	public static void main(String[] args) {
		SpringApplication.run(HRApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Employee employee1 = new Employee(1, "CEO", 250000, LocalDateTime.parse("2010-01-01T08:00:00"));
		Employee employee2 = new Employee(1, "CIO", 175000, LocalDateTime.parse("2016-12-01T08:00:00"));
		Employee employee3 = new Employee(1, "General Manager", 125000, LocalDateTime.parse("2020-03-31T08:00:00"));
		Employee employee4 = new Employee(1, "Janitor", 25000, LocalDateTime.parse("2023-07-21T08:00:00"));
		
		//increase salary for CEO
		System.out.println(employee1.getJob() + "Salary before raise" + employee1.getSalary());
		salaryService.setEmployeeSalary(employee1);
		System.out.println(employee1.getJob() + "Salary after raise" + employee1.getSalary());
		
		System.out.println(employee2.getJob() + "Salary before Raise" + employee2.getSalary());
		salaryService.setEmployeeSalary(employee2);
		System.out.println(employee2.getJob() + "Salary before Raise" + employee2.getSalary());

		System.out.println(employee3.getJob() + "Salary before Raise" + employee3.getSalary());
		salaryService.setEmployeeSalary(employee3);
		System.out.println(employee3.getJob() + "Salary before Raise" + employee3.getSalary());

		System.out.println(employee4.getJob() + "Salary before Raise" + employee4.getSalary());
		salaryService.setEmployeeSalary(employee4);
		System.out.println(employee4.getJob() + "Salary before Raise" + employee4.getSalary());
	}

}

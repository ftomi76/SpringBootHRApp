package hu.cubix.hr.ftomi76.dto;

import java.time.LocalDateTime;

public class EmployeeDto {
	private long id;
	private String job;
	private Integer salary;
	private LocalDateTime workstarted;

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(long id, String job, Integer salary, LocalDateTime workstarted) {
		super();
		this.id = id;
		this.job = job;
		this.salary = salary;
		this.workstarted = workstarted;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public LocalDateTime getWorkstarted() {
		return workstarted;
	}

	public void setWorkstarted(LocalDateTime workstarted) {
		this.workstarted = workstarted;
	}

}

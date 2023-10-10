package hu.cubix.hr.ftomi76.controller;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.cubix.hr.ftomi76.dto.EmployeeDto;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private Map<Long, EmployeeDto> employees = new HashMap<>();

	// employee attributes ->
	// long 			id;
	// String 			job;
	// Integer 			salary;
	// LocalDateTime 	workstarted;
	
	// initialize block for now instead of using constructor
	{
		employees.put(1L, new EmployeeDto(1L, "carpenter", 20000, LocalDateTime.of(2010, 1, 1, 8, 0, 0))); // 2010-01-01T08:00:00);
	}

	//Create-Retrieve-Update-Delete (CRUD) operations implementation below

	//Crud - Create
	@PostMapping
	public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employee){	//@RequestBody to get employee attributes from request
		if(employees.containsKey(employee.getId()))
				return ResponseEntity.badRequest().build(); //if employee with provided id already exists -> error
		
		employees.put(employee.getId(), employee);
		return ResponseEntity.ok(employee);
	}

	//cRud - Retrieve (all)
	@GetMapping
	public List<EmployeeDto> findAll() {
		return new ArrayList<EmployeeDto>(employees.values());
	}

	//cRud - Retrieve (one item by id)
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> findById(@PathVariable long id) {
		EmployeeDto employeeDto = employees.get(id);
		if (employeeDto == null) {
			return ResponseEntity.notFound().build();	// return Error404 when no such employee is found
		}
		return ResponseEntity.ok(employeeDto);
	}

	//crUd - Update
	//remark: wouldn't it be sufficient to have @Requestbody since it also contains the id ?
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> update(@PathVariable long id, @RequestBody EmployeeDto employee) {
		employee.setId(id);
		if (!employees.containsKey(id)) 				//if there is no employee with the provided id 
			return ResponseEntity.notFound().build();	//-> error, cannot update not existing

		employees.put(employee.getId(), employee); //otherwise update with new attributes provided in the request
		return ResponseEntity.ok(employee);
	}
	
	//cruD - Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {		//we don't return anything this time - item is either deleted (ok) 
		employees.remove(id);						//or already didn't exist (still ok)
	}												//however - what if item exists, but something goes wrong during deletion ?! 

}

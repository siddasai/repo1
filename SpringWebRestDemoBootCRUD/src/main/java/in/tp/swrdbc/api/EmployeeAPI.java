package in.tp.swrdbc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tp.swrdbc.model.Employee;
import in.tp.swrdbc.service.EmployeeService;

@RestController
@RequestMapping("/emps")
public class EmployeeAPI {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAll() {
		return new ResponseEntity<List<Employee>>(empService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> findById(@PathVariable("empId") Long empId) {
		ResponseEntity<Employee> response = null;
		Employee emp = empService.findById(empId);
		if (emp == null)
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			response = new ResponseEntity<>(emp, HttpStatus.OK);
		return response;
	}
	
	@PostMapping
	public ResponseEntity<Employee >createEmployee(@RequestBody Employee emp) {
		ResponseEntity<Employee> response = null;
		
		Employee empTemp = empService.findById(emp.getEmpId());
		if (empTemp == null) { 
			emp = empService.save(emp);
			response = new ResponseEntity<>(emp, HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		return response;
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("empId") Long empId) {
		ResponseEntity<Void> response = null;
		Employee empTemp = empService.findById(empId);
		if (empTemp == null)
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			empService.deleteById(empId);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
		
	}
	
	
}


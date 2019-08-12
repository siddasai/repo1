package in.tp.swrdbc.service;

import java.util.List;

import in.tp.swrdbc.model.Employee;

public interface IEmployeeService {
	
	public List<Employee> findAll();
	public Employee findById(Long empId);
	public Employee save(Employee emp);
	public void deleteById(Long empId);
} 

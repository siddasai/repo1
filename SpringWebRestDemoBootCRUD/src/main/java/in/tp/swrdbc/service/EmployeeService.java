package in.tp.swrdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tp.swrdbc.dao.EmployeeRepository;
import in.tp.swrdbc.model.Employee;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> findAll() {
		return empRepo.findAll();
	}
	
	@Override
	public Employee findById(Long empId) {
		return empRepo.findById(empId).orElse(null);
	}

	@Override
	public Employee save(Employee emp) {
		return empRepo.save(emp);
	}
	
	@Override
	public void deleteById(Long empId) {
		empRepo.deleteById(empId);
	}
}

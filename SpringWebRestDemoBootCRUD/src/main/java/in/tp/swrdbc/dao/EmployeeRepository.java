package in.tp.swrdbc.dao;

import org.springframework.stereotype.Repository;
import in.tp.swrdbc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

package sit.int204.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
}

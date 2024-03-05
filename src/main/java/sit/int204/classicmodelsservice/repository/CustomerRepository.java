package sit.int204.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.Model.Customer;
import sit.int204.classicmodelsservice.Model.Customera;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

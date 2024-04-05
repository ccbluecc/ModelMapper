package sit.int204.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int204.classicmodelsservice.Model.Customer;
import sit.int204.classicmodelsservice.Model.Customera;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select c from Customer c where concat(c.contactFirstName,' ',c.contactLastName) = :name")
    Customer findByName(String name);

}

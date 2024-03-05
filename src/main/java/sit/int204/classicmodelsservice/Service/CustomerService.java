package sit.int204.classicmodelsservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.Exeptuion.ItemNotFoundException;
import sit.int204.classicmodelsservice.Model.Customer;
import sit.int204.classicmodelsservice.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    public List<Customer> getAllCustomer(){
        return repository.findAll();
    }

    public Customer findbyid(Integer customerNumber) {
        return repository.findById(customerNumber).orElseThrow(
                () -> new ItemNotFoundException("Customer Number" + customerNumber + " DOES NOT EXIST !!!") {
                }
        );
    }
    public Page<Customer> getCustomers(int page,int size){
        String x = null;
        x.toLowerCase();
        return repository.findAll(PageRequest.of(page,size));
    }

    public List<Customer> getCustomers(){
        return  repository.findAll();
    }

}

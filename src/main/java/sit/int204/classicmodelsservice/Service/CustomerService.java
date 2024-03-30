package sit.int204.classicmodelsservice.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.Exeptuion.ItemNotFoundException;
import sit.int204.classicmodelsservice.Model.Customer;
import sit.int204.classicmodelsservice.dtos.NewCustomerDTO;
import sit.int204.classicmodelsservice.repository.CustomerRepository;


import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    ModelMapper mapper;
    @Autowired
    ListMapper listMapper;
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
    public NewCustomerDTO createCustomer(NewCustomerDTO newCustomer) {
        if(repository.existsById(newCustomer.getCustomerNumber())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Duplicate customer for id "+
                    newCustomer.getCustomerNumber());
        }
        Customer customer = mapper.map(newCustomer, Customer.class);
        //customer.setSales(employeeService.getEmployee(newCustomer.getSalesEmployee()));
        System.out.println(customer);
        return mapper.map(repository.saveAndFlush(customer), NewCustomerDTO.class);
    }

    public List<NewCustomerDTO> getAllCustomers() {
        Customer c = new Customer();
        c.setCountry("U");
        c.setCity("pa");
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("country",ignoreCase().contains())
                .withMatcher("city",ignoreCase().contains());
//        c.setCustomerNumber(124);
        List<Customer> customers = repository.findAll(Example.of(c, matcher));
//        return listMapper.mapList(repository.findAll(), NewCustomerDTO.class, mapper);
        return listMapper.mapList(customers, NewCustomerDTO.class,mapper);
    }


}

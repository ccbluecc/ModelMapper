package sit.int204.classicmodelsservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.Model.Customera;
import sit.int204.classicmodelsservice.repository.CustomeraRepository;

import java.util.List;

@Service
public class CustomeraService {
    @Autowired
    CustomeraRepository customeraRepository;
    public List<Customera> insertCustomers(List<Customera> customers) {
        return customeraRepository.saveAll(customers);
    }
    public List<Customera> findAllCustomeraa(String name){
        if (name == null || name.isEmpty()){
            return customeraRepository.findAll();
        } else {
            return customeraRepository.findByFirstNameContains(name);
        }

    }
    public List<Customera> findAllCustomeraa(){
        return findAllCustomeraa(null);

    }
}

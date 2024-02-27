package sit.int204.classicmodelsservice.Controller;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.Model.Customera;
import sit.int204.classicmodelsservice.Service.CustomeraService;

import java.util.List;

@RestController
@RequestMapping("/customeras")
public class CustomeraController {
    @Autowired
    CustomeraService service;

    @PostMapping("")
    public List<Customera> createCustomers(@RequestBody List<Customera> customeras){
        return service.insertCustomers(customeras);
    }
    @GetMapping("")
    public List<Customera> findAllCustomers(@RequestParam(required = false) String param){
        return service.findAllCustomeraa(param);
    }
}

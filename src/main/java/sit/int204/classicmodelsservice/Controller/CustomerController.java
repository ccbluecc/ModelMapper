package sit.int204.classicmodelsservice.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.Exeptuion.ErrorResponse;
import sit.int204.classicmodelsservice.Exeptuion.GeneralException;
import sit.int204.classicmodelsservice.Exeptuion.ItemNotFoundException;
import sit.int204.classicmodelsservice.Model.Customer;
import sit.int204.classicmodelsservice.Model.Order;
import sit.int204.classicmodelsservice.Service.CustomerService;
import sit.int204.classicmodelsservice.Service.ListMapper;
import sit.int204.classicmodelsservice.dtos.SimpleCustomerDTO;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    @GetMapping("/{customerNumber}/order")
    public List<Order> getOrderCustomer(@PathVariable Integer customerNumber) {
        return service.findbyid(customerNumber).getOrders();

    }

//    @GetMapping("")
//    public List<Customer> getAllCustomer() {
//        return service.getAllCustomer();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerOrder(@PathVariable Integer id) {
        Customer customer = service.findbyid(id);
        SimpleCustomerDTO simpleCustomerDTO = modelMapper.map(customer, SimpleCustomerDTO.class);
        return ResponseEntity.ok(simpleCustomerDTO);
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllCustomer(@RequestParam(defaultValue = "false") Boolean pageable,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int pageSize) {
        if (pageable) {
            Page<Customer> customerPage = service.getCustomers(page, pageSize);
            return ResponseEntity.ok(listMapper.toPageDTO(customerPage, SimpleCustomerDTO.class, modelMapper));
        } else {
            return ResponseEntity.ok(listMapper.mapList(service.getCustomers(), SimpleCustomerDTO.class, modelMapper));
        }
    }

//        @ExceptionHandler(ItemNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ItemNotFoundException handleItemNotFound(ItemNotFoundException exception){
//        return exception;
//    }


//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public Exception handleOther(Exception exception) {
//        GeneralException generalException = new GeneralException(exception.getMessage());
//        generalException.setTitle();
//        return generalException;
//    }

}


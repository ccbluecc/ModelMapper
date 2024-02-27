package sit.int204.classicmodelsservice.Controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sit.int204.classicmodelsservice.Model.Customera;
import sit.int204.classicmodelsservice.Model.Product;
import sit.int204.classicmodelsservice.Model.ProductPage;
import sit.int204.classicmodelsservice.Service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping("")
    public List<Product> createCustomers(@RequestBody List<Product> products){
        return service.insertProduct(products);
    }
    @GetMapping("")
    public ResponseEntity<Object> findAllProducts(
            @RequestParam(defaultValue =
                    "") String productName,
            @RequestParam(defaultValue = "0") Double lower,
            @RequestParam(defaultValue = "0") Double upper,
            @RequestParam(defaultValue =
                    "") String[] sortBy,
            @RequestParam(defaultValue = "ASC") String[] sortDirection,
            @RequestParam(defaultValue = "0") int pageNo,
                    @RequestParam(defaultValue = "10") int pageSize
    ){
        if(pageSize == 0 ){
            return ResponseEntity.ok(service.findAllProducts());
        }else {
            Page<Product> page =  service.findAllProducts(lower, upper, productName, sortBy, sortDirection,pageNo,pageSize);
            ProductPage pp = new ProductPage();
            pp.setProductList(page.getContent());
            pp.setPageNumber(page.getNumber());
            pp.setPageSize(page.getSize());
            pp.setTotalElements((int) page.getTotalElements());
            pp.setTotalPages(page.getTotalPages());
            return ResponseEntity.ok(pp);
        }
    }
    @GetMapping("/product-line/{id}")
    public List<Product> findAllProducts(@PathVariable String id){
        return service.findAllProductsByProductLine(id);
    }
}


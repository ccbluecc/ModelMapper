package sit.int204.classicmodelsservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.Model.Product;
import sit.int204.classicmodelsservice.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public List<Product> insertProduct(List<Product> products) {
        return repository.saveAll(products);
    }
    public List<Product> findAllProducts(Double lower, Double upper, String productName){
        if(upper < lower){
            double tmp = upper;
            upper = lower;
            lower = tmp;
        }
        if(upper <= 0 && lower <= 0){
            return repository.findByProductNameContains(productName);
        }else {
            return repository.findByPriceBetweenAndProductNameContains(lower ,upper ,productName);
        }
    }

    public Page<Product> findAllProducts(Double lower, Double upper, String productName, String[] sortBy, String[] direction, int pageNo, int pageSize){
        if(upper < lower){
            double tmp = upper;
            upper = lower;
            lower = tmp;
        }
        if(upper <= 0 && lower <= 0){
            upper = repository.findFirstByOrderByPriceDesc().getPrice();
        }
        List<Sort.Order> sortOrder = new ArrayList<>();
        if(sortBy != null && sortBy.length > 0){
            for (int i = 0; i < sortBy.length; i++) {
                sortOrder.add(new Sort.Order((direction[i].equalsIgnoreCase("asc") ?
                    Sort.Direction.ASC : Sort.Direction.DESC), sortBy[i]));
            }
        }
//        if(sortBy == null || sortBy.isEmpty()){
//            sortBy = "productCode";
//        }
//        Sort.Order sortOrder = new Sordt.Order((direction.equalsIgnoreCase("asc") ?
//                Sort.Direction.ASC : Sort.Direction.DESC), sortBy);
        if (pageSize <= 0){
            pageSize = (int) repository.count();
        }
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by(sortOrder));
        return repository.findByPriceBetweenAndProductNameContains(lower,upper,productName,pageable);
    }
    public List<Product> findAllProductsByProductLine(String productLine) {
        return repository.findAllProductsByProductLine(productLine);
    }

    public List<Product> findAllProducts(){
        return repository.findAll();
    }

}

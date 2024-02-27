package sit.int204.classicmodelsservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int204.classicmodelsservice.Model.Customera;
import sit.int204.classicmodelsservice.Model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByPriceBetweenAndProductNameContains(Double lower,Double upper,String productName);
    List<Product> findByPriceBetween(Double lower,Double upper);
    List<Product> findByProductNameContains(String productName);
    List<Product> findAllProductsByProductLine(String line);

//    @Query("select p from Product p where p.price >= :lowerPrice and p.price <: upperPrice and p.productName like:name")
    List<Product> getProductByPriceBetweenAndProductNameContains(Double lower, Double upper, String productName, Sort sort);
//    List<Product> findByPriceAndProductName(Double lower,Double upper,String productName);
    Product findFirstByOrderByPriceDesc();
    Page<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String partOfName, Pageable pageable);


}

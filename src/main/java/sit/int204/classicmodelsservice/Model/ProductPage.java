package sit.int204.classicmodelsservice.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductPage {
    private List<Product> productList;
    private int pageNumber;
    private int pageSize;
    private int totalElements;
    private int totalPages;
}

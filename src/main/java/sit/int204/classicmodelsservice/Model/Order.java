package sit.int204.classicmodelsservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    private Integer orderNumber;
    private String orderDate;
    private String requiredDate;
    private String shippedDate;
    private String status;
    private String comments;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customerNumber")
    private Customer customer;
}
package sit.int204.classicmodelsservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer {
    @Id
    private Integer customerNumber;
    @Column(name = "customerName", nullable = false, length = 50)
    private String customerName;
    @Column(name = "contactLastName", nullable = false, length = 50)
    private String contactLastName;
    @Column(name = "contactFirstName", nullable = false, length = 50)
    private String contactFirstName;
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;
    @Column(name = "addressLine1", nullable = false, length = 50)
    private String addressLine1;
    @Column(name = "addressLine2", nullable = true, length = 50)
    private String addressLine2;
    @Column(name = "city", nullable = false, length = 50)
    private String city;
    @Column(name = "state", nullable = true, length = 50)
    private String state;
    @Column(name = "postalCode", nullable = true, length = 15)
    private String postalCode;
    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber")
    private Employee sales;

    private Double creditLimit;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    private String password;
    private String role;
}


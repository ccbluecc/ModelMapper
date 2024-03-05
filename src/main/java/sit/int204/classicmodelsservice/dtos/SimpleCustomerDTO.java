package sit.int204.classicmodelsservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import sit.int204.classicmodelsservice.Model.Employee;

@Getter
@Setter
public class SimpleCustomerDTO {
    private String customerName;
    private String phone;
    private String city;
    private String country;
//    private Employee salesPerson;
//    private String salesRepEmployee;
//    private String salesFirstName;
    private String salesOfficeCity;
    @JsonIgnore
    private SimpleEmployeeDTO sales;
    public String getSalesPerson() {
        return sales == null ? "-" : sales.getName() + "-" + sales.getSalesOfficeCity();
    }
}


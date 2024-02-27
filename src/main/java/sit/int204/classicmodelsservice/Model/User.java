package sit.int204.classicmodelsservice.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name = "employeeNumber",nullable = false)
    private Integer userId;
    private String name;
    private String password;


}

package sit.int204.classicmodelsservice.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.springframework.security.core.GrantedAuthority;

import java.beans.ConstructorProperties;
import java.util.Collection;

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


    public User(String userName, String password, Collection<? extends GrantedAuthority> authorities) {
    }
}

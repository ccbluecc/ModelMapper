package sit.int204.classicmodelsservice.Model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "fisrt_name",nullable = false)
    private String firstName;
    private String lastName;
}

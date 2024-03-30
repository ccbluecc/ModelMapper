package sit.int204.classicmodelsservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import sit.int204.classicmodelsservice.Model.Office;

@Data
public class SimpleEmployeeDTO {
    private Integer id;
    @JsonIgnore
    private String firstName;
    @JsonIgnore
    private String lastName;
    public String getName() {
        return firstName + ' '+ lastName;
    }
}

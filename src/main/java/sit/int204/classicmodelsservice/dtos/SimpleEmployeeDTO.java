package sit.int204.classicmodelsservice.dtos;

import lombok.Getter;
import lombok.Setter;
import sit.int204.classicmodelsservice.Model.Office;

@Getter
@Setter
public class SimpleEmployeeDTO {
    private String lastName;
    private String firstName;
    private String salesOfficeCity;
    public String getName() {
        return firstName + " "+ lastName ;
    }
}

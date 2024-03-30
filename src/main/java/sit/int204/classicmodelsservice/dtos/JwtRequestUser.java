package sit.int204.classicmodelsservice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JwtRequestUser {
    @NotBlank
    private String userName;
    @Size(min = 8)
    @NotBlank
    private String password;
}
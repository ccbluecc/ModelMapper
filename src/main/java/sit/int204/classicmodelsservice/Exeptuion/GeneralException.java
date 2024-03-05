package sit.int204.classicmodelsservice.Exeptuion;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
@Setter
public class GeneralException extends ResponseStatusException {
    private String title;
    public GeneralException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR,message);
    }
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}

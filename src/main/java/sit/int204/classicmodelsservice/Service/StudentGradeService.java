package sit.int204.classicmodelsservice.Service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelsservice.Model.Student;
@Service
public class StudentGradeService {
    public Student calculateGrade(Student student){
        if(student.getScore() == null || student.getScore() > 100){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Invalid Score!!!()" );
        }
        student.calculateGrade();
        return student;
    }
}

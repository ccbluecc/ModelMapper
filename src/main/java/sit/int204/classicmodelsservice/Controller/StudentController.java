package sit.int204.classicmodelsservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.Model.Student;
import sit.int204.classicmodelsservice.Service.StudentGradeService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentGradeService service;
    @GetMapping("")
    public Student getStudent(@RequestBody Student student) {
        return service.calculateGrade(student);
    }
}

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
@Table(name="students")
public class Student {
    @Id
    @Column(name = "studentid",nullable = false)
    private Integer id;
    private String name;
    private Integer score;
    private String grade;

    public void calculateGrade(){
        if (score >= 80){
            grade = "A";
        } else if (score >=70) {
            grade = "B";
        } else if (score >= 60) {
            grade = "C";
        } else if (score >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
    }

}

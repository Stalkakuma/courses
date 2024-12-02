package lt.vidunas.courses.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String type;
    private Date startDate;
    private Date endDate;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public void addStudent(Student student) {
        students.add(student);
        student.getCourses().add(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.getCourses().remove(this);
    }
}

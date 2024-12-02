package lt.vidunas.courses.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    public void addCourse(Course course) {
        courses.add(course);
        course.getStudents().add(this);
    }
    public void removeCourse(Course course) {
        courses.remove(course);
        course.getStudents().remove(this);
    }

}

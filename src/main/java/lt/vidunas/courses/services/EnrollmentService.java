package lt.vidunas.courses.services;

import jakarta.transaction.Transactional;
import lt.vidunas.courses.entities.Course;
import lt.vidunas.courses.entities.Student;
import lt.vidunas.courses.exceptions.CourseNotFoundException;
import lt.vidunas.courses.exceptions.StudentNotFoundException;
import lt.vidunas.courses.repositories.CourseRepository;
import lt.vidunas.courses.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    @Transactional
    public void enrollStudentInCourse(Long courseId, Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course not found"));
        student.addCourse(course);
        studentRepository.save(student);
        courseRepository.save(course);
    }

    @Transactional
    public void removeStudentFromCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course not found"));
        student.removeCourse(course);
        studentRepository.save(student);
        courseRepository.save(course);
    }
}

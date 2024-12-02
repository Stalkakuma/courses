package lt.vidunas.courses.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.vidunas.courses.entities.Course;
import lt.vidunas.courses.services.CourseService;
import lt.vidunas.courses.services.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) {
        courseService.saveCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        courseService.deleteCourse(course);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Course successfully deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @Valid @RequestBody Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/{id}/enrollments")
    public ResponseEntity<String> enrollStudent(@PathVariable Long id, @RequestBody Long studentId) {
        enrollmentService.enrollStudentInCourse(id, studentId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student successfully enrolled");
    }


    @DeleteMapping("/{id}/enrollments")
    public ResponseEntity<String> unenrollStudent(@PathVariable Long id, @RequestBody Long studentId) {
        enrollmentService.removeStudentFromCourse(id, studentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student successfully removed from the course");
    }
}

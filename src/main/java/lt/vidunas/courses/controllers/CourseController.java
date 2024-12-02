package lt.vidunas.courses.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.vidunas.courses.entities.Course;
import lt.vidunas.courses.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) {
        courseService.saveCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }
}

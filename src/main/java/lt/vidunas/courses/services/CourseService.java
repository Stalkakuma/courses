package lt.vidunas.courses.services;

import lombok.RequiredArgsConstructor;
import lt.vidunas.courses.entities.Course;
import lt.vidunas.courses.exceptions.CourseNotFoundException;
import lt.vidunas.courses.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course with id "+ id+ " not found"));
    }
}

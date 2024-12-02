package lt.vidunas.courses.repositories;

import lt.vidunas.courses.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

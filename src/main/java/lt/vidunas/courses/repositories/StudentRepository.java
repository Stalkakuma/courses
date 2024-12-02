package lt.vidunas.courses.repositories;

import lt.vidunas.courses.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

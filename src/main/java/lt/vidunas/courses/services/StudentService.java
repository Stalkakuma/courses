package lt.vidunas.courses.services;

import lombok.RequiredArgsConstructor;
import lt.vidunas.courses.entities.Student;
import lt.vidunas.courses.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }
}

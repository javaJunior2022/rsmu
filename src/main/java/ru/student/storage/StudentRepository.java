package ru.student.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.student.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
}

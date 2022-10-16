package ru.students.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.students.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
}

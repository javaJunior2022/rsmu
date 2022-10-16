package ru.students;


import ru.students.model.StudentRequestAddingDto;
import ru.students.model.StudentRequestDto;

import java.util.List;

public interface StudentService {

    StudentRequestDto addStudent(StudentRequestAddingDto studentRequestDto);

    StudentRequestDto updateStudent(Long studentId, StudentRequestDto studentRequestDto);

    List<StudentRequestDto> getStudents();
}


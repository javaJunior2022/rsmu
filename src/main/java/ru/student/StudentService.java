package ru.student;


import ru.student.model.StudentRequestDto;

import java.util.List;

public interface StudentService {

    StudentRequestDto addStudent(StudentRequestDto studentRequestDto);

    StudentRequestDto updateStudent(Long studentId, StudentRequestDto studentRequestDto);

    List<StudentRequestDto> getStudents();
}


package ru.student;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.student.model.Student;
import ru.student.model.StudentRequestDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentMapper {

    public static Student toEntity(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setSurname(studentRequestDto.getSurname());
        student.setName(studentRequestDto.getName());
        student.setPatronymic(studentRequestDto.getPatronymic());
        student.setGroup(studentRequestDto.getGroup());
        student.setIsActive(studentRequestDto.getIsActive());
        return student;
    }

    public static StudentRequestDto toStudentRequestDto(Student student) {

        return new StudentRequestDto(
                student.getId(),
                student.getSurname(),
                student.getName(),
                student.getPatronymic(),
                student.getGroup(),
                student.getIsActive());
    }
}

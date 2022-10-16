package ru.students;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.students.model.Student;
import ru.students.model.StudentRequestAddingDto;
import ru.students.model.StudentRequestDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentMapper {

    public static StudentRequestDto toStudentRequestDto(Student student) {

        return new StudentRequestDto(
                student.getId(),
                student.getSurname(),
                student.getName(),
                student.getPatronymic(),
                student.getGroup(),
                student.getIsActive());
    }

    public static Student updateFromStudentRequestDto(Student student, StudentRequestDto studentRequestDto) {

        if (studentRequestDto.getName() != null) {
            student.setName(studentRequestDto.getName());
        }
        if (studentRequestDto.getSurname() != null) {
            student.setSurname(studentRequestDto.getSurname());
        }
        if (studentRequestDto.getPatronymic() != null) {
            student.setPatronymic(studentRequestDto.getPatronymic());
        }
        if (studentRequestDto.getIsActive() != null) {
            student.setIsActive(studentRequestDto.getIsActive());
        }
        if (studentRequestDto.getGroup() != null) {
            student.setGroup(studentRequestDto.getGroup());
        }

        return student;
    }

    public static Student toEntityStudentRequestAddingDto(StudentRequestAddingDto studentRequestDto) {
        Student student = new Student();
        student.setSurname(studentRequestDto.getSurname());
        student.setName(studentRequestDto.getName());
        student.setPatronymic(studentRequestDto.getPatronymic());
        student.setGroup(studentRequestDto.getGroup());
        student.setIsActive(studentRequestDto.getIsActive());
        return student;
    }
}

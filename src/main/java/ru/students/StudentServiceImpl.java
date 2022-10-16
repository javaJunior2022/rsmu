package ru.students;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Exceptions.StudentNotFoundException;
import ru.students.model.Student;
import ru.students.model.StudentRequestAddingDto;
import ru.students.model.StudentRequestDto;
import ru.students.storage.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentRequestDto addStudent(StudentRequestAddingDto studentRequestDto) {
        log.info("addStudent ", studentRequestDto);
        Student student;
        try {
            student = studentRepository.save(StudentMapper.toEntityStudentRequestAddingDto(studentRequestDto));
        } catch (RuntimeException e) {
            log.info(String.valueOf(e));
            throw new RuntimeException(e);
        }

        return StudentMapper.toStudentRequestDto(student);
    }

    @Override
    public StudentRequestDto updateStudent(Long studentId, StudentRequestDto studentRequestDto) {
        log.info("'updateStudent' " + studentId + " dto=" + studentRequestDto);
        return studentRepository.findById(studentId).map(student -> {
            Student student1 = StudentMapper.updateFromStudentRequestDto(student, studentRequestDto);
            studentRepository.save(student1);
            return StudentMapper.toStudentRequestDto(student1);
        }).orElseThrow(() -> new StudentNotFoundException(Long.toString(studentId)));
    }

    @Override
    public List<StudentRequestDto> getStudents() {
        log.info("'getStudents' ");
        return studentRepository.findAll().stream().map(StudentMapper::toStudentRequestDto).collect(Collectors.toList());
    }
}

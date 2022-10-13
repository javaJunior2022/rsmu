package ru.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.student.model.Student;
import ru.student.model.StudentRequestDto;
import ru.student.storage.StudentRepository;

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
    public StudentRequestDto addStudent(StudentRequestDto studentRequestDto) {
        log.info("addStudent ", studentRequestDto);
        Student student;
        try {
            student = studentRepository.save(StudentMapper.toEntity(studentRequestDto));
        } catch (RuntimeException e) {
            log.info(String.valueOf(e));
            throw new RuntimeException(e);
        }

        return StudentMapper.toStudentRequestDto(student);
    }

    @Override
    public StudentRequestDto updateStudent(Long studentId, StudentRequestDto studentRequestDto) {
        return null;
    }

    @Override
    public List<StudentRequestDto> getStudents() {
        log.info("'getStudents' ");
        return studentRepository.findAll().stream().map(StudentMapper::toStudentRequestDto).collect(Collectors.toList());
    }
}

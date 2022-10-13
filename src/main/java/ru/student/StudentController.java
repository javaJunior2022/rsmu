package ru.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.courses.Create;
import ru.courses.Update;
import ru.student.model.StudentRequestDto;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentRequestDto addStudent(@RequestBody @Validated (Create.class) StudentRequestDto studentRequestDto){

        return studentService.addStudent(studentRequestDto);
    }
    @PatchMapping
    public StudentRequestDto updateStudent(@PathVariable Long studentId,
                                           @RequestBody @Validated(Update.class) StudentRequestDto studentRequestDto){

        return studentService.updateStudent(studentId,studentRequestDto);
    }
    @GetMapping
    public List<StudentRequestDto> getStudents(){
        return studentService.getStudents();
    }
}

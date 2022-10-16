package ru.students;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.courses.Create;
import ru.courses.Update;
import ru.students.model.StudentRequestAddingDto;
import ru.students.model.StudentRequestDto;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
@Api(value = "/students",tags = {"Обучающийся"} )
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentRequestDto addStudent(@RequestBody @Validated (Create.class)
                                            StudentRequestAddingDto studentRequestAddingDto){

        return studentService.addStudent(studentRequestAddingDto);
    }
    @PatchMapping
    @ApiOperation(value = "Update a student")
    public StudentRequestDto updateStudent(@PathVariable Long studentId,
                                           @RequestBody @Validated(Update.class) StudentRequestDto studentRequestDto){

        return studentService.updateStudent(studentId,studentRequestDto);
    }
    @GetMapping
    public List<StudentRequestDto> getStudents(){
        return studentService.getStudents();
    }
}

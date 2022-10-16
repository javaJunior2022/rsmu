package ru.courses;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.courses.model.CourseRequestAddingDto;
import ru.courses.model.CourseRequestDto;

import java.util.List;


@Api(value = "/courses",tags = {"Курс"} )
@RestController
@RequestMapping(path = "/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @ApiOperation(value = "Добавление нового курса", notes = "Возвращает json нового курса. Обратите внимание на id")
    @PostMapping
    public CourseRequestDto addCourse(@RequestBody  @Validated(Create.class)
                                      CourseRequestAddingDto courseRequestAddingDto) {
        return courseService.addCourse(courseRequestAddingDto);
    }
    @ApiOperation(value = "Обновление курса", notes = "Возвращает json обновлённого курса")
    @PatchMapping ("/{courseId}")
    public CourseRequestDto updateCourse (@PathVariable Long courseId,
                                       @RequestBody @Validated (Update.class) CourseRequestDto courseRequest){
        return courseService.updateCourse(courseId,courseRequest);
    }
    @GetMapping
    public List<CourseRequestDto> getCourses(){
        return courseService.getCourses();
    }

}

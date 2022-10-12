package ru.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.courses.model.CourseRequestDto;

import java.util.List;


@RestController
@RequestMapping(path = "/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseRequestDto addCourse(@RequestBody @Validated(Create.class) CourseRequestDto courseRequest) {

        return courseService.addCourse(courseRequest);
    }
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

package ru.courses;

import ru.courses.model.CourseRequestAddingDto;
import ru.courses.model.CourseRequestDto;

import java.util.List;

public interface CourseService {
    CourseRequestDto addCourse(CourseRequestAddingDto courseRequest);

    CourseRequestDto updateCourse(Long courseId, CourseRequestDto courseRequest);

    List<CourseRequestDto> getCourses();
}

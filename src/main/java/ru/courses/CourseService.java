package ru.courses;

import ru.courses.model.CourseRequestDto;

import java.util.List;

public interface CourseService {
    CourseRequestDto addCourse(CourseRequestDto courseRequest);

    CourseRequestDto updateCourse(Long courseId, CourseRequestDto courseRequest);

    List<CourseRequestDto> getCourses();
}

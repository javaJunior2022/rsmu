package ru.courses;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.courses.model.Course;
import ru.courses.model.CourseRequestDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseMapper {

    public static Course toEntity(CourseRequestDto courseRequestDto) {
        Course course = new Course();
        course.setName(courseRequestDto.getName());
        course.setStartDate(courseRequestDto.getStart_date());
        course.setEndDate(courseRequestDto.getStart_date());
        course.setIsActive(courseRequestDto.getIsActive());
        return course;
    }

    public static CourseRequestDto toCourseRequestDto(Course course) {
         return new CourseRequestDto(
                 course.getId(),
                 course.getName(),
                 course.getStartDate(),
                 course.getEndDate(),
                 course.getIsActive()
                );
    }

    public static Course updateFromCourseRequestDto(Course course, CourseRequestDto courseRequestDto) {
        if (courseRequestDto.getName()!=null){
            course.setName(courseRequestDto.getName());
        }
        if (courseRequestDto.getIsActive()!= null){
            course.setIsActive(courseRequestDto.getIsActive());
        }
        if (courseRequestDto.getStart_date()!= null){
            course.setStartDate(courseRequestDto.getStart_date());
        }
        if (courseRequestDto.getEnd_date()!= null){
            course.setEndDate(courseRequestDto.getEnd_date());
        }
        return course;
    }
}

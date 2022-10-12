package ru.courses;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Exceptions.CourseAlreadyExistException;
import ru.Exceptions.CourseNotFoundException;
import ru.courses.model.Course;
import ru.courses.model.CourseRequestDto;
import ru.courses.storage.CourseRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional
@Service
public class CourseServiceImpl implements CourseService {
private CourseRepository courseRepository;

@Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseRequestDto addCourse(CourseRequestDto courseRequestDto) {
        log.info ("addCourse ", courseRequestDto);


        Course course;
        try {
            course=courseRepository.save(CourseMapper.toEntity(courseRequestDto));
        } catch (RuntimeException e){
            log.info(String.valueOf(e));
            throw  new CourseAlreadyExistException(courseRequestDto.getName());
        }

        return CourseMapper.toCourseRequestDto(course);
    }

    @Override
    public List<CourseRequestDto> getCourses() {
        log.info("'getCourses' ");
        return courseRepository.findAll().stream().map(CourseMapper::toCourseRequestDto).collect(Collectors.toList());
    }

    @Override
    public CourseRequestDto updateCourse(Long courseId, CourseRequestDto courseRequestDto) {
        log.info("'updateCourse' "+courseId+" dto="+courseRequestDto);
        if (courseRequestDto.getName() != null && courseRepository.findCourseByName(courseRequestDto.getName()).isPresent()) {
            throw new CourseAlreadyExistException(courseRequestDto.getName());
        }
        return courseRepository.findById(courseId).map(course -> {
            Course course1 = CourseMapper.updateFromCourseRequestDto(course, courseRequestDto);
            courseRepository.save(course1);
            return CourseMapper.toCourseRequestDto(course1);
        }).orElseThrow(() -> new CourseNotFoundException(Long.toString(courseId)));
       
    }
}

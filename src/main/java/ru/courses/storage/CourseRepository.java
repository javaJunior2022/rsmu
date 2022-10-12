package ru.courses.storage;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.courses.model.Course;

import java.util.Optional;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Override
    Optional<Course> findById(Long aLong);
    Optional<Course> findCourseByName(String name);

}

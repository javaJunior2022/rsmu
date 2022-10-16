package ru.sessions;

import ru.Exceptions.CourseNotFoundException;
import ru.courses.model.Course;
import ru.sessions.model.Session;
import ru.sessions.model.SessionRequestAddingDto;
import ru.sessions.model.SessionRequestDto;

public class SessionMapper {
    public static Session SessionRequestAddingDto(Course course, SessionRequestAddingDto sessionRequestAddingDto) {

        Session session = new Session();
        session.setName(sessionRequestAddingDto.getName());
        session.setStartDate(sessionRequestAddingDto.getStart_date());
        session.setMaxRating(sessionRequestAddingDto.getMaxRating());
        session.setCourse(course);
        return session;

    }

    public static SessionRequestDto toSessionRequestDto(Session session) {
        return new SessionRequestDto(
                session.getId(),
                session.getName(),
                session.getStartDate(),
                session.getMaxRating(),
                session.getCourse().getId()
        );
    }

    public static Session updateFromSessionRequestDto(Session session,Course course, SessionRequestDto sessionRequestDto) {
        if (sessionRequestDto.getName()!=null){
            session.setName(sessionRequestDto.getName());
        }

        if (sessionRequestDto.getStartDate()!=null){
            session.setStartDate(sessionRequestDto.getStartDate());
        }
        if (sessionRequestDto.getMaxRating()!=null){
            session.setMaxRating(sessionRequestDto.getMaxRating());
        }
        if (sessionRequestDto.getCourse_id()!=null){
            session.setCourse(course);
        }

        return session;
    }
}

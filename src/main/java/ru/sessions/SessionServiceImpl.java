package ru.sessions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Exceptions.CourseAlreadyExistException;
import ru.Exceptions.CourseNotFoundException;
import ru.Exceptions.SessionNotFoundException;
import ru.courses.CourseMapper;
import ru.courses.model.Course;
import ru.courses.storage.CourseRepository;
import ru.sessions.model.Session;
import ru.sessions.model.SessionRequestAddingDto;
import ru.sessions.model.SessionRequestDto;
import ru.sessions.storage.SessionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@Transactional
public class SessionServiceImpl implements SessionService {
    private SessionRepository sessionRepository;
    private CourseRepository courseRepository;

    @Autowired
    public SessionServiceImpl(SessionRepository sessionRepository, CourseRepository courseRepository) {
        this.sessionRepository = sessionRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public SessionRequestDto addSession(SessionRequestAddingDto sessionRequestAddingDto) {
        log.info("addSession ", sessionRequestAddingDto);

        Course course = courseRepository.findById(sessionRequestAddingDto.getCourseId()).orElseThrow(() -> new
                CourseNotFoundException("This course not found " + sessionRequestAddingDto.getCourseId()));

        Session session;
        try {
            session = sessionRepository.save(SessionMapper.SessionRequestAddingDto(course, sessionRequestAddingDto));
        } catch (RuntimeException e) {
            log.info(String.valueOf(e));
            throw new RuntimeException(e);
        }

        return SessionMapper.toSessionRequestDto(session);
    }

    @Override
    public SessionRequestDto updateSession(Long sessionId, SessionRequestDto sessionRequestDto) {
        log.info("'updateSession' ");
        Course course = courseRepository.findById(sessionRequestDto.getCourse_id()).orElseThrow(() -> new
                CourseNotFoundException("This course not found " + sessionRequestDto.getCourse_id()));
        return sessionRepository.findById(sessionId).map(session -> {
            Session session1 = SessionMapper.updateFromSessionRequestDto(session, course, sessionRequestDto);
            sessionRepository.save(session1);
            return SessionMapper.toSessionRequestDto(session1);
        }).orElseThrow(() -> new SessionNotFoundException(Long.toString(sessionId)));


    }

    @Override
    public List<SessionRequestDto> getSessions() {
        log.info("'getSessions' ");
        return sessionRepository.findAll().stream().map(SessionMapper::toSessionRequestDto).collect(Collectors.toList());
    }
}

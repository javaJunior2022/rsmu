package ru.sessions;

import ru.sessions.model.SessionRequestAddingDto;
import ru.sessions.model.SessionRequestDto;

import java.util.List;

public interface SessionService {
    SessionRequestDto addSession(SessionRequestAddingDto sessionRequestAddingDto);

    SessionRequestDto updateSession(Long sessionId, SessionRequestDto sessionRequestDto);

    List<SessionRequestDto> getSessions();
}

package ru.sessions;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.courses.Create;
import ru.courses.Update;
import ru.sessions.model.Session;
import ru.sessions.model.SessionRequestAddingDto;
import ru.sessions.model.SessionRequestDto;

import java.util.List;


@RestController
@RequestMapping(path = "/sessions")
@Api(value = "/sessions", tags = {"Занятия"})
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    @ApiOperation(value = "Добавление нового занятия")
    public SessionRequestDto addNewSession(@RequestBody @Validated(Create.class)
                                           SessionRequestAddingDto sessionRequestAddingDto) {
        return sessionService.addSession(sessionRequestAddingDto);

    }

    @PatchMapping("/{sessionId}")
    public SessionRequestDto updateSession(@PathVariable Long sessionId,
                                           @RequestBody @Validated(Update.class) SessionRequestDto sessionRequestDto){

        return sessionService.updateSession (sessionId,sessionRequestDto);
    }
    @GetMapping
    List<SessionRequestDto> getSessions(){
      return sessionService.getSessions();
    }
}

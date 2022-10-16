package ru.sessions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;
import ru.LocalDateTimeConverter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionRequestAddingDto {

    @ApiModelProperty(required = true, example = "Патологическая анатомия")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @ApiModelProperty(required = true,notes = "Дата", example = "2022-10-15T01:00:00")
    @Convert (converter = LocalDateTimeConverter.class)
    private LocalDateTime start_date;

    @ApiModelProperty(required = true, example = "5")
    private Long maxRating;

    @ApiModelProperty(required = true,notes = "ID курса",example = "1")
    @NonNull
    @NotBlank
    private Long courseId;

}

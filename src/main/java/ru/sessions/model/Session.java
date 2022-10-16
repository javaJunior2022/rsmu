package ru.sessions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import ru.LocalDateTimeConverter;
import ru.courses.model.Course;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@ToString
@Table(name="sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="name",length = 512)
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column (name="start_date")
    @Convert (converter = LocalDateTimeConverter.class)
    private LocalDateTime startDate;

    @Column (name="max_rating")
    private Long maxRating;

    @OneToOne
    @JoinColumn (name="course_id")
    private Course course;

}

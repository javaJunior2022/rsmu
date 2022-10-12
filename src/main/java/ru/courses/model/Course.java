package ru.courses.model;

import lombok.Data;
import lombok.ToString;
import ru.LocalDateTimeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@ToString
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="name", length = 512, unique = true)
    private String name;

    @Column (name="start_date")
    @Convert (converter = LocalDateTimeConverter.class)
    private LocalDateTime startDate;

    @Column (name="end_date")
    @Convert (converter = LocalDateTimeConverter.class)
    private LocalDateTime endDate;

    @Column (name="is_active")
    private Boolean isActive;

}

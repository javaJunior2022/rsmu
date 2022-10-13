package ru.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private Integer group;
    private Boolean isActive;
}

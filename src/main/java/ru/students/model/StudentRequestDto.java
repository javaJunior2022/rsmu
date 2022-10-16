package ru.students.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    private Long id;

    @NotBlank
    @ApiModelProperty(required = true, example = "Кузнецов")
    private String surname;

    @NotBlank
    @ApiModelProperty(required = true, example = "Михаил")
    private String name;

    @ApiModelProperty(required = true, example = "Александрович")
    private String patronymic;

    @ApiModelProperty(required = true, example = "23")
    private String group;

        @ApiModelProperty(required = true, example = "true")
    private Boolean isActive;
}

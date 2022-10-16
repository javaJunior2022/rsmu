package ru.students.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestAddingDto {

    @NotBlank
    @ApiModelProperty(required = true, example = "Кузнецов")
    private String surname;

    @NotBlank
    @ApiModelProperty(required = true, example = "Михаил")
    private String name;

    @ApiModelProperty(required = false, example = "Александрович")
    private String patronymic;

    @ApiModelProperty(required = false, example = "43")
    private String group;
    
    @ApiModelProperty(required = false, example = "true")
    private Boolean isActive;
}

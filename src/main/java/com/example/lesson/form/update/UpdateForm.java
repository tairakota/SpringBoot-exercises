package com.example.lesson.form.update;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Data
public class UpdateForm {

    @Size(min = 1, max = 50, message = "{validation.size}")
    private String updateName;
    @NotEmpty(message = "{validation.notEmpty}")
    @Pattern(regexp = "\\d*", message = "{validation.pattern}")
    @PositiveOrZero(message = "{validation.positiveOrZero}")
    private String updatePrice;
}

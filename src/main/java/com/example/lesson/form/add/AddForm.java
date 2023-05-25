package com.example.lesson.form.add;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Data
public class AddForm {

    @Size(min = 1, max = 50, message = "{validation.size}")
    private String addName;
    @NotEmpty(message = "{validation.notEmpty}")
    @Pattern(regexp = "\\d*", message = "{validation.pattern}")
    @PositiveOrZero(message = "{validation.positiveOrZero}")
    private String addPrice;
}

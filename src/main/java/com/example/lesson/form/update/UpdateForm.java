package com.example.lesson.form.update;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Data
public class UpdateForm {

    @Size(min = 1, max = 50)
    private String updateName;
    @NotEmpty(message = "入力してください。")
    @Pattern(regexp = "\\d*", message = "数値のみ入力してください。")
    @PositiveOrZero(message = "マイナスは入力できません。")
    private String updatePrice;
}

package com.example.lesson.form.add;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class AddForm {

    @NotEmpty
    private String name;
    @NotEmpty
    private int price;
}

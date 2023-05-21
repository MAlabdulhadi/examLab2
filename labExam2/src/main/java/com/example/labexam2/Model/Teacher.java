package com.example.labexam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teacher {
    //ID , name , salary ( all should not be empty).

    @NotNull(message = "id can not be empty")
    private int id;
    @NotEmpty(message = "name can not be empty")
    private String name;
    @NotNull(message = "salary can not be empty")
    private double salary;

}

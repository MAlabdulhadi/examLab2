package com.example.labexam2.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    //ID , name , age , major  ( all should not be empty)

    @NotNull(message = "id can not be empty")
    private int id;
    @NotEmpty(message = "name can not be empty")
    private String name;
    @NotNull(message = "age can not be empty")
    private int age;
    @NotEmpty(message = "major can not be empty")
    private String major;
}

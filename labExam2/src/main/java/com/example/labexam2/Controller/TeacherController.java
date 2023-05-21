package com.example.labexam2.Controller;


import com.example.labexam2.Model.Teacher;
import com.example.labexam2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ArrayList getStudents() {
        return teacherService.getStudents();
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.add(teacher);
        return ResponseEntity.status(200).body("done add");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @Valid @RequestBody Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = teacherService.update(id, teacher);
        if (isUpdate) {
            teacherService.update(id, teacher);
            return ResponseEntity.status(200).body("done update");
        } else {
            return ResponseEntity.status(400).body("id wrong");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        boolean isDelete = teacherService.delete(id);
        if (isDelete) {
            teacherService.delete(id);
            return ResponseEntity.status(200).body("done delete");
        }

        return ResponseEntity.status(400).body("id wrong");
    }

    @GetMapping("/getteacher/{id}")
    public ResponseEntity getTeacher(@PathVariable int id) {

        if (teacherService.getTeacherIndex(id) != -1) {
            return ResponseEntity.status(200).body(teacherService.getTeacher(teacherService.getTeacherIndex(id)));
        }

        return ResponseEntity.status(400).body("not have teacher");

    }

}

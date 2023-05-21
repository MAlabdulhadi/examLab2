package com.example.labexam2.Controller;

import com.example.labexam2.Model.Student;
import com.example.labexam2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/get")
    public ArrayList getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.add(student);
        return ResponseEntity.status(200).body("done add");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @Valid @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = studentService.update(id, student);
        if (isUpdate) {
            studentService.update(id, student);
            return ResponseEntity.status(200).body("done update");
        } else {
            return ResponseEntity.status(400).body("id wrong");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        boolean isDelete = studentService.delete(id);
        if (isDelete) {
            studentService.delete(id);
            return ResponseEntity.status(200).body("done delete");
        }

        return ResponseEntity.status(400).body("id wrong");
    }

    @GetMapping("/getstudent/{name}")
    public ResponseEntity getStudent(@PathVariable String name) {

        if (studentService.getStudentIndex(name) != -1) {
            return ResponseEntity.status(200).body(studentService.getStudent(studentService.getStudentIndex(name)));
        }

        return ResponseEntity.status(400).body("not have student");

    }


}

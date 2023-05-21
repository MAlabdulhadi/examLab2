package com.example.labexam2.Service;

import com.example.labexam2.Model.Student;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<>();


    public ArrayList getStudents() {
        return students;
    }


    public void add(Student student) {
        students.add(student);
    }


    public boolean update(int id, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public int getStudentIndex(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Student getStudent(int index) {
        return students.get(index);
    }


}

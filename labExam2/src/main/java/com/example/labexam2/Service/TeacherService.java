package com.example.labexam2.Service;


import com.example.labexam2.Model.Teacher;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();


    public ArrayList getStudents() {
        return teachers;
    }


    public void add(Teacher teacher) {
        teachers.add(teacher);
    }


    public boolean update(int id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }


    public boolean delete(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public int getTeacherIndex(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Teacher getTeacher(int index) {
        return teachers.get(index);
    }

}

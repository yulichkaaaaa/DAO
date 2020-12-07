package com.yuliana.dao.model.service;

import com.yuliana.dao.model.dao.Warehouse;
import com.yuliana.dao.model.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class SearchService {

    private final Warehouse warehouse = Warehouse.getInstance();
    private List<Student> students = warehouse.getAll();

    public List<Student> searchByName(String name){
        List<Student> result = new ArrayList<>();
        for(Student student : students){
            if(student.getName().equals(name)){
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> searchById(long studentId){
        List<Student> result = new ArrayList<>();
        for(Student student : students){
            if(student.getStudentId() == studentId){
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> searchBySurname(String surname){
        List<Student> result = new ArrayList<>();
        for(Student student : students){
            if(student.getSurname().equals(surname)){
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> searchByGroup(int group){
        List<Student> result = new ArrayList<>();
        for(Student student : students){
            if(student.getGroup() == group){
                result.add(student);
            }
        }
        return result;
    }

}

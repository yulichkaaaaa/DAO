package com.yuliana.dao.model.entity.comparator;

import com.yuliana.dao.model.entity.Student;

import java.util.Comparator;

public class StudentCompareNameAsc implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.getName().compareTo(student2.getName());
    }
}

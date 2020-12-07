package com.yuliana.dao.model.entity;

import com.yuliana.dao.util.IdGenerator;

public class Student {

    private String name;
    private String surname;
    private int group;
    private String faculty;
    private Course course;
    private long studentId;

    public Student(String name, String surname, int group, String faculty, Course course) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.faculty = faculty;
        this.course = course;
        studentId = IdGenerator.generateId();
    }

    public Student(){}

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group=" + group +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId &&
                group == student.group &&
                course == student.course &&
                name.equals(student.name) &&
                surname.equals(student.surname) &&
                faculty.equals(student.faculty);
    }

    @Override
    public int hashCode() {
        int result = (int)studentId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + group;
        result = 31 * result + course.ordinal();
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        return result;
    }
}

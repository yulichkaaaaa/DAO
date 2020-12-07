package com.yuliana.dao.model.dao;

import com.yuliana.dao.exceptions.DaoException;
import com.yuliana.dao.model.entity.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private static Warehouse instance;
    private List<Student> students = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger();

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    private Warehouse(){}

    public void add(Student student) throws DaoException {
        if(instance.contains(student)){
            logger.error("Error adding student, warehouse already has this student.");
            throw new DaoException();
        }
        students.add(student);
    }

    public void remove(Student student) throws DaoException{
        if(!instance.contains(student)){
            logger.error("Error deleting student, warehouse doesnt have this student.");
            throw new DaoException();
        }
        students.remove(student);
    }

    public boolean contains(Student student){
        return students.contains(student);
    }

    public int size(){
        return students.size();
    }

    public Student get(int index){
        return students.get(index);
    }

    public List<Student> getAll(){
        return new ArrayList<>(students);
    }
}

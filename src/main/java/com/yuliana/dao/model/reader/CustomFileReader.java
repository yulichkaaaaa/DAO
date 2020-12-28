package com.yuliana.dao.model.reader;

import com.yuliana.dao.exception.ValidationException;
import com.yuliana.dao.model.entity.Course;
import com.yuliana.dao.model.entity.Student;
import com.yuliana.dao.util.StudentValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomFileReader {

    private static final Logger logger = LogManager.getLogger();

    public List<Student> readStudents(String fileName) throws ValidationException{
        Scanner scanner = null;
        List<Student> students = new ArrayList<>();
        File file = new File(fileName);
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String studentInfo = scanner.next();
                String[] studentDescription = studentInfo.split(" ");
                if(!StudentValidator.isNameAndSurname(studentDescription[0])){
                    throw new ValidationException();
                }
                if(!StudentValidator.isNameAndSurname(studentDescription[1])){
                    throw new ValidationException();
                }
                if(!StudentValidator.isGroupNumber(studentDescription[2])){
                    throw new ValidationException();
                }
                if(!StudentValidator.isFaculty(studentDescription[3])){
                    throw new ValidationException();
                }
                String name = studentDescription[0];
                String surname = studentDescription[1];
                int group = Integer.parseInt(studentDescription[2]);
                String faculty = studentDescription[3];
                Course course = Course.valueOf(studentDescription[4]);
                Student student = new Student(name, surname, group, faculty, course);
                students.add(student);
            }
        }catch (FileNotFoundException e){
            logger.error("Error reading students. ", e);
        }finally {
            scanner.close();
        }
        return students;
    }
}

package com.InstituteManagementSystem.InMS.Service;

import com.InstituteManagementSystem.InMS.Model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;


@Service
public class StudentService {

    // Method get all students
    public List<Student> getAllStudents() {

        return listOfStudent;
    }
    // Method to get a single student based on their ID
    public Student getAStudent(int id) {
        // Use the Java 8 Stream API to find  student with the specified ID
        Optional <Student> foundRecord = listOfStudent.stream().filter(
                (currentStudent) -> {
                    return currentStudent.id == id;
                }).findFirst();
        // If a student is found with the specified ID, return it; otherwise return null
        return foundRecord.orElse(null);
    }
    // Method to create a new student
    public Student creatStudent(Student currStudent){
        currStudent.id = this.currId++;
        listOfStudent.add(currStudent);
        logger.info("Created student with id: " + currStudent.id);
        return currStudent;
    }
    // Method to update an existing student
    public Student uptdateStudent(int id,Student upToDateStudent){
        Student foundStudent = getAStudent(id);
        foundStudent.name = upToDateStudent.name;
        foundStudent.email = upToDateStudent.email;
        return foundStudent;
    }
    // Method to delete an existing student
    public Student deleteStudent(int id){
        Student foundStudent = getAStudent(id);
        listOfStudent.remove(foundStudent);
        return foundStudent;
    }
    // Create a list of students using CopyOnWriteArrayList
    public List<Student> listOfStudent = new CopyOnWriteArrayList<>();
    int currId = 1;
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

}
package com.InstituteManagementSystem.InMS.Service;

import com.InstituteManagementSystem.InMS.Model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service // Indicates  this class is a service and will be managed by Spring framework.
public class TeacherService {
    public List<Teacher> listOfTeacher = new CopyOnWriteArrayList<>();

    // Retrieves all teacher objects from the list.
    public List<Teacher> getAllTeacher() {
        return listOfTeacher;
    }
    // Retrieves a specific teacher object by ID from the list.
    public Teacher getATeacher(int id) {
        Optional<Teacher> foundRecord = listOfTeacher.stream().filter(
                (currentTeacher) -> {
                    return currentTeacher.id == id;
                }).findFirst();
        return foundRecord.orElse(null);
    }
    // Creates a new teacher object with the provided details and adds it to the list.
    public Teacher creatTeacher(Teacher currTeacher){
        currTeacher.id = this.currId++;
        listOfTeacher.add(currTeacher);
        logger.info("Created Teacher with id: " + currTeacher.id);
        return currTeacher;
    }
    // Updates an existing teacher object with new details.
    public Teacher uptdateTeacher(int id,Teacher upToDateTeacher){
        Teacher foundTeacher = getATeacher(id);
        foundTeacher.name = upToDateTeacher.name;
        foundTeacher.email = upToDateTeacher.email;
        return foundTeacher;
    }
    // Deletes a specific teacher object by ID from the list.
    public Teacher deleteTeacher(int id){
        Teacher foundStudent = getATeacher(id);
        listOfTeacher.remove(foundStudent);
        return foundStudent;
    }
    public List<Teacher> getListOfTeacher = new CopyOnWriteArrayList<>();
    int currId = 1;// Tracks the current ID for new teacher objects
    private static final Logger logger = LoggerFactory.getLogger(TeacherService.class);

}



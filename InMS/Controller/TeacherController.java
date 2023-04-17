package com.InstituteManagementSystem.InMS.Controller;

import com.InstituteManagementSystem.InMS.Model.Teacher;
import com.InstituteManagementSystem.InMS.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    // GET to retrieve all teachers
    @GetMapping
    public List<Teacher> getTeacher(){
        return teacherService.getAllTeacher();
    }
    // GET request to retrieve specific teacher by ID
    @GetMapping(path = "/{id}")
    public Teacher getTeacher(@PathVariable(name = "id") int id){
        return teacherService.getATeacher(id);

    }
    // POST request to create a new teacher
    @PostMapping
    public  Teacher creatTeacher(@RequestBody Teacher currTeacher){
        teacherService.creatTeacher(currTeacher);
        return currTeacher;
    }
    // PUT request to update an existing teacher by ID
    @PutMapping(path = "/{id}")
    public Teacher updateTeacher(@PathVariable(name = "id") int id, @RequestBody Teacher currTeacher){
        teacherService.uptdateTeacher(id, currTeacher);
        return currTeacher;
    }
    // DELETE request to delete a specific teacher by ID
    @DeleteMapping (path = "/{id}")
    public Teacher deletTeacher(@PathVariable(name = "id") int id){
        return  teacherService.deleteTeacher(id);
    }
}

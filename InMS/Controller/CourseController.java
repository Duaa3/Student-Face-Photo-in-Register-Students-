package com.InstituteManagementSystem.InMS.Controller;

import com.InstituteManagementSystem.InMS.Model.Course;
import com.InstituteManagementSystem.InMS.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    // GET to retrieve all Course
    @GetMapping
    public List<Course> getCourse(){
        return courseService.getAllCourse();
    }

    // GET request to retrieve specific Course by ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Course>> getCourse(@PathVariable(name = "id") int id){
        Optional<Course> course = courseService.getACourse(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST request to create a new Course
    @PostMapping
    public ResponseEntity<Course> creatCourse(@RequestBody Course currCourse){
        Course newCourse = courseService.newCourse(currCourse);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCourse);
    }

    // PUT request to update an existing Course by ID
    @PutMapping(path = "/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(name = "id") int id, @RequestBody Course currCourse){
        Course updatedCourse = courseService.uptdateCourse(id, currCourse);
        if (updatedCourse != null) {
            return ResponseEntity.ok(updatedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE request to delete a specific Course by ID
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable(name = "id") int id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

}

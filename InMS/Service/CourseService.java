package com.InstituteManagementSystem.InMS.Service;

import com.InstituteManagementSystem.InMS.Model.Course;
import com.InstituteManagementSystem.InMS.Repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    //perform CRUD operations on  repository of Course entities
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public Optional<Course> getACourse(int id) {
        return courseRepository.findById(id);
    }

    public Course newCourse(Course currCourse) {
        return courseRepository.save(currCourse);
    }

    public Course uptdateCourse(int id, Course upToDateCourse) {
        Optional<Course> foundCourse = courseRepository.findById(id);
        if (foundCourse.isPresent()) {
            Course existingCourse = foundCourse.get();
            existingCourse.setName(upToDateCourse.getName());
            return courseRepository.save(existingCourse);
        } else {
            return null;
        }
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);
}
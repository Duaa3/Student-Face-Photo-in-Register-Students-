package com.InstituteManagementSystem.InMS.Repository;


import com.InstituteManagementSystem.InMS.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
//JPA interface for generic CRUD operations
public interface CourseRepository extends JpaRepository<Course, Integer> {
}

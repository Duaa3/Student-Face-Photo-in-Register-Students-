package com.InstituteManagementSystem.InMS.Repository;


import com.InstituteManagementSystem.InMS.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


//JPA interface for generic CRUD operations
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}

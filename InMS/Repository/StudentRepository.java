package com.InstituteManagementSystem.InMS.Repository;
import com.InstituteManagementSystem.InMS.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//JPA interface for generic CRUD operations
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
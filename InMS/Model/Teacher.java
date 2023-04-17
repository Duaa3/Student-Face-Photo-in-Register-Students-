package com.InstituteManagementSystem.InMS.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

// Defining Teacher class with 4 public instance variables
@Entity
@Table(name ="Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int id;
    public String name;
    @Pattern(regexp="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", message="Invalid email")
    public String email;
}

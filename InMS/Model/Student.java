package com.InstituteManagementSystem.InMS.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

// Defining Student class with 3 public instance variables
@Entity
@Table(name ="Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;
    //used to validate that the email field conforms to a regular expression pattern
    @Pattern(regexp="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", message="Invalid email")
    public String email;
     public String imageName;

}

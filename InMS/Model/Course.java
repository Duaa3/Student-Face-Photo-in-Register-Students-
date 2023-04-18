package com.InstituteManagementSystem.InMS.Model;
import jakarta.persistence.*;


@Entity
//database table name
@Table(name = "pro_course")
public class Course {
    //indicating that this field serves as the primary key of the database table.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column

    public String name;

    public Course () {
    }

    public Course(int id, String name, String email) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

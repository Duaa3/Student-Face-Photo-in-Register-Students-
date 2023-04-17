package com.InstituteManagementSystem.InMS.Controller;

import com.InstituteManagementSystem.InMS.Model.Student;
import com.InstituteManagementSystem.InMS.Service.StudentService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/students")// Mapping this controller to  "/api/students" path
public class StudentController {
    // Injecting the StudentService dependency into  controller
    @Autowired
    private StudentService studentService;
    // GET request to retrieve all students
    @GetMapping
    public List<Student> getStudent(){
        return studentService.getAllStudents(); // Call the StudentService method to get all students
    }

    // GET request to retrieve a specific student by ID
    @GetMapping(path = "/{id}")
    public Student getStudents(@PathVariable(name = "id") int id){
        return studentService.getAStudent(id);

    }


    @GetMapping(path =  "/{id}/getImage")
    public ResponseEntity<byte[]> getStudentWithImage(@PathVariable(name = "id") int id) throws IOException {
        Optional<Student> optionalStudent = Optional.ofNullable(studentService.getAStudent(id));

        if(optionalStudent.isPresent()){
            Student currStudent = optionalStudent.get();
            String filename = String.format("%d_%s.jpg", currStudent.id, currStudent.name);
            File imageFile = new File("./src/main/resources/static/student_images/" + filename);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(Files.readAllBytes(imageFile.toPath()), httpHeaders, HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Student with ID %d, not found !", id));
        }
    }
    // POST request to create new student
    @PostMapping
    public  Student creatStudent(@RequestBody Student currStudent){
        studentService.creatStudent(currStudent);
        return currStudent;
    }
    @PostMapping(path = "/withImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  Student creatStudentWithImage(@RequestParam String name,
                                          @RequestParam String email,
                                          @RequestParam(required = false) MultipartFile image) throws IOException {
        Student newStudent = new Student();
        newStudent.name = name;
        newStudent.email = email;
       Student savedStudent = studentService.creatStudent(newStudent);
        if (image != null) {
            savedStudent.imageName=Integer.toString(savedStudent.id)+"_"+savedStudent.name+".jpg";
            FileUtils.writeByteArrayToFile(new File("./src/main/resources/static/student_images/" + savedStudent.imageName), image.getBytes());
           studentService.uptdateStudent(savedStudent.id, savedStudent);
        }
        return savedStudent;
    }

    // PUT request to update an existing student by ID
    @PutMapping(path = "/{id}")
    public Student updateStudent(@PathVariable(name = "id") int id, @RequestBody Student currStudent){
       studentService.uptdateStudent(id, currStudent);
        return currStudent;
    }
    // DELETE request to delete a specific student by ID
    @DeleteMapping (path = "/{id}")
    public Student deletStudent(@PathVariable(name = "id") int id){
        return  studentService.deleteStudent(id);
    }


}

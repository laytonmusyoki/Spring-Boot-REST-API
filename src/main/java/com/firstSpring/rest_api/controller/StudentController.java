package com.firstSpring.rest_api.controller;

import com.firstSpring.rest_api.Entity.Student;
import com.firstSpring.rest_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students=repo.findAll();
        return students;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        Student student=repo.findById(id).get();
        return student;
    }

    @PostMapping("/student/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        repo.save(student);
        return student;
    }


    @DeleteMapping("student/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable int id){
        Student student=repo.findById(id).get();
        repo.delete(student);
        Map<String,String> response=new HashMap<>();
        response.put("message","Student Deleted Successfully");
        return ResponseEntity.ok(response);
    }


    @PutMapping("/student/update/{id}")
    public ResponseEntity<Map<String,String>> updateStudent(@PathVariable int id){
        Student student=repo.findById(id).get();
        student.setName("Coyotito");
        student.setMarks(56);
        student.setBranch("CS");
        repo.save(student);
        Map<String,String> response=new HashMap<>();
        response.put("message","Student updated successfully");
        return ResponseEntity.ok(response);
    }

}

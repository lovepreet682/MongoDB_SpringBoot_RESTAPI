package com.mongo.restapi_mongo.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.restapi_mongo.StudentEntity.Student;
import com.mongo.restapi_mongo.services.StudentService;

@RestController
public class HomeController {

    @Autowired
    private StudentService service;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return "Value is Saved";
    }

    @GetMapping("/add")
    public List<Student> getStudentValues(Student student) {
        List<Student> Value = service.getStudentValues(student);
        return Value;
    }

    @DeleteMapping("/add/{id}")
    public String deleteData(@PathVariable String id) {
        this.service.deleteStudent(id);
        return "Data Deleted Successfully";
    }

    // Get Value By Id
    @PutMapping("/add/{id}")
    public Student UpdateStudent(@PathVariable String id, @RequestBody Student student) {
        student.setId(id);
        Student updated = this.service.updateStudent(id, student);
        // return "Value Update Successfully";
        return updated;
    }

}

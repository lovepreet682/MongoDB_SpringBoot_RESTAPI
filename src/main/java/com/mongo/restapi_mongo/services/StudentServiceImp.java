package com.mongo.restapi_mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.mongo.restapi_mongo.Repositary.StudentRepo;
import com.mongo.restapi_mongo.StudentEntity.Student;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    // Show the List
    @Override
    public List<Student> getStudentValues(Student student) {
        return studentRepo.findAll();
    }

    // Add the Data
    @Override
    public Student addStudent(Student student) {
        studentRepo.save(student);
        return student;
    }

    // delete the Data
    @Override
    public void deleteStudent(String Id) {
        Optional<Student> studentDelete = studentRepo.findById(Id);
        if (studentDelete.isPresent()) {
            this.studentRepo.delete(studentDelete.get());
        } else {
            throw new RuntimeException("Id is not exist" + Id);
        }

    }

    // find by Id
    @Override
    public Student getStudent(String Id) {
        Optional<Student> findValueByid = this.studentRepo.findById(Id);
        if (findValueByid.isPresent()) {
            return findValueByid.get();
        } else {
            throw new RuntimeException("Employee not found with id " + Id);
        }
    }

    @Override
    public Student updateStudent(@PathVariable String id, Student student) {
       Optional<Student> studentUpdate = studentRepo.findById(id);
        if (studentUpdate.isPresent()) {
            Student existStudent = studentUpdate.get();
            existStudent.setName(student.getName());
            existStudent.setEmail(student.getEmail());
            existStudent.setCity(student.getCity());
            studentRepo.save(existStudent);
            return existStudent;
        } else {
            throw new RuntimeException("Id is not exist");
        } 
    }

}

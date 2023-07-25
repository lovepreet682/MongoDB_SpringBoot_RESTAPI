package com.mongo.restapi_mongo.services;

import java.util.List;

import com.mongo.restapi_mongo.StudentEntity.Student;



public interface StudentService  {
    //show the List 
    public List<Student> getStudentValues(Student student);

    //add The Value
    public Student addStudent(Student student);

    //Update the Student Value
    public Student updateStudent(String id, Student student);

    //delete the student value
    public void deleteStudent(String Id);

    //Get Student By Id
    public Student getStudent(String Id);
}

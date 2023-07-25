package com.mongo.restapi_mongo.Repositary;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.restapi_mongo.StudentEntity.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String>{

    
}

package com.mongo.restapi_mongo.StudentEntity;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "restapi")
@Data
public class Student {
    public static final String getId = null;
    @Id
    private String id;
    private String name;

    private String email;
    private String city;

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + "]";
    }
}

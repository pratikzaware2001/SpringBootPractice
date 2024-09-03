package com.example.TestProject.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("user")
public class User {
    @Id
    int id;
    String userName;
    String passWord;
    List<String>roles=new ArrayList<>();

    @Override
    public String toString()
    {
        return this.userName+" "+this.passWord;
    }
}

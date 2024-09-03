package com.example.TestProject.repository;

import com.example.TestProject.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
    User findByUserName(String userName);
}

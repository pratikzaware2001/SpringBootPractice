package com.example.TestProject.repository;

import com.example.TestProject.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends MongoRepository<JournalEntry,String> {
}

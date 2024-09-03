package com.example.TestProject.service;

import com.example.TestProject.entity.JournalEntry;
import com.example.TestProject.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    public List<JournalEntry> getAll()
    {
        return journalRepository.findAll();
    }
}

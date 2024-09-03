package com.example.TestProject.controller;

import com.example.TestProject.entity.JournalEntry;
import com.example.TestProject.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    JournalService journalService;


    @GetMapping("/get")
    public List<JournalEntry> getAllJournal()
    {
        return journalService.getAll();
    }
}

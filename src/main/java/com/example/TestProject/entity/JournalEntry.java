package com.example.TestProject.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("journal_entry")
public class JournalEntry {
    @Id
    String id;
    String tag;
    String content;
}

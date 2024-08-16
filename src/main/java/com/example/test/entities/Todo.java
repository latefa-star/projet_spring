package com.example.test.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Todo {

    @Id
    private String id;
    private String title;
    private String description;
    private Long timeStamp;



    public Todo() {
         this.timeStamp = System.currentTimeMillis();
    }
    public Todo(String i, String title, String desc) {
        this.id=i;
        this.title=title;
        this.description=desc;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}

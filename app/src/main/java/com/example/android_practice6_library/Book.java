package com.example.android_practice6_library;

import android.util.EventLogTags;

public class Book {
    private String title;
    private String author;
    private int ISBN;
    private String topic;
    private String image;
    private String publisher;
    private String description;

    public Book(String title, String author, int ISBN, String topic, String image, String publisher, String description) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.topic = topic;
        this.image = image;
        this.publisher = publisher;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTopic() {
        return topic;
    }

    public String getImage() {
        return image;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDescription() {
        return description;
    }
}

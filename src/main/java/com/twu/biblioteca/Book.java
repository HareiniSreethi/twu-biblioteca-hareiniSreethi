package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private String publicationYear;

    public Book(String name, String author, String publicationYear) {
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public void viewBookDetails() {
        System.out.println(this.name + " | " + this.author + " | " + this.publicationYear);
    }
}

package com.twu.biblioteca;

public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public void viewBookName() {
        System.out.println(this.name);
    }
}

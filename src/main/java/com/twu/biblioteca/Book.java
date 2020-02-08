package com.twu.biblioteca;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publicationYear, book.publicationYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, publicationYear);
    }
}

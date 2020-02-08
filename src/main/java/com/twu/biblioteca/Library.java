package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    List<Book> availableBooks = new ArrayList<>();

    public Library(){
        Book bookOne = new Book("Shawshank Redemption", "Stephen King", "1982");
        Book bookTwo = new Book("Pride and Prejudice", "Jane Austen", "1813");
        this.availableBooks = Arrays.asList(bookOne, bookTwo);
    }

    public void viewAvailableBooks() {
        for (Book book: availableBooks) {
            book.viewBookDetails();
        }
    }
}

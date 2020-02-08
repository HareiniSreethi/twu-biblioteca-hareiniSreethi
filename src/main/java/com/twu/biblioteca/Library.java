package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> availableBooks = new ArrayList<>();

    public Library(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void viewAvailableBooks() {
        for (Book book: availableBooks) {
            book.viewBookDetails();
        }
    }
}

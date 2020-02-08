package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> availableBooks = new ArrayList<>();
    List<Book> checkedoutBooks = new ArrayList<>();

    public Library() {
        Book bookOne = new Book("Shawshank Redemption", "Stephen King", "1982");
        Book bookTwo = new Book("Pride and Prejudice", "Jane Austen", "1813");
        this.availableBooks.add(bookOne);
        this.availableBooks.add(bookTwo);
    }

    public void viewAvailableBooks() {
        for (Book book : availableBooks) {
            if (!checkedoutBooks.contains(book))
                book.viewBookDetails();
        }
    }

    public void checkoutBook(String bookName) {
        Book checkoutBook = new Book(bookName);

        for (Book book : availableBooks) {
            if (book.equals(checkoutBook))
                checkedoutBooks.add(checkoutBook);
        }
    }
}

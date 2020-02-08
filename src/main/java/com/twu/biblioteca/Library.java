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

        if (!availableBooks.contains(checkoutBook)) {
            System.out.println("Sorry, that book is not available");
        } else {
            for (Book book : availableBooks) {
                if (book.equals(checkoutBook)) {
                    checkedoutBooks.add(checkoutBook);
                    System.out.println("Thank you! Enjoy the book");
                }
            }
        }
    }

    public void returnBook(String bookName) {
        Book returnBook = new Book(bookName);
        if (checkedoutBooks.contains(returnBook)) {
            checkedoutBooks.remove(returnBook);
            System.out.println("Thank you for returning the book");
        } else {
            System.out.println("That is not a valid book to return");
        }
    }
}

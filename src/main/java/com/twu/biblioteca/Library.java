package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> availableBooks;
    List<Book> checkedoutBooks = new ArrayList<>();

    public Library(List<Book> availableBooks) {
        // TODO - hardcoded inside. - DONE
        this.availableBooks = availableBooks;
    }

    public void viewAvailableBooks() {
        for (Book book : availableBooks) {
            if (!checkedoutBooks.contains(book))
                book.viewBookDetails();
        }
    }

    public void checkoutBook(String bookName) {
        // TODO - get rid of the loop? somehow. equals implementation - without loop. else streams. go read about it.- DONE
        availableBooks.stream()
                .filter(book -> book.checkBookByName(bookName))
                .findFirst()
                .ifPresentOrElse(book -> {
                    checkedoutBooks.add(book);
                    System.out.println("Thank you! Enjoy the book");
                }, () -> System.out.println("Sorry, that book is not available"));
    }


    public void returnBook(String bookName) {
        for (Book book : checkedoutBooks) {
            if (book.checkBookByName(bookName)) {
                checkedoutBooks.remove(book);
                System.out.println("Thank you for returning the book");
                return;
            }
        }
        System.out.println("That is not a valid book to return");
    }
}

package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> availableBooks = new ArrayList<>();
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
        for (Book book : availableBooks) { // TODO - get rid of the loop? somehow. equals implementation - without loop. else streams. go read about it.
            if (book.checkBookByName(bookName)) {
                checkedoutBooks.add(book);
                System.out.println("Thank you! Enjoy the book");
                return;
            }
        }
        System.out.println("Sorry, that book is not available");
    }


    public void returnBook(String bookName) {
        for(Book book : checkedoutBooks){
            if(book.checkBookByName(bookName)) {
                checkedoutBooks.remove(book);
                System.out.println("Thank you for returning the book");
                return;
            }
        }
            System.out.println("That is not a valid book to return");
    }

    public void checkoutBookByAuthor(String author) {
        Book book = new Book(null, author, null); // TODO - 1. equals is broken (implementation problem as of now). 2.
    }
}

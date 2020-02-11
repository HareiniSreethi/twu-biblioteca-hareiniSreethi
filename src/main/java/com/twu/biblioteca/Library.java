package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.twu.biblioteca.CustomInputOutput.printOutput;

public class Library {
    List<Book> availableBooks;
    List<Book> checkedoutBooks = new ArrayList<>();
    List<Movie> availableMovies;

    public Library(List<Book> availableBooks) {
        // TODO - hardcoded inside. - DONE
        this.availableBooks = availableBooks;
        Movie movieOne = new Movie("Titanic", "1997", "James Cameron", "8");
        Movie movieTwo = new Movie("Joker", "2019", "Todd Phillips", "9");
        Movie movieThree =  new Movie("Jumanji", "1995", "Joe Johnston", "7");
        availableMovies = Arrays.asList(movieOne,movieTwo, movieThree);
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
                    printOutput("Thank you! Enjoy the book");
                }, () -> printOutput("Sorry, that book is not available"));
    }


    public void returnBook(String bookName) {
        checkedoutBooks.stream()
                .filter(book -> book.checkBookByName(bookName))
                .findFirst()
                .ifPresentOrElse(book -> {
                    checkedoutBooks.remove(book);
                    printOutput("Thank you for returning the book");
                }, () -> printOutput("That is not a valid book to return"));

    }

    public void addMovies(List<Movie> moviesList) {
        this.availableMovies = moviesList;
    }

    public void viewAvailableMovies(){
        for(Movie movie : availableMovies) {
            movie.viewMovieDetails();
        }
    }
}

package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.twu.biblioteca.CustomInputOutput.printOutput;

public class Library {
    private static boolean isLoggedIn = false;
    private List<Book> availableBooks;
    private HashMap<Book, String> checkedoutBooks= new HashMap<>();
    private List<Movie> availableMovies;
    private List<User> users;
    private List<Movie> checkedOutMovies = new ArrayList<>();

    public Library(List<Book> availableBooks, List<Movie> availableMovies, List<User> users) {
        // TODO - hardcoded inside. - DONE
        this.availableBooks = availableBooks;
        this.availableMovies = availableMovies;
        this.users = users;
    }

    public void viewAvailableBooks() {
        for (Book book : availableBooks) {
            if (!checkedoutBooks.containsKey(book))
                book.viewBookDetails();
        }
    }

    public void checkoutBook(String bookName, String userId) {
        // TODO - get rid of the loop? somehow. equals implementation - without loop. else streams. go read about it.- DONE
        availableBooks.stream()
                .filter(book -> book.checkBookByName(bookName))
                .findFirst()
                .ifPresentOrElse(book -> {
                    checkedoutBooks.put(book, userId);
                    printOutput("Thank you! Enjoy the book");
                }, () -> printOutput("Sorry, that book is not available"));
    }


    public void returnBook(String bookName) {
        checkedoutBooks.entrySet().stream()
                .filter(entry -> entry.getKey().checkBookByName(bookName))
                .findFirst()
                .ifPresentOrElse(entry -> {
                    checkedoutBooks.remove(entry.getKey());
                    printOutput("Thank you for returning the book");
                }, () -> printOutput("That is not a valid book to return"));

    }

    public void viewAvailableMovies() {
        for (Movie movie : availableMovies) {
            if(! checkedOutMovies.contains(movie)){
                movie.viewMovieDetails();
            }
        }
    }

    public void checkoutMovie(String movieName) {
        availableMovies.stream()
                .filter(movie -> movie.checkMovieByName(movieName))
                .findFirst()
                .ifPresentOrElse(movie -> {
                    checkedOutMovies.add(movie);
                    printOutput("Thank you! Enjoy the movie");
                }, () -> printOutput("Sorry, that movie is not available"));
    }

    public boolean validateUser(String number, String password) {
       for(User user : users){
          isLoggedIn = user.checkCredentials(number, password);
          if(isLoggedIn) break;
       }
       return isLoggedIn;
    }

    public static boolean getLoginStatus(){
        return isLoggedIn;
    }

    public void viewCheckedoutBooks() {
        for (Book book : availableBooks) {
            if (checkedoutBooks.containsKey(book))
                book.viewBookDetails();
        }
    }
}

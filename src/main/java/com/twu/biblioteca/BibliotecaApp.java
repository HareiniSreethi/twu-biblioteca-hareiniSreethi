package com.twu.biblioteca;

import com.twu.biblioteca.MenuStrategy.Strategy;

import java.util.Arrays;

import static com.twu.biblioteca.CustomInputOutput.printOutput;

// TODO
// TODO - how many library entities are in the running instance of this class? - DONE
// TODO - who manages the lifecycle of those entities? - DONE
public class BibliotecaApp {
    UserInput userInput;
    Menu menu;
    Library library;

    public BibliotecaApp(UserInput userInput, Library library, Menu menu) {
        this.userInput = userInput;
        this.library = library;
        this.menu = menu;
    }

    public void displayWelcomeMessage() {
        String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        printOutput(message);
    }

    public void displayMenuOptions() {
        menu.displayOptions();
    }

    public void displayAvailableBooks() {
        library.viewAvailableBooks();
    }

    public void selectOption() {
        userInput.selectMenuOption();
    }

    public static void main(String[] args) {
        Book bookOne = new Book("Shawshank Redemption", "Stephen King", "1982");
        Book bookTwo = new Book("Pride and Prejudice", "Jane Austen", "1813");

        Movie movieOne = new Movie("Titanic", "1997", "James Cameron", "8");
        Movie movieTwo = new Movie("Joker", "2019", "Todd Phillips", "9");
        Movie movieThree =  new Movie("Jumanji", "1995", "Joe Johnston", "7");

        User user = new User("123-4567", "password");

        Library library = new Library(Arrays.asList(bookOne, bookTwo), Arrays.asList(movieOne,movieTwo, movieThree), Arrays.asList(user));
        UserInput userInput = new UserInput(new Strategy(library));
        Menu menu = new Menu();

        BibliotecaApp bibliotecaApp = new BibliotecaApp(userInput, library, menu);
        bibliotecaApp.displayWelcomeMessage();

        while (true) {
            printOutput("\n");
            bibliotecaApp.displayMenuOptions();
            printOutput("\nSelect an option from menu");
            bibliotecaApp.selectOption();
        }
    }
}


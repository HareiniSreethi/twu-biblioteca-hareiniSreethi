package com.twu.biblioteca;

import com.twu.biblioteca.MenuStrategy.Strategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static com.twu.biblioteca.CustomInputOutput.printOutput;

// TODO
// TODO - how many library entities are in the running instance of this class? - DONE
// TODO - who manages the lifecycle of those entities? - DONE
public class BibliotecaApp {
    Menu menu;
    Library library;

    public BibliotecaApp(Library library, Menu menu) {
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
        Scanner in = new Scanner(System.in);
        String menuOption = in.nextLine();
        int option = Integer.parseInt(menuOption);
        menu.mapOptionToActions(option, in);
    }

    public static void main(String[] args) {
        Book bookOne = new Book("Shawshank Redemption", "Stephen King", "1982");
        Book bookTwo = new Book("Pride and Prejudice", "Jane Austen", "1813");

        Movie movieOne = new Movie("Titanic", "1997", "James Cameron", "8");
        Movie movieTwo = new Movie("Joker", "2019", "Todd Phillips", "9");
        Movie movieThree =  new Movie("Jumanji", "1995", "Joe Johnston", "7");

        User user = new User("123-4567", "password");

        Library library = new Library(Arrays.asList(bookOne, bookTwo), Arrays.asList(movieOne,movieTwo, movieThree), Collections.singletonList(user));
        //UserInput userInput = new UserInput(new Strategy(library));
        Menu menu = new Menu(library);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(library, menu);
        bibliotecaApp.displayWelcomeMessage();

        while (true) {
            printOutput("\n");
            bibliotecaApp.displayMenuOptions();
            printOutput("\nSelect an option from menu");
            bibliotecaApp.selectOption();
        }
    }
}


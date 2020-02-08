package com.twu.biblioteca;

import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayMenuOptions();
        bibliotecaApp.selectOption();
    }

    public void displayWelcomeMessage() {
        String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(message);
    }

    public void displayMenuOptions() {
        Menu menu = new Menu(Arrays.asList("List of Books", "Quit"));
        menu.displayMenuOptions();
    }

    public void displayAvailableBooks() {
        Library library = new Library();
        library.viewAvailableBooks();
    }

    public void selectOption() {
        UserInput userInput = new UserInput();
        userInput.getOption();
    }

}


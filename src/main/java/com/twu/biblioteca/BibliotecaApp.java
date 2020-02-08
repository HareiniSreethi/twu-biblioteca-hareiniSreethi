package com.twu.biblioteca;

import java.util.Arrays;

public class BibliotecaApp {
    UserInput userInput = new UserInput();
    Menu menu = new Menu();
    Library library = new Library();

    public static void main(String[] args) {
        Boolean isRunning = true;
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayWelcomeMessage();

        while (isRunning) {
            System.out.println();
            bibliotecaApp.displayMenuOptions();
            System.out.println("Select an option from menu");
            bibliotecaApp.selectOption();
        }
    }

    public void displayWelcomeMessage() {
        String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(message);
    }

    public void displayMenuOptions() {
        menu.displayMenuOptions();
    }

    public void displayAvailableBooks() {
        library.viewAvailableBooks();
    }

    public void selectOption() {

        userInput.getOption();
    }
}


package com.twu.biblioteca;

import java.util.Arrays;

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

    public static void main(String[] args) {
        Boolean isRunning = true;
        Book bookOne = new Book("Shawshank Redemption", "Stephen King", "1982");
        Book bookTwo = new Book("Pride and Prejudice", "Jane Austen", "1813");
        Library library = new Library(Arrays.asList(bookOne, bookTwo));
        UserInput userInput = new UserInput(library);
        Menu menu = new Menu();

        BibliotecaApp bibliotecaApp = new BibliotecaApp(userInput, library, menu);
        bibliotecaApp.displayWelcomeMessage();

        while (isRunning) {
            System.out.println();
            bibliotecaApp.displayMenuOptions();
            System.out.println("Select an option from menu");
            bibliotecaApp.selectOption();
        }
    }
}


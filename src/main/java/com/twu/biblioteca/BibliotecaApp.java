package com.twu.biblioteca;

public class BibliotecaApp {
    UserInput userInput = new UserInput();
    Menu menu = new Menu();
    Library library = new Library();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayWelcomeMessage();

        while (true) {
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


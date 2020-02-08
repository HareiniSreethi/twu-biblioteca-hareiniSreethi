package com.twu.biblioteca;

import java.util.Arrays;
import java.util.Scanner;

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
        Menu menu = new Menu(Arrays.asList("List of Books"));
        menu.displayMenuOptions();
    }

    public void displayAvailableBooks() {
        Book bookOne = new Book("Shawshank Redemption", "Stephen King", "1982");
        Book bookTwo = new Book("Pride and Prejudice", "Jane Austen", "1813");
        Library library = new Library(Arrays.asList(bookOne, bookTwo));

        library.viewAvailableBooks();
    }

    public void selectOption() {
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        if (option == 1) {
            displayAvailableBooks();
        }
        else {
            System.out.println("Please select a valid option!");
        }
    }

    public void selectOption(int option) {
        if (option == 1) {
            displayAvailableBooks();
        }
        else {
            System.out.println("Please select a valid option!");
        }
    }
}


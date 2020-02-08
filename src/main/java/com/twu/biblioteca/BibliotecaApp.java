package com.twu.biblioteca;

import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayMenuOptions();

        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        bibliotecaApp.displayAvailableBooks();
    }

    public void displayWelcomeMessage() {
        String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(message);
    }

    public void displayAvailableBooks() {
        Book bookOne = new Book("Shawshank Redemption", "Stephen King", "1982");
        Book bookTwo = new Book("Pride and Prejudice", "Jane Austen", "1813");
        Library library = new Library(Arrays.asList(bookOne, bookTwo));

        library.viewAvailableBooks();
    }

    public void displayMenuOptions() {
        Menu menu = new Menu(Arrays.asList("List of Books"));
        menu.displayMenuOptions();
    }
}


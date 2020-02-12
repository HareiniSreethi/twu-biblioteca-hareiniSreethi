package com.twu.biblioteca.MenuStrategy;

import com.twu.biblioteca.Library;

import java.util.Scanner;

import static com.twu.biblioteca.CustomInputOutput.printOutput;

public class CheckoutMovie implements MenuActions {
    @Override
    public void performAction(Library library, Scanner scanner) {
        printOutput("Enter movie name to check out : ");
        String movieName = scanner.nextLine();
        library.checkoutMovie(movieName);
    }
}

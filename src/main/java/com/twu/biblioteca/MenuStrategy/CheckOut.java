package com.twu.biblioteca.MenuStrategy;

import com.twu.biblioteca.Library;

import java.util.Scanner;

import static com.twu.biblioteca.CustomInputOutput.printOutput;

public class CheckOut implements MenuActions {

    @Override
    public void performAction(Library library, Scanner scanner) {
        printOutput("Enter Library Number");
        String number = scanner.nextLine();
        printOutput("Enter password");
        String password = scanner.nextLine();

        if(library.validateUser(number, password)){
            printOutput("Enter book name to check out : ");
            String bookName = scanner.nextLine();
            library.checkoutBook(bookName, number);
        }
        else {
            printOutput("Invalid Credentials");
        }
    }
}

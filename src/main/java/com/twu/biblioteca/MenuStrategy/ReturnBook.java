package com.twu.biblioteca.MenuStrategy;

import com.twu.biblioteca.Library;

import java.util.Scanner;

import static com.twu.biblioteca.CustomInputOutput.printOutput;

public class ReturnBook implements MenuActions {
    @Override
    public void performAction(Library library, Scanner scanner) {
        printOutput("Enter Library Number");
        String number = scanner.nextLine();
        printOutput("Enter password");
        String password = scanner.nextLine();

        if(library.validateUser(number, password)){
            printOutput("Enter book name to return : ");
            String bookName = scanner.nextLine();
            library.returnBook(bookName);
        }
        else {
            printOutput("Invalid Credentials");
        }
    }
}

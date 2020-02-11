package com.twu.biblioteca.MenuStrategy;

import com.twu.biblioteca.Library;

import java.util.Scanner;

import static com.twu.biblioteca.CustomInputOutput.printOutput;

public class ReturnBook implements MenuActions {
    @Override
    public void performAction(Library library, Scanner scanner) {
        printOutput("Enter book name to return : ");
        String bookName = scanner.nextLine();
        library.returnBook(bookName);
    }
}

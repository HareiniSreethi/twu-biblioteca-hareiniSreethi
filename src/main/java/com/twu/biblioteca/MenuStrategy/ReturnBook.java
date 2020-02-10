package com.twu.biblioteca.MenuStrategy;

import com.twu.biblioteca.Library;

import java.util.Scanner;

public class ReturnBook implements MenuActions {
    @Override
    public void performAction(Library library, Scanner scanner) {
        System.out.println("\nEnter book name to return : ");
        String bookName = scanner.nextLine();
        library.returnBook(bookName);
    }
}

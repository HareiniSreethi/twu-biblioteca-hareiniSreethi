package com.twu.biblioteca.MenuStrategy;

import com.twu.biblioteca.Library;

import java.util.Scanner;

public class CheckOut implements MenuActions {

    @Override
    public void performAction(Library library, Scanner scanner) {
        System.out.println("\nEnter book name to check out : ");
        String bookName = scanner.nextLine();
        library.checkoutBook(bookName);
    }
}

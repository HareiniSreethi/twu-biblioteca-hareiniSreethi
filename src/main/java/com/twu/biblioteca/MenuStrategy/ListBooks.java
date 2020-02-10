package com.twu.biblioteca.MenuStrategy;

import com.twu.biblioteca.Library;

import java.util.Scanner;

public class ListBooks implements MenuActions {

    @Override
    public void performAction(Library library, Scanner scanner) {
        library.viewAvailableBooks();
    }
}

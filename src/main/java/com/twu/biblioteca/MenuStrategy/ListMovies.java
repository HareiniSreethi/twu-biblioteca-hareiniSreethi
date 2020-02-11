package com.twu.biblioteca.MenuStrategy;

import com.twu.biblioteca.Library;

import java.util.Scanner;

public class ListMovies implements MenuActions {
    @Override
    public void performAction(Library library, Scanner scanner) {
        library.viewAvailableMovies();
    }
}

package com.twu.biblioteca.MenuStrategy;

import com.twu.biblioteca.Library;

import java.util.Scanner;

public class Quit implements MenuActions {
    @Override
    public void performAction(Library library, Scanner scanner) {
        System.exit(0);
    }
}

package com.twu.biblioteca;

import java.util.Scanner;

public class UserInput {

    public void getOption() {
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        if (option == 1) {
            Library library = new Library();
            library.viewAvailableBooks();
        }
        else {
            System.out.println("Please select a valid option!");
        }
    }
}

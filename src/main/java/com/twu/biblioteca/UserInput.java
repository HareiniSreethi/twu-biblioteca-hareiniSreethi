package com.twu.biblioteca;

import java.util.Scanner;

public class UserInput {

    public void getOption() {
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        switch (option) {
            case 1:
                Library library = new Library();
                library.viewAvailableBooks();
                break;
            case 2:
                System.exit(0);
            default:
                System.out.println("Please select a valid option!");
                break;
        }
    }
}

package com.twu.biblioteca;

import java.util.Scanner;

// TODO - list down the responsibilites of this class.
// 1. get user input - also know how to get it
// 1.1 Assume System.in exists and works properly.
// 2. do the according things - lot of things here
// 3. and more as well.
// TODO - how does it do on SRP, OCP etc
public class UserInput {
    private Library library;

    public UserInput(Library library) {
        this.library = library;
    }

    public void getOption() { // TODO - this is not possibly a "get" method. Get methods wouldn't have a void return type?
        Scanner in = new Scanner(System.in);
        String option = in.nextLine();

        switch (Integer.parseInt(option)) {
            case 1:
                library.viewAvailableBooks();
                break;
            case 2:
                System.out.println("\nEnter book name to check out : ");
                String bookName = in.nextLine();
                library.checkoutBook(bookName.trim());
                break;
            case 3:
                System.out.println("\nEnter book name to return : ");
                String returnBookName = in.nextLine();
                library.returnBook(returnBookName.trim());
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Please select a valid option!");
                break;
        }
    }
}

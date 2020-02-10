package com.twu.biblioteca;

import java.util.Scanner;

public class UserInput {
    Library library = new Library();

    public void getOption() {
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

package com.twu.biblioteca;

import java.util.Scanner;

public class UserInput {
    Library library = new Library();

    public void getOption() {
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        switch (option) {
            case 1:
                library.viewAvailableBooks();
                break;
            case 2:
                System.out.println("\nEnter book name to check out : ");
                Scanner scanner = new Scanner(System.in);
                String bookName = scanner.nextLine();
                library.checkoutBook(bookName.trim());
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Please select a valid option!");
                break;
        }
    }
}

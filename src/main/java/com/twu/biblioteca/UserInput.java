package com.twu.biblioteca;

import java.util.Scanner;

public class UserInput {
    private Library library;


    public UserInput(Library library) {
        this.library = library;
    }

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
                System.out.println("\nEnter book name to return : ");
                Scanner scan = new Scanner(System.in);
                String returnBookName = scan.nextLine();
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

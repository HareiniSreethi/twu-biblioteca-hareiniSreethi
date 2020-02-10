package com.twu.biblioteca;

public enum MenuOptions {
    LIST_OF_BOOKS(1,"List of Books"),
    CHECKOUT_BOOKS(2, "Checkout Book"),
    RETURN_BOOKS(3, "Return Book"),
    QUIT(4, "Quit");

    private final int optionNumber;
    private final String optionValue;

    MenuOptions(int optionNumber, String optionValue) {
        this.optionNumber = optionNumber;
        this.optionValue = optionValue;
    }
}




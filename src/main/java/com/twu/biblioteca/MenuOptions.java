package com.twu.biblioteca;

public enum MenuOptions {
    LIST_OF_BOOKS(1, "List of Books"),
    CHECKOUT_BOOKS(2, "Checkout Book"),
    RETURN_BOOKS(3, "Return Book"),
    LIST_OF_MOVIES(4, "List of Movies"),
    CHECKOUT_MOVIES(5, "Checkout Movie"),
    QUIT(6, "Quit");

    private final int optionNumber;
    private final String optionValue;

    MenuOptions(int optionNumber, String optionValue) {
        this.optionNumber = optionNumber;
        this.optionValue = optionValue;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public String getOptionValue() {
        return optionValue;
    }
}




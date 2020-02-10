package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private List<String> menuOptions;

    public Menu() {
        this.menuOptions = Arrays.asList("List of Books", "Checkout book", "Return Book", "Quit");
    }

    public void displayMenuOptions() {
        for (String menu : menuOptions) {
            System.out.println(menuOptions.indexOf(menu) + 1 + ". " + menu);
        }
    }
}

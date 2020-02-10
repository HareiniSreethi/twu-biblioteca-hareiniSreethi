package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private List<String> menuOptions;

    public Menu() {
        this.menuOptions = Arrays.asList("List of Books", "Checkout book", "Return Book", "Quit");
    }

    // TODO - why have "menu" in the method name?
    public void displayMenuOptions() { // TODO - that sort of depends on implementation. foreach loop can be parallelized too. for-iter can't.
        for (String menu : menuOptions) { // TODO - we use foreach loops when we don't care about indexes. When you write for loop - you're telling me indexes are important. in foreach, you're saying they not.
            System.out.println(menuOptions.indexOf(menu) + 1 + ". " + menu); // TODO - very confusing line. why? mixing integer addition with string addition
        }
    }
}

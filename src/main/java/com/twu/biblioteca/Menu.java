package com.twu.biblioteca;

public class Menu {
    // TODO - why have "menu" in the method name?
    public void displayOptions() { // TODO - that sort of depends on implementation. foreach loop can be parallelized too. for-iter can't.
        for (MenuOptions menu : MenuOptions.values()) { // TODO - we use foreach loops when we don't care about indexes. When you write for loop - you're telling me indexes are important. in foreach, you're saying they not. - DONE
            System.out.println(menu.getOptionNumber() + ". " + menu.getOptionValue()); // TODO - very confusing line. why? mixing integer addition with string addition -DONE
        }
    }
}

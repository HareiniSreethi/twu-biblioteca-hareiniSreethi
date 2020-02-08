package com.twu.biblioteca;

import java.util.List;

public class Menu {
    private List<String> menuOptions;

    public Menu(List<String> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public void displayMenuOptions() {
        for (String menu : menuOptions) {
            System.out.println(menuOptions.indexOf(menu) + 1 + ". " + menu);
        }
    }
}

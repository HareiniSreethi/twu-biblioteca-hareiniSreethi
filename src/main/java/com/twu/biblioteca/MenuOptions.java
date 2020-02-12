package com.twu.biblioteca;

import com.twu.biblioteca.MenuStrategy.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MenuOptions {
    LIST_OF_BOOKS(false, "List of Books", new ListBooks()),
    CHECKOUT_BOOKS(false, "Checkout Book", new CheckOut()),
    RETURN_BOOKS(false, "Return Book", new ReturnBook()),
    LIST_OF_MOVIES(false, "List of Movies", new ListMovies()),
    CHECKOUT_MOVIES(false, "Checkout Movie", new CheckoutMovie()),
    VIEW_CHECKEDOUT_BOOKS(true, "View Checkedout Books", new CheckoutMovie()),
    QUIT(false, "Quit", new Quit());

    private final boolean isLoggedIn;
    private final String optionValue;
    private MenuActions menuAction;

    MenuOptions(boolean isLoggedIn, String optionValue, MenuActions menuAction) {
        this.isLoggedIn = isLoggedIn;
        this.optionValue = optionValue;
        this.menuAction = menuAction;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public MenuActions getMenuAction() {
        return menuAction;
    }

    public static List<MenuOptions> getMenuForUnAuthUsers(){
        List<MenuOptions> unAuthMenu = new ArrayList<>();
        for(MenuOptions menu : MenuOptions.values()) {
            if(!menu.isLoggedIn){
                unAuthMenu.add(menu);
            }
        }
        return unAuthMenu;
    }

    public static List<MenuOptions> getMenuForAuthUsers(){
        return new ArrayList<>(Arrays.asList(MenuOptions.values()));
    }

}




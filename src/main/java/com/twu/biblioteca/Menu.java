package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.twu.biblioteca.CustomInputOutput.printOutput;
import static com.twu.biblioteca.Library.getLoginStatus;
import static com.twu.biblioteca.MenuOptions.getMenuForAuthUsers;
import static com.twu.biblioteca.MenuOptions.getMenuForUnAuthUsers;

public class Menu {

    List<MenuOptions> menuItems = new ArrayList<>();
    Library library;

    Menu(Library library){
        this.library = library;
    }

    // TODO - why have "menu" in the method name? - DONE
    public void displayOptions() {
        // TODO - that sort of depends on implementation. foreach loop can be parallelized too. for-iter can't.
        // TODO - we use foreach loops when we don't care about indexes. When you write for loop - you're telling me indexes are important. in foreach, you're saying they not. - DONE
        // TODO - very confusing line. why? mixing integer addition with string addition -DONE

        if(!getLoginStatus()){
            menuItems = getMenuForUnAuthUsers();
        }
        else {
            menuItems = getMenuForAuthUsers();
        }

        for (int index = 0; index < menuItems.size(); index++) {
            printOutput( (index + 1) + ". " + menuItems.get(index).getOptionValue());
        }

    }

    public void mapOptionToActions(int option, Scanner scanner) {
        if(option <= menuItems.size()){
            menuItems.get(option-1).getMenuAction().performAction(library, scanner);
        }
        else{
            printOutput("Please select a valid option!");
        }
    }
}

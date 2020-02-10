package com.twu.biblioteca;

import com.twu.biblioteca.MenuStrategy.Strategy;

import java.util.Scanner;

// TODO - list down the responsibilites of this class.- DONE
// 1. get user input - also know how to get it
// 1.1 Assume System.in exists and works properly.
// 2. view available books
// 3. checkout book
// 4. return book
// 5. exit application
// 6. notify on invalid option

// TODO - how does it do on SRP, OCP etc  DONE
// this class has more than one responsibility thus breaking SRP
// OCP - it requires modification to be done each time a new menu option is introduced

public class UserInput {
    private Library library;
    private Strategy strategy;

    public UserInput(Library library, Strategy strategy) {
        this.library = library;
        this.strategy = strategy;
    }

    public void selectMenuOption() { // TODO - this is not possibly a "get" method. Get methods wouldn't have a void return type? - DONE
        Scanner in = new Scanner(System.in);
        String menuOption = in.nextLine();
        int option = Integer.parseInt(menuOption);
        strategy.mapOptionToActions(option, in);
    }
}

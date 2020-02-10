package com.twu.biblioteca.MenuStrategy;

import com.twu.biblioteca.*;

import java.util.HashMap;
import java.util.Scanner;

public class Strategy {
    Library library;
    HashMap<Integer, MenuActions> optionMap = new HashMap<>();

    public Strategy(Library library) {
        this.library = library;
        optionMap.put(1, new ListBooks());
        optionMap.put(2, new CheckOut());
        optionMap.put(3, new ReturnBook());
    }


    public void mapOptionToActions(int option, Scanner scanner) {
        if(optionMap.containsKey(option)){
            optionMap.get(option).performAction(library, scanner);
        }
        else{
            System.out.println("Please select a valid option!");
        }
    }


}
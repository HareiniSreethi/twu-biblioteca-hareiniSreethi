package com.twu.biblioteca;
import java.io.PrintStream;

public class CustomInputOutput {

    public static void printOutput(String message){
        PrintStream stream = new PrintStream(System.out);
        stream.println(message);
    }
}

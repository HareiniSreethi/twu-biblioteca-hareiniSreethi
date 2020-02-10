package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shouldDisplayTheListOfMenuOptions() {
        Menu menu = new Menu();
        String expectedOutput = "1. List of Books\n" +
                "2. Checkout book\n" +
                "3. Return Book\n" +
                "4. Quit";
        menu.displayMenuOptions();

        assertEquals(expectedOutput, outContent.toString().trim());
    }

}
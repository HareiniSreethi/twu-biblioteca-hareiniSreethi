package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WelcomeUserTest {
    @Test
    void shouldDisplayWelcomeGreeting() {
        WelcomeUser welcomeUser = new WelcomeUser();
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(expectedMessage, welcomeUser.displayMessage());
    }
}
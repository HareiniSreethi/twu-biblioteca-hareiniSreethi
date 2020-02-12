package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldCheckIfUserCredentialsAreValid() {
        User user = new User("123-4567", "password");

        assertEquals("123-4567",user.getLibraryNumber());
        assertEquals("password",user.getPassword());
    }
}
package com.twu.biblioteca;

public class User {
    private final String libraryNumber;
    private final String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return this.libraryNumber;
    }

    public String getPassword() {
        return this.password;
    }
}

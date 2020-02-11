package com.twu.biblioteca;

import java.util.Objects;

import static com.twu.biblioteca.CustomInputOutput.printOutput;

public class Book {
    private String name;
    private String author;
    private String publicationYear;


    public Book(String name, String author, String publicationYear) {
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // TODO - doesn't make sense to create book with just a name. - Because any behavior dependent on other fields will fail. - DONE (removed constructor)

    public void viewBookDetails() { // TODO - global dependency - code smell. We fix it by - ???
        String columnSeparator = " | ";
        printOutput(this.name + columnSeparator + this.author + columnSeparator + this.publicationYear); // TODO - magic literals - DONE
    }

//    @Override // TODO - this is not gonna work - How will we add find the book by author? - Take your time and come back. -DONE
//    public boolean equals(Object otherBook) { // TODO - think what are the problem with this approach? How would you compare authors or years? - DONE
//        if (this == otherBook) return true;
//        if (otherBook == null || getClass() != otherBook.getClass()) return false;
//        Book book = (Book) otherBook; // TODO - I'll probably call it "other" or "otherBook" - Because java equals / comparator conventions. - DONE
//        return Objects.equals(name, book.name); // TODO - do you think this is functionally correct? Would my tests pass? Should my tests pass? - DONE
//    } // TODO - incorrect - we break the feature of finding by title/name. - DONE
//

    @Override
    public boolean equals(Object otherBook){
        if (this == otherBook) return true;
        if (otherBook == null || getClass() != otherBook.getClass()) return false;
        Book book = (Book) otherBook;

        return Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publicationYear, book.publicationYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, publicationYear);
    } // TODO - doesn't properly implement the java contract of equals and hashCode. - DONE

    public boolean checkBookByName(String name) {
        return this.name.equals(name);
    }
}

package fr.uge.jee.bookstore;

import java.util.Objects;
import java.util.Set;

public class Library {
    private Set<Book> books;

    public Library(Set<Book> books) {
        this.books = Objects.requireNonNull(books);
    }


}

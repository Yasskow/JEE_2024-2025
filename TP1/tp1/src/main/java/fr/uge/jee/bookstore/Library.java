package fr.uge.jee.bookstore;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Library {
    private Set<Book> books;

    public Library() {
        this.books = Set.of();
    }

    public Library(Set<Book> books) {
        this.books = Objects.requireNonNull(books);
    }

    @Override
    public String toString() {
        return books.stream().map(book -> book.toString()).collect(Collectors.joining(", "));
    }
}

/**
 * Une erreur sur le fait qu'il n'y ait pas de constructeur pas défaut
 * */
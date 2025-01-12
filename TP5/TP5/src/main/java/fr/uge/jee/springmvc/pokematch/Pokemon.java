package fr.uge.jee.springmvc.pokematch;

import java.util.Objects;

public class Pokemon {
    private final String name;
    private final String url;

    Pokemon(String name, String url) {
        this.name = Objects.requireNonNull(name);
        this.url = Objects.requireNonNull(url);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}

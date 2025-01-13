package fr.uge.jee.springmvc.pokematch;

import java.util.Objects;

public class Pokemon {
    private final String name;
    private final String url;
    private final int uid;

    Pokemon(String name, String url) {
        this.name = Objects.requireNonNull(name);
        this.url = Objects.requireNonNull(url);
        var urlElement = url.split("/");
        this.uid = Integer.parseInt(urlElement[urlElement.length-1]);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    public int getUid() {
        return uid;
    }
}

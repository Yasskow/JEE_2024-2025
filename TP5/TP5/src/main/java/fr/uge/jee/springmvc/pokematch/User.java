package fr.uge.jee.springmvc.pokematch;

import jakarta.validation.constraints.Pattern;

import java.util.Objects;

public record User(

    @Pattern(regexp = "^[a-zA-Z]+$", message = "{firstName.invalid}")
    String firstName,

    @Pattern(regexp = "^[a-zA-Z]+$", message = "{lastName.invalid}")
    String lastName){



    @Override
    public int hashCode() {
        return lastName.hashCode() + firstName.hashCode();
    }
}
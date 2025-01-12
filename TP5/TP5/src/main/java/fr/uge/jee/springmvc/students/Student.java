package fr.uge.jee.springmvc.students;

import jakarta.validation.constraints.Pattern;

public record Student(

    @Pattern(regexp = "[a-zA-Z]", message = "{firstname.invalid}")
    String firstName,

    @Pattern(regexp = "[a-zA-Z]", message = "{lastName.invalid}")
    String lastName){
}
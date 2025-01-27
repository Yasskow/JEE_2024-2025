package fr.uge.poo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pokemon {
    @Id
    public String name;
    public int score;

    public Pokemon(){}
    public Pokemon(String name){
        this.name = Objects.requireNonNull(name, "Name is null");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

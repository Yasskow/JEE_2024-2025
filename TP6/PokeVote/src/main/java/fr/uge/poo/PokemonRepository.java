package fr.uge.poo;

import fr.uge.poo.Pokemon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PokemonRepository extends CrudRepository<Pokemon, String> {
    @Query("SELECT SUM(score) FROM Pokemon p ")
    long totalScore();
}

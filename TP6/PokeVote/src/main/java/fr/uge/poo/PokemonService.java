package fr.uge.poo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Service
public class PokemonService {
    public final PokemonRepository pokemonRepository;
    @PersistenceUnit
    private final EntityManagerFactory emf;

    @PersistenceContext
    private final EntityManager em;

    public PokemonService(PokemonRepository pokemonRepository, EntityManagerFactory emf, EntityManager em){
        this.pokemonRepository = pokemonRepository;
        this.emf = emf;
        this.em = em;
    }

    @Transactional
    public void insertOrIncrementPokemon(String name){
        var poke = em.find(Pokemon.class, name, LockModeType.PESSIMISTIC_WRITE);
        if(poke == null){
            pokemonRepository.save(new Pokemon(name));
        }else{
            poke.setScore(poke.getScore()+1);
            pokemonRepository.save(poke);
        }
    }
    @Transactional
    public long totalCountVote(){
        return pokemonRepository.totalScore();
    }
}

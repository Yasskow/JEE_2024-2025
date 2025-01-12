package fr.uge.jee.springmvc.pokematch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PokematchService {

    private final Object lock = new Object();
    private final WebClient webClient;
    private final List<Pokemon> pokemons;
    private final Map<Pokemon, Integer> mostFetish = new HashMap<>();

    private final int limitForMostFetish;

    public PokematchService(WebClient webClient, @Value("${most.fetish.pokemons}") int limitForMostFetish) {
        this.webClient = webClient;
        this.pokemons = fetchPokemons();
        this.limitForMostFetish = limitForMostFetish;
    }

    public record PokemonList(List<Pokemon> results) {
    }

    public record PokemonImage(String sprites) {
    }

    private void addFetish(Pokemon pokemon) {
        synchronized (lock){
            mostFetish.merge(pokemon, 1, Integer::sum);
        }
    }

    public String pokemonImage(Pokemon pokemon){
        var response = webClient.get()
                .uri(pokemon.getUrl())
                .retrieve()
                .bodyToMono(PokemonImage.class)
                .block();
        return response.sprites();
    }

    public List<Pokemon> getMostFetich() {
        return mostFetish.entrySet().stream().sorted(Comparator.comparingInt((Map.Entry<Pokemon, Integer> pokemonIntegerEntry) -> pokemonIntegerEntry.getValue()).reversed()).map(pokemonIntegerEntry -> pokemonIntegerEntry.getKey()).limit(limitForMostFetish).toList();
    }

    private List<Pokemon> fetchPokemons() {
        var response = webClient.get()
                .uri("https://pokeapi.co/api/v2/pokemon?limit=40")
                .retrieve()
                .bodyToMono(PokemonList.class)
                .block();
        return response.results();
    }

    public Pokemon findFetish(User user) {
        if(pokemons == null)
            throw new IllegalStateException();
        var pokeFetish = pokemons.stream().min(Comparator.comparing(pokemon -> Math.abs(pokemon.hashCode() - user.hashCode()))).orElse(null);
        addFetish(pokeFetish);
        return pokeFetish;
    }
}

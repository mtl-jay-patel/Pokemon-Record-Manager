package com.example.pokemonmanager.service;

import com.example.pokemonmanager.exception.PokemonNotFoundException;
import com.example.pokemonmanager.model.Pokemon;
import com.example.pokemonmanager.repo.PokemonRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PokemonService {
    private final PokemonRepo pokemonRepo;

    @Autowired
    public PokemonService(PokemonRepo pokemonRepo) {
        this.pokemonRepo = pokemonRepo;
    }

    public Pokemon addPokemon(Pokemon pokemon) {
        pokemon.setPokemonCode(UUID.randomUUID().toString());
        return pokemonRepo.save(pokemon);
    }

    public List<Pokemon> findAllPokemon() {
        return pokemonRepo.findAll();
    }

    public Pokemon updatePokemon(Pokemon pokemon) {
        return pokemonRepo.save(pokemon);
    }

    public Pokemon findPokemon(Long id) {
        return pokemonRepo.findPokemonById(id)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon with id " + id + " not found ") );
    }

    @Transactional
    public void deletePokemon(Long id) {
        pokemonRepo.deletePokemonById(id);
    }
}

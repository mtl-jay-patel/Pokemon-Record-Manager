package com.example.pokemonmanager.repo;

import com.example.pokemonmanager.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonRepo extends JpaRepository <Pokemon, Long> {
    void deletePokemonById(Long id);

    Optional<Pokemon> findPokemonById(Long id);
}

package com.example.pokemonmanager;

import com.example.pokemonmanager.model.Pokemon;
import com.example.pokemonmanager.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pokemon>> getAllPokemon () {
        List<Pokemon> pokemon = pokemonService.findAllPokemon();
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Pokemon> getPokemonById (@PathVariable("id") Long id) {
        Pokemon pokemon = pokemonService.findPokemon(id);
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pokemon> addPokemon (@RequestBody Pokemon pokemon) {
        Pokemon newPokemon = pokemonService.addPokemon(pokemon);
        return new ResponseEntity<>(newPokemon, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Pokemon> updatePokemon (@RequestBody Pokemon pokemon) {
        Pokemon updatedPokemon = pokemonService.updatePokemon(pokemon);
        return new ResponseEntity<>(updatedPokemon, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePokemonById (@PathVariable("id") Long id) {
         pokemonService.deletePokemon(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

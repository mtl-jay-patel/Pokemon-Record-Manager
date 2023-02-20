package com.example.pokemonmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Pokemon implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)

    private Long id;
    private String name;
    private String ability;
    private String move1;
    private String move2;
    private String move3;
    private String move4;
    private String imageUrl;
    private String pokemonCode;

    public Pokemon() {

    }

    public Pokemon(String name, String ability, String move1, String move2, String move3, String move4, String imageUrl, String pokemonCode) {
        this.name = name;
        this.ability = ability;
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
        this.imageUrl = imageUrl;
        this.pokemonCode = pokemonCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getMove1() {
        return move1;
    }

    public void setMove1(String move1) {
        this.move1 = move1;
    }

    public String getMove2() {
        return move2;
    }

    public void setMove2(String move2) {
        this.move2 = move2;
    }

    public String getMove3() {
        return move3;
    }

    public void setMove3(String move3) {
        this.move3 = move3;
    }

    public String getMove4() {
        return move4;
    }

    public void setMove4(String move4) {
        this.move4 = move4;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPokemonCode() {
        return pokemonCode;
    }

    public void setPokemonCode(String pokemonCode) {
        this.pokemonCode = pokemonCode;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ability='" + ability + '\'' +
                ", move1='" + move1 + '\'' +
                ", move2='" + move2 + '\'' +
                ", move3='" + move3 + '\'' +
                ", move4='" + move4 + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

package com.ADA.model;

import java.util.UUID;

public class Pokemon {

    UUID uuid;
    Integer HP;
    Breed breed;
    String name;

    public Pokemon(Integer HP, Breed breed, String name) {
        this.HP = HP;
        this.breed = breed;
        this.name = name;
    }

    public Integer getHP() {
        return HP;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

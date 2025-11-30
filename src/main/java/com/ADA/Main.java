package com.ADA;

import com.ADA.battleSimulation.BattleStatistics;
import com.ADA.dataGenerator.PokemonDataLoader;
import com.ADA.model.Breed;
import com.ADA.model.PType;
import com.ADA.model.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        PokemonDataLoader myLoader = new PokemonDataLoader();
        Map<Integer, Breed> pBreeds = myLoader.loadBreeds("pokemon_simplified.csv");

        for(int i = 0; i < 10; i++) {
            // Number of Pkemon to choose from
            int nPokemonOptopns = 3;
            myLoader.selectRandomBreedsForBattle(pBreeds, nPokemonOptopns);

            // Create sample Pokemon individuals
            List<Pokemon> pokemons = new ArrayList<>();
            System.out.println("Pokemon options:  ");
            for (Breed b : myLoader.selectRandomBreedsForBattle(pBreeds, nPokemonOptopns)) {
                pokemons.add(new Pokemon(b.getHP(), b, b.getbName()));
                //System.out.println("    " + b.getbName());
            }

            // Example probability distribution
            Map<PType, Double> probs = PokemonDataLoader.calculateProbabilities(pBreeds);

            // Select best Pokémon using expected utility
            PSelector battle = new PSelector();
            Pokemon best = battle.getBestPokemon(pokemons, probs);

            System.out.println("Best Pokemon chosen: " + best.getBreed().getbName());

            // Run simulations
            BattleStatistics.runSimulations(best, pBreeds, 1000);
        }
    }
}

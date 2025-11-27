package com.ADA.battleSimulation;

import com.ADA.model.Breed;
import com.ADA.model.Pokemon;

import java.util.Map;
import java.util.Random;

public class BattleStatistics {

    public static void runSimulations(Pokemon chosen,
                                      Map<Integer, Breed> allBreeds,
                                      int numSimulations) {

        int wins = 0;
        int totalHP1 = 0;
        int totalHP2 = 0;
        int totalHP2W = 0;

        Random rnd = new Random();

        for (int i = 0; i < numSimulations; i++) {

            // pick random opponent
            Breed randomBreed = allBreeds.get(
                    (Integer) allBreeds.keySet().toArray()[rnd.nextInt(allBreeds.size())]
            );
            Pokemon enemy = new Pokemon(randomBreed.getHP(), randomBreed, randomBreed.getbName());

            //System.out.println("----- "+chosen.getName()+" vs "+ enemy.getName()+" =");

            BattleResult result = BattleSimulator.simulateBattle(chosen, enemy);

            if (result.didP1Win()){
                //System.out.println("  We win  ------");
                wins++;
            }else {
                totalHP2W+= result.finalHP2;
                //System.out.println(" Enemy wins -----");
            }

            totalHP1 += result.finalHP1;
            totalHP2 += result.finalHP2;
        }

        System.out.println("----- Simulation Results -----");
        System.out.println("Total simulations: " + numSimulations);
        System.out.println("Win rate: " + (wins * 100.0 / numSimulations) + "%");
        System.out.println("Average remaining HP (chosen Pokémon): " + (totalHP1 / numSimulations));
        System.out.println("Average remaining HP (enemy): " + (totalHP2 / numSimulations));
        System.out.println("Average remaining HP (enemy) winning: " + (totalHP2W /( numSimulations-wins)));
        System.out.println("--------------------------------");
    }
}


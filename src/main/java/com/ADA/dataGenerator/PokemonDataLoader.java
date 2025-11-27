package com.ADA.dataGenerator;

import com.ADA.model.Breed;
import com.ADA.model.PType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class PokemonDataLoader {

    public Map<Integer, Breed> loadBreeds(String csvFile) {
        Map<Integer, Breed> breeds = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(csvFile));

            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(",");

                if (parts.length >= 5) {
                    Integer id = Integer.parseInt(parts[0].trim());
                    String bName = parts[1].trim();
                    PType pType = parsePType(parts[2].trim());
                    Double attack = Double.parseDouble(parts[3].trim());
                    Integer HP = Integer.parseInt(parts[4].trim());

                    Breed breed = new Breed(id, bName, pType, attack, HP);
                    breeds.put(id, breed);
                }
            }
            System.out.println("Charged breeds: " + breeds.size());

        } catch (IOException e) {
            System.err.println("Error loading breeds: " + e.getMessage());
        }

        return breeds;
    }

    private PType parsePType(String typeStr) {
        try {
            return PType.valueOf(typeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Not valid type: " + typeStr + ", using NORMAL as default");
            return PType.NORMAL;
        }
    }


    public static Map<PType, Double> calculateProbabilities(Map<Integer, Breed> pBreeds) {

        Map<PType, Long> typeCounter= pBreeds.values().stream()
                .collect(Collectors.groupingBy(Breed::getpType, Collectors.counting()));

        int total = pBreeds.size();

        Map<PType, Double> probabilities = new HashMap<>();

        for (Map.Entry<PType, Long> e : typeCounter.entrySet()) {
            double prob = (double) e.getValue() / total;
            probabilities.put(e.getKey(), prob);
        }

        return probabilities;
    }

    // Select n Pokémon breeds random for fighting
    public Breed[] selectRandomBreedsForBattle(Map<Integer, Breed> breeds, int numBreeds) {
        if (breeds.size() < numBreeds) {
            throw new IllegalStateException("Not enough breeds changed");
        }

        List<Integer> breedIds = new ArrayList<>(breeds.keySet());
        Breed[] fighters = new Breed[numBreeds];

        // Select 2 random breeds
        for (int i = 0; i < numBreeds; i++) {
            fighters[i] = breeds.get(breedIds.get(new Random().nextInt(breedIds.size())));
        }

        return fighters;
    }
}

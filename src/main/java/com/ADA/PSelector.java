package com.ADA;

import com.ADA.model.PType;
import com.ADA.model.Pokemon;

import java.util.List;
import java.util.Map;

public class PSelector {

    public Double getExpectedUtility (Pokemon pokemon1, Map<PType, Double> probabilities){
        Double expectedU = 0.0;

        for(PType p : probabilities.keySet()){
            Double effectiveness = pokemon1.getBreed().getpType().getEffectivenessAgainst(p);

            // [effectiveness*damage]*probability
            expectedU = expectedU + effectiveness*pokemon1.getBreed().getAttack()*probabilities.get(p);
        }
        return expectedU;
    }

    public Pokemon getBestPokemon (List<Pokemon> pokemonList, Map<PType, Double> probabilities){

        Double bestEU = 0.0;
        Pokemon bestPokemon = null;
        for(Pokemon p : pokemonList) {
            double currentEU = getExpectedUtility(p, probabilities);
            if (currentEU > bestEU) {
                bestEU = currentEU;
                bestPokemon = p;
            }
        }

        return bestPokemon;
    }
}

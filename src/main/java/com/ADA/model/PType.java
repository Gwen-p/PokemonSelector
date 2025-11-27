package com.ADA.model;

import java.util.EnumMap;
import java.util.Map;

// 18 different types of pokemon
public enum PType {
    NORMAL,
    FIRE,
    WATER,
    ELECTRIC,
    GRASS,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON,
    DARK,
    STEEL,
    FAIRY;

    // NO inicializar aquí — se hará perezosamente.
    private Map<PType, Double> effectiveness;

    // Método de inicialización perezosa
    private void initializeEffectiveness() {
        // crear la estructura una única vez
        effectiveness = new EnumMap<>(PType.class);

        switch (this) {
            case NORMAL:
                set(FIGHTING, 1.0);
                set(ROCK, 0.5);
                set(STEEL, 0.5);
                set(GHOST, 0.0);
                break;
            case FIRE:
                set(GRASS, 2.0);
                set(ICE, 2.0);
                set(BUG, 2.0);
                set(STEEL, 2.0);
                set(FIRE, 0.5);
                set(WATER, 0.5);
                set(ROCK, 0.5);
                set(DRAGON, 0.5);
                break;
            case WATER:
                set(FIRE, 2.0);
                set(GROUND, 2.0);
                set(ROCK, 2.0);
                set(WATER, 0.5);
                set(GRASS, 0.5);
                set(DRAGON, 0.5);
                break;
            case ELECTRIC:
                set(WATER, 2.0);
                set(FLYING, 2.0);
                set(ELECTRIC, 0.5);
                set(GRASS, 0.5);
                set(DRAGON, 0.5);
                set(GROUND, 0.0);
                break;
            case GRASS:
                set(WATER, 2.0);
                set(GROUND, 2.0);
                set(ROCK, 2.0);
                set(FIRE, 0.5);
                set(GRASS, 0.5);
                set(POISON, 0.5);
                set(FLYING, 0.5);
                set(BUG, 0.5);
                set(DRAGON, 0.5);
                set(STEEL, 0.5);
                break;
            case ICE:
                set(GRASS, 2.0);
                set(GROUND, 2.0);
                set(FLYING, 2.0);
                set(DRAGON, 2.0);
                set(FIRE, 0.5);
                set(WATER, 0.5);
                set(ICE, 0.5);
                set(STEEL, 0.5);
                break;
            case FIGHTING:
                set(NORMAL, 2.0);
                set(ICE, 2.0);
                set(ROCK, 2.0);
                set(DARK, 2.0);
                set(STEEL, 2.0);
                set(POISON, 0.5);
                set(FLYING, 0.5);
                set(PSYCHIC, 0.5);
                set(BUG, 0.5);
                set(FAIRY, 0.5);
                set(GHOST, 0.0);
                break;
            case POISON:
                set(GRASS, 2.0);
                set(FAIRY, 2.0);
                set(POISON, 0.5);
                set(GROUND, 0.5);
                set(ROCK, 0.5);
                set(GHOST, 0.5);
                set(STEEL, 0.0);
                break;
            case GROUND:
                set(FIRE, 2.0);
                set(ELECTRIC, 2.0);
                set(POISON, 2.0);
                set(ROCK, 2.0);
                set(STEEL, 2.0);
                set(GRASS, 0.5);
                set(BUG, 0.5);
                set(FLYING, 0.0);
                break;
            case FLYING:
                set(GRASS, 2.0);
                set(FIGHTING, 2.0);
                set(BUG, 2.0);
                set(ELECTRIC, 0.5);
                set(ROCK, 0.5);
                set(STEEL, 0.5);
                break;
            case PSYCHIC:
                set(FIGHTING, 2.0);
                set(POISON, 2.0);
                set(PSYCHIC, 0.5);
                set(STEEL, 0.5);
                set(DARK, 0.0);
                break;
            case BUG:
                set(GRASS, 2.0);
                set(PSYCHIC, 2.0);
                set(DARK, 2.0);
                set(FIRE, 0.5);
                set(FIGHTING, 0.5);
                set(POISON, 0.5);
                set(FLYING, 0.5);
                set(GHOST, 0.5);
                set(STEEL, 0.5);
                set(FAIRY, 0.5);
                break;
            case ROCK:
                set(FIRE, 2.0);
                set(ICE, 2.0);
                set(FLYING, 2.0);
                set(BUG, 2.0);
                set(FIGHTING, 0.5);
                set(GROUND, 0.5);
                set(STEEL, 0.5);
                break;
            case GHOST:
                set(PSYCHIC, 2.0);
                set(GHOST, 2.0);
                set(DARK, 0.5);
                set(NORMAL, 0.0);
                break;
            case DRAGON:
                set(DRAGON, 2.0);
                set(STEEL, 0.5);
                set(FAIRY, 0.0);
                break;
            case DARK:
                set(PSYCHIC, 2.0);
                set(GHOST, 2.0);
                set(FIGHTING, 0.5);
                set(DARK, 0.5);
                set(FAIRY, 0.5);
                break;
            case STEEL:
                set(ICE, 2.0);
                set(ROCK, 2.0);
                set(FAIRY, 2.0);
                set(FIRE, 0.5);
                set(WATER, 0.5);
                set(ELECTRIC, 0.5);
                set(STEEL, 0.5);
                break;
            case FAIRY:
                set(FIGHTING, 2.0);
                set(DRAGON, 2.0);
                set(DARK, 2.0);
                set(FIRE, 0.5);
                set(POISON, 0.5);
                set(STEEL, 0.5);
                break;
        }
    }

    private void set(PType target, double multiplier) {
        // asegúrate de que la estructura esté creada
        if (effectiveness == null) {
            effectiveness = new EnumMap<>(PType.class);
        }
        effectiveness.put(target, multiplier);
    }

    // Usa getEffectiveness() para leer — esto inicializa perezosamente.
    public double getEffectivenessAgainst(PType target) {
        Map<PType, Double> eff = getEffectiveness();
        return eff.getOrDefault(target, 1.0);
    }

    public Map<PType, Double> getEffectiveness() {
        if (effectiveness == null) {
            // crear y poblar
            effectiveness = new EnumMap<>(PType.class);
            initializeEffectiveness();
        }
        return effectiveness;
    }
}

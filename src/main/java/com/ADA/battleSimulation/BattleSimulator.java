package com.ADA.battleSimulation;

import com.ADA.model.Pokemon;

public class BattleSimulator {

    public static BattleResult simulateBattle(Pokemon p1, Pokemon p2) {

        int hp1 = p1.getHP();
        int hp2 = p2.getHP();

        boolean p1Turn = true; // your pokemon attacks first

        while (hp1 > 0 && hp2 > 0) {
            if (p1Turn) {
                double dmg = p1.getBreed().attack(p2.getBreed().getpType());
                hp2 -= dmg;
            } else {
                double dmg = p2.getBreed().attack(p1.getBreed().getpType());
                hp1 -= dmg;
            }
            p1Turn = !p1Turn;
        }

        boolean p1wins = hp1 > 0;
        return new BattleResult(p1wins, Math.max(hp1,0), Math.max(hp2,0));
    }
}


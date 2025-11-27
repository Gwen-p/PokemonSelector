package com.ADA.battleSimulation;

public class BattleResult {
    boolean p1Wins;
    int finalHP1;
    int finalHP2;

    public BattleResult(boolean p1Wins, int finalHP1, int finalHP2) {
        this.p1Wins = p1Wins;
        this.finalHP1 = finalHP1;
        this.finalHP2 = finalHP2;
    }

    public boolean didP1Win() {
        return p1Wins;
    }
}


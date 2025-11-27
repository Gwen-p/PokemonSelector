package com.ADA.model;

public class Breed {

    Integer id;
    String bName;
    PType pType;
    Double attack;
    Integer HP;

    public Breed(Integer id, String bName, PType pType, Double attack, Integer HP ) {
        this.bName = bName;
        this.pType = pType;
        this.attack = attack;
        this.HP = HP;
        this.id = id;
    }

    public Double getAttack() {
        return  attack;
    }

    public Double attack(PType pTp) {
        return pType.getEffectivenessAgainst(pTp)*attack;
    }

    public void setAttack(Double attack) {
        this.attack = attack;
    }

    public Integer getHP() {
        return HP;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public PType getpType() {
        return pType;
    }

    public void setpType(PType pType) {
        this.pType = pType;
    }

    public Integer getId() {
        return id;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }
}

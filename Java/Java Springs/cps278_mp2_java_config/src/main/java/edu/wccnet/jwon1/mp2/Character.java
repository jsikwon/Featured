package edu.wccnet.jwon1.mp2;

public class Character {
    private String name;
    private int health;
    private int strength;
    private FightingPower fightingPower;
    public void useFightingPower() {
        System.out.println(name + " uses " + fightingPower.getFightingPowerDesc());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public FightingPower getFightingPower() {
        return fightingPower;
    }

    public void setFightingPower(FightingPower fightingPower) {
        this.fightingPower = fightingPower;
    }

}

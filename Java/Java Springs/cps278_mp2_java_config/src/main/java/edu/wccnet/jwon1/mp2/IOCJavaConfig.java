package edu.wccnet.jwon1.mp2;

import org.springframework.context.annotation.Bean;

public class IOCJavaConfig {
    @Bean
    public Character character1 () {
        Character character = new Character();
        character.setName("Kirby");
        character.setFightingPower(rockSmashAttack());
        return character;
    }
    @Bean
    public Character character2 () {
        Character character = new Character();
        character.setName("Zelda");
        character.setFightingPower(shadowAttack());
        return character;
    }
    @Bean
    public FightingPower rockSmashAttack() {
        return new RockSmashAttack();
    }
    @Bean
    public FightingPower shadowAttack() {
        return new ShadowAttack();
    }
    @Bean
    public BattleGround battleGroundClass(){
        return new BattleGroundClass();
    }
    @Bean
    public Battle battle() {
        Battle battle = new Battle();
        battle.setBattleGround(battleGroundClass());
        battle.setCharacter1(character1());
        battle.setCharacter2(character2());
        return battle;

    }


}

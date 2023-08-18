package edu.wccnet.jwon1.mp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Battle {
    @Autowired
    private Character character1;
    @Autowired
    private Character character2;
    @Autowired
    private BattleGround battleGround;

    public Character getCharacter1() {
        return character1;
    }

    public void setCharacter1(Character character1) {
        this.character1 = character1;
    }

    public Character getCharacter2() {
        return character2;
    }

    public void setCharacter2(Character character2) {
        this.character2 = character2;
    }

    public BattleGround getBattleGround() {
        return battleGround;
    }

    public void setBattleGround(BattleGround battleGround) {
        this.battleGround = battleGround;
    }
    public void fight() {
        System.out.println(battleGround.getBattleGroundDesc()
                        + character1.getName() + " and "
                        + character2.getName() + " are fighting.");
                character1.useFightingPower();
                character2.useFightingPower();
    }
}

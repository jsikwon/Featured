package edu.wccnet.jwon1.mp2;

import org.springframework.stereotype.Component;

@Component
public class BattleGroundClass implements BattleGround {

    @Override
    public String getBattleGroundDesc() {
        return "On Middle Earth ";
    }
}

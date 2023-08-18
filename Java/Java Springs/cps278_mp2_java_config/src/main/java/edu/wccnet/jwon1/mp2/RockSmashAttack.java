package edu.wccnet.jwon1.mp2;

import org.springframework.stereotype.Component;

@Component
public class RockSmashAttack implements FightingPower{
    @Override
    public String getFightingPowerDesc() {
        return "Rock Smash Attack";
    }
}

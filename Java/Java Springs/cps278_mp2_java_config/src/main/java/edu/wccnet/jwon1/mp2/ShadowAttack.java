package edu.wccnet.jwon1.mp2;

import org.springframework.stereotype.Component;

@Component
public class ShadowAttack implements FightingPower{
    @Override
    public String getFightingPowerDesc() {
        return "Shadow Step Slice";
    }
}

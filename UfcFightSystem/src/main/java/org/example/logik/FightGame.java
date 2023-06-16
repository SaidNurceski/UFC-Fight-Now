package org.example.logik;

import org.example.entity.Fighter;

public class FightGame {
    private Fighter fighter1;
    private Fighter fighter2;

    public FightGame(Fighter fighter1, Fighter fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }
    public boolean fight(){
        int fighter1Power =  fighter1.getRank();
        int fighter2Power = fighter2.getRank();
        return fighter1Power > fighter2Power;
    }
}


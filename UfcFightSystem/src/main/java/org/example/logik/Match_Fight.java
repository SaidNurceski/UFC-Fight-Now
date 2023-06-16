package org.example.logik;

import org.example.entity.Fighter;
import repository.FighterRepository;

public class Match_Fight {

    private Long id;
    public Fighter winner;
    public Fighter fighter1;
    public Fighter fighter2;

    public Match_Fight(Fighter fighter1, Fighter fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    public Match_Fight(Long id, Fighter fighter1, Fighter fighter2) {
        this.id = id;
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long fight(){
        int fighter1Power =  fighter1.getRank();
        int fighter2Power = fighter2.getRank();
        if (fighter1Power == fighter2Power){
            return null;
        }

        if (fighter1Power > fighter2Power){
            winner = fighter1;
            return fighter1.getId();
        }
        winner = fighter2;
        return fighter2.getId();
    }

    @Override
    public String toString() {
        return "Match with the id:" + id + " " + fighter1.getName() + " vs " + fighter2.getName() + " winner is " + winner;
    }
}


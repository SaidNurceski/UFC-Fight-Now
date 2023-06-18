package org.example.logik;

import javafx.scene.control.Alert;
import org.example.entity.Fighter;
import org.example.entity.User;
import repository.FighterRepository;

public class Match_Fight {

    private Long id;
    User userId;
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

    public Match_Fight(User userId, Long id, Fighter fighter1, Fighter fighter2) {
        this.userId = userId;
        this.id = id;
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        winner = fightReturnWithFighter(fighter1, fighter2);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long fight(Fighter fighter1, Fighter fighter2) {
        int fighter1Power = fighter1.getRank();
        int fighter2Power = fighter2.getRank();

        if (fighter1Power > fighter2Power) {
            winner = fighter1;
            System.out.println("Winner is " + winner);
            return fighter1.getId();
        }
        else{
            winner = fighter2;
            System.out.println("Winner is " + winner);
            return fighter2.getId();

        }

    }

    public Fighter fightReturnWithFighter(Fighter fighter1, Fighter fighter2) {
        int fighter1Power = fighter1.getRank();
        int fighter2Power = fighter2.getRank();

        if (fighter1Power > fighter2Power) {
            winner = fighter1;
            System.out.println("Winner is " + winner);
            return fighter1;
        }
        else{
            winner = fighter2;
            System.out.println("Winner is " + winner);
            return fighter2;
        }
    }

    @Override
    public String toString() {
        return "Match: " + fighter1.getName() + " vs " + fighter2.getName() + " winner was " + winner.getName();
    }
}


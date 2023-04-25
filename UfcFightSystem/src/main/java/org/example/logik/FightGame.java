package org.example.logik;

import org.example.entity.Match;
import org.example.entity.Team;

public class FightGame {
    Team team1;
    Team team2;


    Match match;

    public FightGame(Team team1, Team team2, Match match) {
        this.team1 = team1;
        this.team2 = team2;
        this.match = match;
    }

    public Team selectWinner(){

        return null;
    }
}

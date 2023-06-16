package entity;

import org.example.entity.Division;
import org.example.entity.Fighter;
import org.example.logik.Match_Fight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchTest {
    @Test
    void createMatch() {


        Fighter fighter1 = new Fighter("Islam Makachev", 32, Division.LIGHTWEIGHT, 5,"32-7-2" );
        Fighter fighter2 = new Fighter("Jon Jones", 32, Division.Heavyweight, 2,"32-7-2" );

        Match_Fight matchFight = new Match_Fight(fighter1, fighter2);
        matchFight.fight();
        assertEquals(matchFight.fight(), false);



    }
}
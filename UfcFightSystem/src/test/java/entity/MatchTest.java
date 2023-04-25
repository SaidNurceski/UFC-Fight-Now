package entity;

import org.example.entity.Division;
import org.example.entity.Fighter;
import org.example.entity.Match;
import org.example.entity.Team;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchTest {
    @Test
    void createMatch() {
        Set<Fighter> fighters = new HashSet<>();
        Set<Fighter> fighters2 = new HashSet<>();

        Fighter fighter1 = new Fighter("Islam Makachev", 32, Division.Lightweight, 2,"32-7-2" );
        Fighter fighter2 = new Fighter("Jon Jones", 32, Division.Heavyweight, 2,"32-7-2" );


        fighters.add(fighter1);
        fighters2.add(fighter2);

        Match ufc285 = new Match("Champions Fight",new Team("Kings",fighters),new Team("Wolfes",fighters2));
        assertEquals(ufc285.getName(),"Champions Fight");
    }
}
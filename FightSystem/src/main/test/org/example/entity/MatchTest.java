package org.example.entity;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {
    @Test
    void createMatch() {
        Set<Fighter> fighters = new HashSet<>();
        Set<Fighter> fighters2 = new HashSet<>();
        fighters.add(new Fighter(2L,30L,Division.LightHeavyweight,"Islam Makachev"));
        fighters2.add(new Fighter(2L,30L,Division.Heavyweight,"Jon Jones"));

        Match ufc285 = new Match(1L,"Champions Fight",new Team(2L,"Kings",fighters),new Team(1L,"Wolfes",fighters2));
        assertEquals(ufc285.getId(),1L);
        assertEquals(ufc285.getName(),"Champions Fight");
    }
}
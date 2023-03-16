package org.example.entity;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void createTeam() {
        Fighter newFighter = new Fighter(2L,32L,Division.Heavyweight,"Jon Jones");
        Set fighters = new HashSet();
        fighters.add(newFighter);
        Team newTeam = new Team(1L,"Kings",fighters);
        assertEquals(newTeam.getId(),1L);
        assertEquals(newTeam.getName(),"Kings");

    }
}
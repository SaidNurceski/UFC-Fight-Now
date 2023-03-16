package org.example.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FighterTest {

    @Test
    void createFighter() {
        Fighter islam = new Fighter(1L,32L,Division.Lightweight,"Islam Makachev");
        assertEquals(islam.getId(),1L);
        assertEquals(islam.getDivision(),Division.Lightweight);
        assertEquals(islam.getAge(),32L);
        assertEquals(islam.getName(),"Islam Makachev");


    }
}
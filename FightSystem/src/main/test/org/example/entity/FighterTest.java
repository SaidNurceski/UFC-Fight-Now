package org.example.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FighterTest {

    @Test
    void createFighter() {
        Fighter islam = new Fighter(32,Division.Lightweight,"Islam Makachev");

        assertEquals(islam.getDivision(),Division.Lightweight);
        assertEquals(islam.getAge(),32);
        assertEquals(islam.getName(),"Islam Makachev");


    }
}
package entity;

import org.example.entity.Division;
import org.example.entity.Fighter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FighterTest {

    @Test
    void createFighter() {
        Fighter islam = new Fighter(32, Division.Lightweight,"Islam Makachev");

        assertEquals(islam.getDivision(),Division.Lightweight);
        assertEquals(islam.getAge(),32);
        assertEquals(islam.getName(),"Islam Makachev");


    }
}
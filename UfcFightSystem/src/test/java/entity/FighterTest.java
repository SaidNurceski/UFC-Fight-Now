package entity;

import org.example.entity.Division;
import org.example.entity.Fighter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FighterTest {

    @Test
    void createFighter() {
        Fighter islam = new Fighter("Islam Makachev", 32, Division.LIGHTHEAYWEIGHT, 2,"32-7-2" );

        assertEquals(islam.getDivision(),Division.LIGHTWEIGHT);
        assertEquals(islam.getAge(),32);
        assertEquals(islam.getName(),"Islam Makachev");


    }
}
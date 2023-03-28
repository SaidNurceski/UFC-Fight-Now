package org.example.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FighterJSONTest {
    @Test
    void readJson() {
        Fighter[] fighters = FighterJSON.readFromJSON();
        System.out.print(fighters);
    }
}
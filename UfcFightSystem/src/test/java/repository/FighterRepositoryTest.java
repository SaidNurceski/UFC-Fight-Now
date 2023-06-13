package repository;

import org.example.entity.Fighter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class FighterRepositoryTest {


    @Test
    void save() {

    }

    @Test
    void insert() {

    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
        FighterRepository repo = new FighterRepository();
        List<Fighter> listOfAllFighters = repo.findAll();
        assertEquals(10, listOfAllFighters.size());
    }

    @Test
    void update() {
    }
}
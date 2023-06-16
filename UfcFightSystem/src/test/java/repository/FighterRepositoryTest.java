package repository;

import org.example.entity.Fighter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class FighterRepositoryTest {


    @Test
    void save() {
        FighterRepository repo = new FighterRepository();
        Fighter fighter = new Fighter(2L,"McGregor","Lightweight", 32,"32-7-2", 2 );
        repo.save(fighter);

    }

    @Test
    void findById() {
        FighterRepository repo = new FighterRepository();
        Fighter fighter = repo.findFighterById(1);
        System.out.println(fighter);
    }

    @Test
    void insert() {
        FighterRepository repo = new FighterRepository();
        Fighter fighter = new Fighter(2L,"McGregor","Lightweight", 32,"32-7-2", 2 );
        repo.insert(fighter);

    }

    @Test
    void delete() {
        FighterRepository repo = new FighterRepository();
        repo.delete(1);
    }

    @Test
    void findAll() {
        FighterRepository repo = new FighterRepository();
        List<Fighter> listOfAllFighters = repo.getAll();
        System.out.println(listOfAllFighters);
        assertEquals(10, listOfAllFighters.size());
    }

    @Test
    void update() {
        FighterRepository repo = new FighterRepository();
        Fighter fighter = new Fighter(2L,"ANYAD","HEAVYWEIGHT", 32,"32-7-2", 2 );
        repo.update(fighter);
    }
}
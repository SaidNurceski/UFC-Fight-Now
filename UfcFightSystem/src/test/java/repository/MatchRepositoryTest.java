package repository;

import org.example.logik.Match_Fight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchRepositoryTest {

    @Test
    void save() {
    }

    @Test
    void insert() {
        FighterRepository fighterRepository = new FighterRepository();
        MatchRepository repo = new MatchRepository();
        Match_Fight match = new Match_Fight(fighterRepository.findFighterById(1l),fighterRepository.findFighterById(3l));
        repo.insert(match);
    }

    @Test
    void delete() {
        MatchRepository repo = new MatchRepository();
        repo.delete(1);


    }

    @Test
    void getAll() {
        MatchRepository repo = new MatchRepository();
        System.out.println(repo.getAll());
    }

    @Test
    void update() {
    }
}
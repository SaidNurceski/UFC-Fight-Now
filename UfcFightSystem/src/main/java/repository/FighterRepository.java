package repository;

import org.example.entity.Fighter;

import java.util.List;

public class FighterRepository implements Persistent<Fighter>{
    private Object Database;
    @Override
    public void save(Fighter fighter) {
        if (fighter.getId() == null) {
            insert(fighter);
        } else {
            update(fighter);
        }
    }

    @Override
    public void insert(Fighter entity) {

    }

    @Override
    public void delete(Fighter entity) {

    }

    @Override
    public List<Fighter> findAll() {
        return null;
    }

    @Override
    public Fighter findById(Fighter entity) {
        return null;
    }

    @Override
    public void update(Fighter entity) {

    }
}

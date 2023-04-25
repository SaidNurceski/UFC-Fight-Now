package repository;

import org.example.entity.Fighter;

import java.sql.*;
import java.util.List;

public class FighterRepository implements Persistent<Fighter>{
    private Connection connection = DataBase.establishConnection();
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
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Fighter (NAME, AGE, Record,Rank,Division) VALUES (?, ?, ?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAge());
            preparedStatement.setString(3, entity.getRecord());
            preparedStatement.setString(4, entity.getRecord());


            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
            }
            preparedStatement.close();


        }
        catch(SQLException s){


        }

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

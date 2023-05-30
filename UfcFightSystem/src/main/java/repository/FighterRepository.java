package repository;

import org.example.entity.Division;
import org.example.entity.Fighter;

import java.sql.*;
import java.util.ArrayList;
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
            preparedStatement.setInt(3, entity.getRank());
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
    public void delete(int id) {
        try{
            Connection connection = DataBase.establishConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Fighter WHERE id =? ");
            preparedStatement.setLong(1, id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Fighter> findAll() {
        //NAME, AGE, Record,Rank,Division
        try {
            Connection connection = DataBase.establishConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    " SELECT * from Fighter");
            List<Fighter> fighters = new ArrayList<>();

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("F_ID");
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");
                String record = resultSet.getString("RECORD");
                int rank = resultSet.getInt("RANK");
                String division = resultSet.getString("DIVISION");
                fighters.add(new Fighter(name,age,Division.valueOf(division),rank,record));

            }
            return fighters;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       DataBase.closeConnection();
        return null;
    }
    @Override
    public void update(Fighter entity) {
        try {
            //NAME, AGE, Record,Rank,Division
            Connection connection = DataBase.establishConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Fighter SET NAME = ?, AGE = ?, Record = ?, Rank =?,Division =? WHERE ID = ?");
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAge());
            preparedStatement.setString(3, entity.getRecord());
            preparedStatement.setInt(4, entity.getRank());
            preparedStatement.setString(5, entity.getDivision().toString());

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.printf("%d rows affected.%n", rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

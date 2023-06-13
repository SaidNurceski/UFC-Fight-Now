package repository;

import org.example.entity.Division;
import org.example.entity.Fighter;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FighterRepository implements Persistent<Fighter>{
    private static DataSource dataSource;

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
        try (Connection connection = Database.establishConnection()) {
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
            s.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try{
            Connection connection = Database.establishConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Fighter WHERE F_ID =? ");
            preparedStatement.setLong(1, id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Fighter> findAll() {
        List<Fighter> fighters = new ArrayList<>();

        //NAME, AGE, Record,Rank,Division
        try (Connection connection = Database.establishConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    " SELECT * from Fighter");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fighters;
    }
    @Override
    public void update(Fighter entity) {
        try {
            //NAME, AGE, Record,Rank,Division
            Connection connection = Database.establishConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Fighter SET NAME = ?, AGE = ?, Record = ?, Rank =?,Division =? WHERE F_ID = ?");
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

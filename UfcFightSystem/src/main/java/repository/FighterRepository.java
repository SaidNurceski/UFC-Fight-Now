package repository;

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
            preparedStatement.setString(3, entity.getRecord());
            preparedStatement.setInt(4, entity.getRank());
            preparedStatement.setString(5, entity.getDivisionName());


            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
            }
            preparedStatement.close();
            System.out.printf(rowsAffected + " rows affected");


        }
        catch(SQLException s){
            System.out.println(s.toString());


        }

    }

    @Override
    public void delete(int id) {
        try{
            Connection connection = DataBase.establishConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Fighter WHERE F_ID =? ");
            preparedStatement.setInt(1, id);
            System.out.println("Deleted Fighter with id: " + id);

            if (preparedStatement.executeUpdate() == 0) {
                throw new SQLException("Delete from answer_option failed, no rows affected");
            }

        } catch (SQLException e) {
            System.out.println("Error not existing with the Fighter with id: " + id);
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Fighter> getAll() {
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
                String  record = resultSet.getString("RECORD");
                int rank = resultSet.getInt("RANK");
                String division = resultSet.getString("DIVISION");
                String nickname = resultSet.getString("NICKNAME");

                fighters.add(new Fighter(id,name,division,age,record,rank,nickname));

            }
            return fighters;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataBase.closeConnection();
        return null;
    }

    public Fighter findFighterById(long id){
        try{
            Connection connection = DataBase.establishConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Fighter WHERE F_ID =? ");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("Fighter ID: " + resultSet.getInt("F_ID"));
                System.out.println("Fighter Name: " + resultSet.getString("NAME"));
                System.out.println("Fighter Age: " + resultSet.getInt("AGE"));
                System.out.println("Fighter Record: " + resultSet.getString("Record"));
                System.out.println("Fighter Rank: " + resultSet.getInt("Rank"));
                System.out.println("Fighter Division: " + resultSet.getString("Division"));
                return new Fighter(resultSet.getLong("F_ID"),resultSet.getString("NAME"),resultSet.getString("Division"),resultSet.getInt("AGE"),resultSet.getString("Record"),resultSet.getInt("Rank"),resultSet.getString("Nickname"));
            }
        }
        catch(SQLException s){
            System.out.println(s.toString());
        }
        return null;

    }
    @Override
    public void update(Fighter entity) {
        try {
            //NAME, AGE, Record,Rank,Division
            Connection connection = DataBase.establishConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Fighter SET NAME = ?, AGE = ?, Record = ?, Rank = ?,Division = ? WHERE F_ID = ?");
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAge());
            preparedStatement.setString(3, entity.getRecord());
            preparedStatement.setInt(4, entity.getRank());
            preparedStatement.setString(5, entity.getDivisionName());
            preparedStatement.setLong(6, entity.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.printf("%d rows affected.%n", rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

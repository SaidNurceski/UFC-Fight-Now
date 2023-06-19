package repository;

import org.example.entity.User;
import org.example.logik.Match_Fight;
import org.example.view.controller.LoginController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatchRepository implements Persistent<Match_Fight> {
    private Connection connection = DataBase.establishConnection();



    @Override
    public void save(Match_Fight entity) {
        if (entity.getId() == null) {
            insert(entity);
        } else {
            update(entity);
        }

    }

    @Override
    public void insert(Match_Fight entity) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO F_MATCH (U_ID, WINNER, F_IDA, F_IDB) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, LoginController.currentUser.getId());
            preparedStatement.setLong(2, entity.fight(entity.fighter1, entity.fighter2));
            preparedStatement.setLong(3, entity.fighter1.getId());
            preparedStatement.setLong(4, entity.fighter2.getId());

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
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM F_MATCH WHERE M_ID =? ");
            preparedStatement.setInt(1, id);
            System.out.println("Deleted Match with id: " + id);

            if (preparedStatement.executeUpdate() == 0) {
                throw new SQLException("Delete from answer_option failed, no rows affected");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Match_Fight> getAll() {
        try {
            Connection connection = DataBase.establishConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    " SELECT * from F_MATCH");
            List<Match_Fight> history = new ArrayList<>();

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("M_ID");
                int idOfTheFighter1 = resultSet.getInt("F_IDA");
                int idOfTheFighter2 = resultSet.getInt("F_IDB");


                history.add(new Match_Fight(id,
                        new FighterRepository().findFighterById(idOfTheFighter1),
                        new FighterRepository().findFighterById(idOfTheFighter2)));
            }
            return history;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataBase.closeConnection();
        return null;
    }


    @Override
    public void update(Match_Fight entity) {
        try{
            User user = LoginController.currentUser;
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE F_MATCH SET F_IDA = ?, F_IDB = ?, WINNER = ?, U_ID = ? WHERE M_ID = ?");
            preparedStatement.setLong(1, entity.fighter1.getId());
            preparedStatement.setLong(2, entity.fighter2.getId());
            preparedStatement.setLong(3, entity.fight(entity.fighter1, entity.fighter2));
            preparedStatement.setLong(4, user.getId());
            preparedStatement.setLong(5, entity.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
            }
            preparedStatement.close();
            System.out.printf(rowsAffected + " rows affected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Match_Fight> getHistoryById(){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM F_MATCH WHERE U_ID = ?");
            preparedStatement.setLong(1, LoginController.currentUser.getId());
            List<Match_Fight> history = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                long id = resultSet.getLong("M_ID");
                int idOfTheFighter1 = resultSet.getInt("F_IDA");
                int idOfTheFighter2 = resultSet.getInt("F_IDB");
                long userId = LoginController.currentUser.getId();

                history.add(new Match_Fight(new UserRepository().getById(userId),
                        id,
                        new FighterRepository().findFighterById(idOfTheFighter1),
                        new FighterRepository().findFighterById(idOfTheFighter2)));
            }

            return history;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearHistory() {
try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM F_MATCH");

            if (preparedStatement.executeUpdate() == 0) {
                throw new SQLException("Delete from history failed, no rows affected");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

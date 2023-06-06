package repository;

import org.example.entity.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static DataSource dataSource;

    public void insert(User user) {
        throwExceptionOnInvalidUser(user);
        try (Connection connection = Database.getInstance().getConnection()) {
            String sql = "INSERT INTO U_USER (U_FIRST_NAME, U_LAST_NAME, U_PASSWORD, U_EMAIL, U_AGE) VALUES (?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            statement.setInt(5, user.getAge());


            if (statement.executeUpdate() == 0) {
                throw new SQLException("Update of MM_LOCATION failed, no rows affected");
            }


            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    user.setId(keys.getLong(1));
                } else {
                    throw new SQLException("Insert into MM_LOCATION failed, no ID obtained");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User user) {
        throwExceptionOnInvalidUser(user);
        try (Connection connection = Database.getInstance().getConnection()) {
            String sql = "UPDATE U_USER SET " +
                    "U_FIRST_NAME=?, " +
                    "U_LAST_NAME=?, " +
                    "U_EMAIL=?, " +
                    "U_AGE=?, " +
                    "U_PASSWORD=? " +
                    "WHERE U_ID=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getAge());
            statement.setString(5, user.getPassword());
            statement.setLong(6, user.getId());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Update of MM_LOCATION failed, no rows affected");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID must not be negative");
        }
        try (Connection connection = Database.getInstance().getConnection()) {
            String sql = "DELETE FROM U_USER WHERE U_ID=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Delete from MM_LOCATION failed, no rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll() {
        List<User> userList = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            String sql = "SELECT * FROM U_USER";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Long id = result.getLong("U_ID");
                String firstName = result.getString("U_FIRST_NAME");
                String lastName = result.getString("U_LAST_NAME");
                String password = result.getString("U_PASSWORD");
                String email = result.getString("U_EMAIL");
                Integer age = result.getInt("U_AGE");
                userList.add(new User(id, firstName, lastName, password, email, age));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public boolean isUserExisting(String email, String pwd){
        try (Connection connection = Database.getInstance().getConnection()) {
            String sql = "SELECT count(*) from U_USER WHERE U_PASSWORD = ? AND U_EMAIL = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pwd);
            statement.setString(2, email);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static User getById(long id){
        if (id < 0) {
            throw new IllegalArgumentException("ID must not be negative");
        }
        try (Connection connection = Database.getInstance().getConnection()) {
            String sql = "SELECT * FROM U_USER WHERE U_ID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                if(id == result.getInt("U_ID"))
                    return new User(result.getLong("U_ID"),
                            result.getString("U_FIRST_NAME"),
                            result.getString("U_LAST_NAME"),
                            result.getString("U_PASSWORD"),
                            result.getString("U_EMAIL"),
                            result.getInt("U_AGE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void throwExceptionOnInvalidUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
    }
}

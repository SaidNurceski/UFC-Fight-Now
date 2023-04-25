package repository;


import repository.exceptions.DBConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public static Connection establishConnection() {
        System.out.println("= Opening connection. =");
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:derby:db");
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DBConnectionException(e);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (Exception ex) {

        }
    }


}

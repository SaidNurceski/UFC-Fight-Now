package repository;


import repository.exceptions.DBConnectionException;
import org.apache.derby.jdbc.ClientDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public static Connection establishConnection() {
        System.out.println("= Opening connection. =");
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:derby:db2");
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

package mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    String driver;
    String dbName;
    String connectionURL;
    String username;
    String password;

    public DatabaseConnection() {
        this.connectionURL = "jdbc:mysql://localhost:3306/";
        this.dbName = "atelier";
        this.username = "admin";
        this.password = "admin";
    }

    public Connection getConnection() throws Exception {
        Connection connection = DriverManager.getConnection(connectionURL + dbName, username, password);

        return connection;
    }
}
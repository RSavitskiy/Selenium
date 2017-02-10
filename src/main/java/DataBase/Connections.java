package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

    private static final String url = "jdbc:mysql://localhost:3306/testdatabase?autoReconnect=true&useSSL=false";
    static final String username = "root";
    private static final String password = "root";

    private Connection connection;

    public Connections() throws SQLException {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

}

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactory {

    private static Connection connection;
    private static final Dotenv dotenv = Dotenv.load(); 
    private static final String CONNECTION_STRING = dotenv.get("DB_CONNECTION_STRING");

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(CONNECTION_STRING);
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão com o banco encerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
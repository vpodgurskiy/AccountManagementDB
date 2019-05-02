package controller;

import java.sql.*;
import java.util.Properties;

public class DataBaseConnector {

    private Connection connection;

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        return resultSet;

    }

    public int executeUpdateQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeUpdate(query);
    }

    public DataBaseConnector createDBConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost/postgres";
        String login = "orsi";
        String password = "Qq123456";
        connection = ConnectToDB(url, login, password);

        return this;
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    private Connection ConnectToDB(String url, String login, String password) throws SQLException {

        try{
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        Properties props = new Properties();
        props.setProperty("user", login);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection(url, props);

        return connection;
    }
}

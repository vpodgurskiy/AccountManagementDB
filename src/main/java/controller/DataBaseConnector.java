package controller;

import java.sql.*;
import java.util.Properties;

public class DataBaseConnector {

    public Connection getConnection() {
        return connection;
    }

    private Connection connection;

    public Connection ConnectToDB(String url, String login, String password) throws SQLException {

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

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = this.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        return resultSet;

    }

    public DataBaseConnector createDBConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost/postgres";
        String login = "orsi";
        String password = "Qq123456";
        this.connection = ConnectToDB(url, login, password);

        return this;
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}

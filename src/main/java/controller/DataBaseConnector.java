package controller;

import java.sql.*;
import java.util.Properties;

public class DataBaseConnector {

    public Connection ConnectToDB() throws SQLException {

        try{
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://localhost/postgres";
        String login = "postgres";
        String password = "123456";

        Properties props = new Properties();
        props.setProperty("user", login);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection(url, props);

        return connection;
    }
}

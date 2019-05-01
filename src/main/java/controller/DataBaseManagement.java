package controller;

import model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseManagement {

    public Account insertInDB(Account account) throws SQLException {
        final String query = "";
        DataBaseConnector dataBaseConnector = new DataBaseConnector();
        ResultSet resultSet = dataBaseConnector.createDBConnection().executeQuery(query);

        return new Account();
    }

    public boolean deleteFromDB(String login) {
        return false;
    }

    public Account updateInDB(String login, String surname) {
        return null;
    }

    public Account selectFromDB(String login) throws SQLException {
        final String query = String.format("SELECT * FROM ACTIVEDIRECTORY WHERE LOGIN = '%s';", login);
        DataBaseConnector dataBaseConnector = new DataBaseConnector();
        ResultSet resultSet = dataBaseConnector.createDBConnection().executeQuery(query);
        resultSet.next();
        String loginDB = resultSet.getString("login");
        String nameDB = resultSet.getString("name");
        String surenameDB = resultSet.getString("surname");

        dataBaseConnector.closeConnection();

        return new Account(loginDB, nameDB, surenameDB);
    }
}

package controller;

import model.Account;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseManagement {

    @Transactional
    public Account insertInDB(String login, String name, String surname) throws SQLException {
        final String query = String.format("INSERT INTO activedirectory (login, name, surname) VALUES ('%s', '%s', '%s');", login, name, surname);
        return getModefideAccountFromDB(query, login);
    }

    @Transactional
    public Account deleteFromDB(String login) throws SQLException {
        final String query = String.format("DELETE FROM activedirectory WHERE login = '%s';", login);
        return getModefideAccountFromDB(query, login);
    }

    @Transactional
    public Account updateInDB(String login, String surname) throws SQLException {
        final String query = String.format("UPDATE activedirectory SET surname = '%s' WHERE login = '%s';", surname, login);
        return getModefideAccountFromDB(query, login);
    }

    @Transactional
    public Account selectFromDB(String login) throws SQLException {
        final String query = String.format("SELECT * FROM ACTIVEDIRECTORY WHERE LOGIN = '%s';", login);
        DataBaseConnector dataBaseConnector = new DataBaseConnector();
        ResultSet resultSet = dataBaseConnector.createDBConnection().executeQuery(query);
        String loginDB = "";
        String nameDB = "";
        String surnameDB = "";
        if (resultSet.next()) {
            loginDB = resultSet.getString("login");
            nameDB = resultSet.getString("name");
            surnameDB = resultSet.getString("surname");
        }
        dataBaseConnector.closeConnection();
        return new Account(loginDB, nameDB, surnameDB);
    }

    @Transactional
    public Account getModefideAccountFromDB(final String query, final String login) throws SQLException {
        Account account = new Account();
        DataBaseConnector dataBaseConnector = new DataBaseConnector();
        int result = dataBaseConnector.createDBConnection().executeUpdateQuery(query);
        if (result == 1) {
            account = selectFromDB(login);
        }
        dataBaseConnector.closeConnection();

        return account;
    }
}

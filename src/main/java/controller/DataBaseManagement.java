package controller;

import model.Account;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Transactional
public class DataBaseManagement {

    public Account insertInDB(String login, String name, String surname) throws SQLException {
        final String queryInsert = String.format("INSERT INTO activedirectory (login, name, surname) VALUES ('%s', '%s', '%s');", login, name, surname);
        DataBaseConnector dataBaseConnector = new DataBaseConnector();
        Connection connection = dataBaseConnector.ConnectToDB();
        Statement stmt = connection.createStatement();
        int countUpdated = stmt.executeUpdate(queryInsert);
        final String querySelect = String.format("SELECT * FROM ACTIVEDIRECTORY WHERE LOGIN = '%s';", login);
        Account account = getModifiedAccountFromDB(querySelect, login, stmt);
        stmt.close();
        connection.close();
        return account;
    }

    public Account deleteFromDB(String login) throws SQLException {
        final String queryDelete = String.format("DELETE FROM activedirectory WHERE login = '%s';", login);
        DataBaseConnector dataBaseConnector = new DataBaseConnector();
        Connection connection = dataBaseConnector.ConnectToDB();
        Statement stmt = connection.createStatement();
        int countUpdated = stmt.executeUpdate(queryDelete);
        final String querySelect = String.format("SELECT * FROM ACTIVEDIRECTORY WHERE LOGIN = '%s';", login);
        Account account = getModifiedAccountFromDB(querySelect, login, stmt);
        stmt.close();
        connection.close();
        return account;
    }

    public Account updateInDB(String login, String surname) throws SQLException {
        final String queryUpdate = String.format("UPDATE activedirectory SET surname = '%s' WHERE login = '%s';", surname, login);
        DataBaseConnector dataBaseConnector = new DataBaseConnector();
        Connection connection = dataBaseConnector.ConnectToDB();
        Statement stmt = connection.createStatement();
        int countUpdated = stmt.executeUpdate(queryUpdate);
        final String querySelect = String.format("SELECT * FROM ACTIVEDIRECTORY WHERE LOGIN = '%s';", login);
        Account account = getModifiedAccountFromDB(querySelect, login, stmt);
        stmt.close();
        connection.close();
        return account;
    }

    public Account selectFromDB(String login) throws SQLException {
        final String query = String.format("SELECT * FROM ACTIVEDIRECTORY WHERE LOGIN = '%s';", login);
        DataBaseConnector dataBaseConnector = new DataBaseConnector();
        Connection connection = dataBaseConnector.ConnectToDB();
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        String loginDB = "";
        String nameDB = "";
        String surnameDB = "";
        if (resultSet.next()) {
            loginDB = resultSet.getString("login");
            nameDB = resultSet.getString("name");
            surnameDB = resultSet.getString("surname");
        }
        resultSet.close();
        stmt.close();
        connection.close();
        return new Account(loginDB, nameDB, surnameDB);
    }


    private Account getModifiedAccountFromDB(final String query, final String login, Statement stmt) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(query);
        String loginDB = "";
        String nameDB = "";
        String surnameDB = "";
        while (resultSet.next()) {
            loginDB = resultSet.getString("login");
            nameDB = resultSet.getString("name");
            surnameDB = resultSet.getString("surname");
        }
        resultSet.close();
        return new Account(loginDB, nameDB, surnameDB);
    }
}

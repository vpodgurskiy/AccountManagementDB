package controller;

import model.Account;
import org.junit.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

public class DataBaseManagementTest {

//    @Test
//    public void insertInDB() throws SQLException {
//        Account account = new Account("testLogin", "testName", "testSurname");
//        DataBaseManagement dataBaseManagement = new DataBaseManagement();
//        Account accountFromDB = dataBaseManagement.insertInDB(account);
//        String login = accountFromDB.getLogin();
//        String name = accountFromDB.getName();
//        String surname = accountFromDB.getSurname();
//
//        assertThat(accountFromDB.isEmpty()).isFalse();
//
//        assertThat("testLogin").isEqualToIgnoringCase(login);
//        assertThat("testName").isEqualToIgnoringCase(name);
//        assertThat("testSurname").isEqualToIgnoringCase(surname);
//    }
//
//    @Test
//    public void deleteFromDB() throws SQLException {
//        DataBaseManagement dataBaseManagement = new DataBaseManagement();
//        boolean accountDeleted = dataBaseManagement.deleteFromDB("testLogin");
//        Account accountFromDB = dataBaseManagement.selectFromDB("testLogin");
//
//        assertThat(accountDeleted).isTrue();
//        assertThat(accountFromDB.isEmpty()).isTrue();
//    }
//
//    @Test
//    public void updateInDB() {
//        DataBaseManagement dataBaseManagement = new DataBaseManagement();
//        Account newAccount = dataBaseManagement.updateInDB("testLogin", "newTestSurname");
//
//        assertThat("newTestSurname").isEqualToIgnoringCase(newAccount.getSurname());
//    }
//
    @Test
    public void selectFromDB() throws SQLException {
        DataBaseManagement dataBaseManagement = new DataBaseManagement();
        Account accountFromDB = dataBaseManagement.selectFromDB("testLogin");

        assertThat(accountFromDB.isEmpty()).isFalse();

        assertThat("testLogin").isEqualToIgnoringCase(accountFromDB.getLogin());
    }
}
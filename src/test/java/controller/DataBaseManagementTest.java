package controller;

import model.Account;
import org.junit.Test;

import javax.transaction.Transactional;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@Transactional
public class DataBaseManagementTest {

//    @Test
//    public void insertInDB() throws SQLException {
//        DataBaseManagement dataBaseManagement = new DataBaseManagement();
//        Account accountFromDB = dataBaseManagement.insertInDB("testLogin", "testName", "testSurname");
//        String login = accountFromDB.getLogin();
//        String name = accountFromDB.getName();
//        String surname = accountFromDB.getSurname();
//
//        assertThat(accountFromDB.isEmpty()).isFalse();
//
//        assertThat("testLogin").isEqualToIgnoringCase(login);
//        assertThat("testName").isEqualToIgnoringCase(name);
//        assertThat("testSurname").isEqualToIgnoringCase(surname);
//
//        dataBaseManagement.deleteFromDB("testLogin");
//    }
//
//    @Test
//    public void selectFromDB() throws SQLException {
//        DataBaseManagement dataBaseManagement = new DataBaseManagement();
//        dataBaseManagement.insertInDB("testLogin", "testName", "testSurname");
//        Account accountFromDB = dataBaseManagement.selectFromDB("testLogin");
//
//        assertThat(accountFromDB.isEmpty()).isFalse();
//
//        assertThat("testLogin").isEqualToIgnoringCase(accountFromDB.getLogin());
//
//        dataBaseManagement.deleteFromDB("testLogin");
//    }
//
//    @Test
//    public void updateInDB() throws SQLException {
//        DataBaseManagement dataBaseManagement = new DataBaseManagement();
//        dataBaseManagement.insertInDB("testLogin", "testName", "testSurname");
//        Account newAccount = dataBaseManagement.updateInDB("testLogin", "newTestSurname");
//
//        assertThat("newTestSurname").isEqualToIgnoringCase(newAccount.getSurname());
//
//        dataBaseManagement.deleteFromDB("testLogin");
//    }
//
//    @Test
//    public void deleteFromDB() throws SQLException {
//        DataBaseManagement dataBaseManagement = new DataBaseManagement();
//        dataBaseManagement.insertInDB("testLogin", "testName", "testSurname");
//        Account accountDeleted = dataBaseManagement.deleteFromDB("testLogin");
//
//        assertThat(accountDeleted.isEmpty()).isTrue();
//    }
}
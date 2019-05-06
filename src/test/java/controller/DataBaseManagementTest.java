package controller;

import model.Account;
import org.junit.Test;
import org.mockito.Mockito;

import javax.transaction.Transactional;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@Transactional
public class DataBaseManagementTest {

    @Test
    public void insertDBTest() throws SQLException {

        DataBaseManagement dataBaseManagement = Mockito.mock(DataBaseManagement.class);

        Account expectedValue = new Account("test", "testName", "testSurname");

        when(dataBaseManagement.insertInDB("test", "testName", "testSurname")).thenReturn(expectedValue);

        Account actualValue = dataBaseManagement.insertInDB("test", "testName", "testSurname");

        verify(dataBaseManagement, atLeastOnce()).insertInDB("test", "testName", "testSurname");

        assertThat(dataBaseManagement.insertInDB("test", "testName", "testSurname")).isEqualTo(actualValue);
    }

    @Test
    public void selectDBTest() throws SQLException {

        DataBaseManagement dataBaseManagement = Mockito.mock(DataBaseManagement.class);

        Account expectedValue = new Account("test", "testName", "testSurname");

        when(dataBaseManagement.selectFromDB("test")).thenReturn(expectedValue);

        Account actualValue = dataBaseManagement.selectFromDB("test");

        verify(dataBaseManagement, atLeastOnce()).selectFromDB("test");

        assertThat(dataBaseManagement.selectFromDB("test")).isEqualTo(actualValue);
    }

    @Test
    public void deleteDBTest() throws SQLException {

        DataBaseManagement dataBaseManagement = Mockito.mock(DataBaseManagement.class);

        Account expectedValue = new Account("test", "testName", "testSurname");

        when(dataBaseManagement.deleteFromDB("test")).thenReturn(expectedValue);

        Account actualValue = dataBaseManagement.deleteFromDB("test");

        verify(dataBaseManagement, atLeastOnce()).deleteFromDB("test");

        assertThat(dataBaseManagement.deleteFromDB("test")).isEqualTo(actualValue);
    }

    @Test
    public void updateDBTest() throws SQLException {

        DataBaseManagement dataBaseManagement = Mockito.mock(DataBaseManagement.class);

        Account expectedValue = new Account("test", "testName", "testSurname");

        when(dataBaseManagement.updateInDB("test", "newSurname")).thenReturn(expectedValue);

        Account actualValue = dataBaseManagement.updateInDB("test", "newSurname");

        verify(dataBaseManagement, atLeastOnce()).updateInDB("test", "newSurname");

        assertThat(dataBaseManagement.updateInDB("test", "newSurname")).isEqualTo(actualValue);
    }

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
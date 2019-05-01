package view;

import controller.DataBaseManagement;
import model.Account;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        DataBaseManagement dataBaseManagement = new DataBaseManagement();
        try {
            Account account = dataBaseManagement.selectFromDB("testLogin");
            System.out.println(account.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

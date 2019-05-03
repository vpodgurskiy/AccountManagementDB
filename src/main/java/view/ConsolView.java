package view;

import controller.DataBaseManagement;
import model.Account;
import static model.RowStatusDB.getRowStatus;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsolView {

    public boolean ShowMenu() {
        System.out.println("\n");
        System.out.println("---MENU---");
        System.out.println("1) INSERT");
        System.out.println("2) SELECT");
        System.out.println("3) UPDATE");
        System.out.println("4) DELETE");
        System.out.println("5) HELP");
        System.out.println("6) QUIT");

        int item = askMenuItem();

        if (item == 5) {
            showHelp();
            return true;
        }

        if (item >= 6 || item < 1) return false;

        DataBaseManagement dataBaseManagement = new DataBaseManagement();
        Account account;
        switch (getRowStatus(item)) {
            case INSERT:
                account = insert(dataBaseManagement);
                break;
            case SELECT:
                account = select(dataBaseManagement);
                break;
            case UPDATE:
                account = update(dataBaseManagement);
                break;
            case DELETE:
                account = delete(dataBaseManagement);
                break;
            default:
                return false;
        }

        System.out.println(account.toString());

        return true;
    }

    private void showHelp() {

    }

    private Account select(DataBaseManagement dataBaseManagement) {
        String login = askLogin();
        try {
            return dataBaseManagement.selectFromDB(login);
        } catch (SQLException e) {
            System.out.println(String.format("Не удалось получить данные из базы, по причине: %s", e.getMessage()));
        }
        return new Account();
    }

    private Account delete(DataBaseManagement dataBaseManagement) {
        String login = askLogin();
        try {
            return dataBaseManagement.deleteFromDB(login);
        } catch (SQLException e) {
            System.out.println(String.format("Не удалось удалить данные из базы, по причине: %s", e.getMessage()));
        }
        return new Account();
    }

    private Account update(DataBaseManagement dataBaseManagement) {
        String login = askLogin();
        String newSurnameValue = askNewSurnameValue();
        try {
            return dataBaseManagement.updateInDB(login, newSurnameValue);
        } catch (SQLException e) {
            System.out.println(String.format("Не удалось изменить данные в базе, по причине: %s", e.getMessage()));
        }
        return new Account();
    }

    private Account insert(DataBaseManagement dataBaseManagement) {
        String login = askLogin();
        String name = askName();
        String surname = askSurname();
        try {
            return dataBaseManagement.insertInDB(login, name, surname);
        } catch (SQLException e) {
            System.out.println(String.format("Не удалось записать данные в базу, по причине: %s", e.getMessage()));
        }
        return new Account();
    }

    private int askMenuItem() {
        System.out.print("\nPlease input menu item :_");
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            return askMenuItem();
        }
    }

    private String askLogin() {
        System.out.print("Input login :_");
        final Scanner in = new Scanner(System.in);
        try {
            return in.next();
        } catch (final InputMismatchException e) {
            return askLogin();
        }
    }

    private String askName() {
        System.out.print("Input name :_");
        final Scanner in = new Scanner(System.in);
        try {
            return in.next();
        } catch (final InputMismatchException e) {
            return askName();
        }
    }

    private String askSurname() {
        System.out.print("Input surname :_");
        final Scanner in = new Scanner(System.in);
        try {
            return in.next();
        } catch (final InputMismatchException e) {
            return askSurname();
        }
    }

    private String askNewSurnameValue() {
        System.out.print("Input new surname value :_");
        final Scanner in = new Scanner(System.in);
        try {
            return in.next();
        } catch (final InputMismatchException e) {
            return askNewSurnameValue();
        }
    }
}

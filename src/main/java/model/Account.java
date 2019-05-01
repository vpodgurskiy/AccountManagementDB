package model;

public class Account {

    private String login, name, surname;

    public Account() {
        new Account("", "", "");
    }

    public Account(String login, String name, String surname) {
        this.login = login;
        this.name = name;
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isEmpty() {
        return this.getLogin().isEmpty() & this.getName().isEmpty() & this.getSurname().isEmpty();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(getLogin()).append(" ")
                .append(getName()).append(" ")
                .append(getSurname()).toString();
    }
}

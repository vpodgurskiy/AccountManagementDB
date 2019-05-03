package model;

public class Account {

    private String login, name, surname;

    public Account() {
        this("", "", "");
    }

    public Account(String login, String name, String surname) {
        this.login = login;
        this.name = name;
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isEmpty() {
        return this.getLogin().isEmpty() & this.getName().isEmpty() & this.getSurname().isEmpty();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("\n")
                .append("| ").append(getSeparator(getLogin().length())).append(" | ").append(getSeparator(getName().length())).append(" | ").append(getSeparator(getSurname().length())).append(" |\n")
                .append("| ").append(getLogin()).append(" | ").append(getName()).append(" | ").append(getSurname()).append(" |\n")
                .append("| ").append(getSeparator(getLogin().length())).append(" | ").append(getSeparator(getName().length())).append(" | ").append(getSeparator(getSurname().length())).append(" |")
                .toString();
    }

    private String getSeparator(int point) {
        String separator = "";
        int i = 0;
        while (i < point) {
            separator += " ";
            i++;
        }
        return separator;
    }
}

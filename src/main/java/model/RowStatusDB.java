package model;

public enum RowStatusDB {
    INSERT, SELECT, UPDATE, DELETE;

    public static RowStatusDB getRowStatus(int item) {
        RowStatusDB rowStatus = null;
        switch (item) {
            case 1:
                rowStatus = INSERT;
                break;
            case 2:
                rowStatus = SELECT;
                break;
            case 3:
                rowStatus = UPDATE;
                break;
            case 4:
                rowStatus = DELETE;
                break;
            default:
                break;
        }
        return rowStatus;
    }
}

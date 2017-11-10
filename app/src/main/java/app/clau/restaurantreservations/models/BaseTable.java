package app.clau.restaurantreservations.models;

/**
 * Created by Claudiu on 10-Nov-17.
 */

public class BaseTable {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BaseTable(int number) {
        this.number = number;
    }
}

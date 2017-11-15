package app.clau.restaurantreservations.models;

import java.io.Serializable;

/**
 * Created by Claudiu on 10-Nov-17.
 */

public class BaseTable implements Serializable {
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

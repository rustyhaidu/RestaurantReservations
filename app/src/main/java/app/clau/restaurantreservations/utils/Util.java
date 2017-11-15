package app.clau.restaurantreservations.utils;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * Created by Claudiu on 13-Nov-17.
 */

public class Util {

    public boolean isEmailValid(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }
}

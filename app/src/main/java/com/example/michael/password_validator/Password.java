package com.example.michael.password_validator;

/**
 * Created by Michael on 5/24/2017.
 */

public class Password {

    String password;
    int rulesApproved;
    boolean approved;

    public Password(String password) {
        rulesApproved = validate(password);

        // Determines if the password is approved, based on the number of passed rules
        if(rulesApproved >= 0) { // Currently zero since we have no rules yet...
            approved = true;
        }
    }

    // Validates the password and returns the number of rules it has passed
    public int validate(String password) {
        this.password = password;
        return 0;
    }

}

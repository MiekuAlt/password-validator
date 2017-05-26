package com.example.michael.password_validator;

/**
 * Created by Michael on 5/24/2017.
 */

public class Password {

    public String password;
    public int rulesApproved;
    public boolean approved;

    public Password(String password) {
        rulesApproved = validate(password);

        // Determines if the password is approved, based on the number of passed rules
        if(rulesApproved >= 2) { // Currently zero since we have no rules yet...
            approved = true;
        }
    }

    // Validates the password and returns the number of rules it has passed
    private int validate(String password) {
        int numPassed = 0;
        this.password = password;

        if(isNotPassword(password)) {
            numPassed++;
        }

        if(isLongEnough(password)) {
            numPassed++;
        }

        return numPassed;
    }

    // Checking if the string is not "password"
    private boolean isNotPassword(String password) {
        return !password.toLowerCase().equals("password");
    }

    // Checks if the password is at least 8 chars long
    private boolean isLongEnough(String password) {
        return password.length() >= 8;
    }
}

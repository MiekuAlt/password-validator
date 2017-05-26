package com.example.michael.password_validator;

/**
 * Created by Michael on 5/24/2017.
 */

public class Password {

    private int MIN_LENGTH = 8; // The minimum length of the password
    private int NUM_RULES = 5; // The number of rules required to pass for the password to be approved

    public String password;
    public int rulesApproved;
    public boolean approved;

    public Password(String password) {
        rulesApproved = validate(password);

        // Determines if the password is approved, based on the number of passed rules
        if(rulesApproved >= NUM_RULES) {
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
        if(hasDigit(password)) {
            numPassed++;
        }
        if(hasSymbol(password)) {
            numPassed++;
        }
        if(hasBothCases(password)) {
            numPassed++;
        }
        return numPassed;
    }

    /****** The Rules for the Validator ******/
    // Checking if the string is not "password"
    private boolean isNotPassword(String password) {
        return !password.toLowerCase().equals("password");
    }

    // Checks if the password is at least 8 chars long
    private boolean isLongEnough(String password) {
        return password.length() >= MIN_LENGTH;
    }

    // Checks if there is at least a digit in the password
    private boolean hasDigit(String password) {
        return password.matches(".*\\d+.*");
    }

    // Checks if there is at lease a symbol in the password
    private boolean hasSymbol(String password) {
        return password.matches(".*[^A-Za-z0-9]+.*");
    }

    // Checks if there is both an uppercase and a lowercase char in the password
    private boolean hasBothCases(String password) {
        return (password.matches(".*[A-Z]+.*") && password.matches(".*[a-z]+.*"));
    }
}

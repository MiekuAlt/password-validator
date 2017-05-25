package com.example.michael.password_validator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 5/24/2017.
 */

// Tests the Validator
public class ValidatorTest {
    @Test
    // Makes sure the password is not "password" case insensitive
    public void isNotPassword() throws Exception {
        // Initializing testers
        Password pw1 = new Password("password");
        Password pw2 = new Password("PASSWORD");
        Password pw3 = new Password("PaSsWoRd");
        Password pw4 = new Password("Not Password!");

        // Doing the checks!
        if(pw1.approved) assertNotEquals("password", pw1.password.toLowerCase());
        if(pw2.approved) assertNotEquals("password", pw2.password.toLowerCase());
        if(pw3.approved) assertNotEquals("password", pw3.password.toLowerCase());
        if(pw4.approved) assertNotEquals("password", pw4.password.toLowerCase());
    }

    @Test
    // Makes sure the password is at least 8 characters long
    public void isLongEnough() throws Exception {
        // Initializing the testers
        Password pw1 = new Password("frog");
        Password pw2 = new Password("froggers");

        // Doing the checks!
        if(pw1.approved) assertTrue(pw1.password.length() >= 8);
        if(pw2.approved) assertTrue(pw2.password.length() >= 8);
    }

}

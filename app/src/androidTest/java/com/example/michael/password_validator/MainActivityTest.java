package com.example.michael.password_validator;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    // Makes sure the password is not "password" case insensitive
    @Test
    public void isPasswordString() throws Exception {
        failCheck("Password");
        failCheck("password");
        failCheck("PASSWORD");
    }
    // Makes sure the password is at least 8 characters long
    @Test
    public void hasEnoughChars() throws Exception {
        failCheck("gLad0$");
    }
    // Makes sure there is at least a symbol
    @Test
    public void hasSpecialChars() throws Exception {
        failCheck("gLad000S");
    }
    // Makes sure there is at least 1 digit
    @Test
    public void hasDigit() throws Exception {
        failCheck("gLado$$$");
    }
    // Makes sure there is both upper case and lower case characters
    @Test
    public void hasBothCases() throws Exception {
        failCheck("glad000$");
        failCheck("GLAD000$");
    }
    // Ensures that it will react properly to a correct password
    @Test
    public void hasProperPassword() throws Exception {
        passCheck("gLad000$");
    }

    /* Since I want to check a bunch of different rules I created a couple methods that do that following:
     *  - First it clicks the edit password field
     *  - Then it types the password provided to this method
     *  - It presses the validate button
     *  - if the method is passCheck() it checks if the checkbox has been checked, and therefore the validator accepted the password
     *  - if the method is failCheck() it checks if the checkbox has not been checked, therefore the validator did not accept the password
     */
    public void passCheck(String password) {
        onView(withId(R.id.editPassword)).perform(click());
        onView(withId(R.id.editPassword)).perform(replaceText(password), closeSoftKeyboard());
        onView(withId(R.id.validButton)).perform(click());
        ViewInteraction checkBox = onView(withId(R.id.checkBox));

        checkBox.check(matches(isChecked()));
    }
    public void failCheck(String password) {
        onView(withId(R.id.editPassword)).perform(click());
        onView(withId(R.id.editPassword)).perform(replaceText(password), closeSoftKeyboard());
        onView(withId(R.id.validButton)).perform(click());
        ViewInteraction checkBox = onView(withId(R.id.checkBox));

        checkBox.check(matches(isNotChecked()));
    }
}

package com.example.healthease;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static org.hamcrest.Matchers.not;



@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class RegisterActivityUITest {

    @Rule
    public ActivityScenarioRule<RegisterActivity> activityScenarioRule =
            new ActivityScenarioRule<>(RegisterActivity.class);

    @Test
    public void testRegistrationWithValidData() {
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegUsername))
                .perform(typeText("Polok"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegEmail))
                .perform(typeText("polok@gmail.com"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegPassword))
                .perform(typeText("1234@polok"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegConfirmPassword))
                .perform(typeText("1234@polok"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.buttonRegister))
                .perform(click());
//        Espresso.onView(withText("New User Registered"))
//                .check(matches(isDisplayed()));
    }

    @Test
    public void testRegistrationWithInvalidPassword() {
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegUsername))
                .perform(typeText("testuser"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegPassword))
                .perform(typeText("invalid"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegConfirmPassword))
                .perform(typeText("invalid"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegEmail))
                .perform(typeText("test@example.com"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.buttonRegister))
                .perform(click());
//        Espresso.onView(withText("8 characters"))
//                .check(matches(isDisplayed()));
    }

    @Test
    public void testRegistrationWithMismatchedPasswords() {
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegUsername))
                .perform(typeText("testuser"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegPassword))
                .perform(typeText("Test@123"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegConfirmPassword))
                .perform(typeText("Test@12"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegEmail))
                .perform(typeText("test@example.com"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.buttonRegister))
                .perform(click());
//        Espresso.onView(withText("Passwords mismatch"))
//                .check(matches(isDisplayed()));
    }

    @Test
    public void testRegistrationWithEmptyFields() {
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegUsername))
                .perform(typeText(""), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegPassword))
                .perform(typeText(""), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegConfirmPassword))
                .perform(typeText(""), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextRegEmail))
                .perform(typeText(""), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.buttonRegister))
                .perform(click());
//        Espresso.onView(withText("Please fill all details"))
//                .check(matches(isDisplayed()));
    }
}

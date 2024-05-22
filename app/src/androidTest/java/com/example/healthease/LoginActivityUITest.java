package com.example.healthease;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.healthease.LoginActivity;
import com.example.healthease.R;
import com.example.healthease.RegisterActivity;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginActivityUITest {

    @Rule
    public ActivityScenarioRule<RegisterActivity> registerActivityScenarioRule =
            new ActivityScenarioRule<>(RegisterActivity.class);

    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void a_testLoginWithValidCredentials() {
//        Espresso.onView(ViewMatchers.withId(R.id.editTextRegUsername))
//                .perform(typeText("testuser"), closeSoftKeyboard());
//        Espresso.onView(withId(R.id.editTextRegPassword))
//                .perform(typeText("Test@123"), closeSoftKeyboard());
//        Espresso.onView(withId(R.id.editTextRegConfirmPassword))
//                .perform(typeText("Test@123"), closeSoftKeyboard());
//        Espresso.onView(withId(R.id.editTextRegEmail))
//                .perform(typeText("test@example.com"), closeSoftKeyboard());
//        Espresso.onView(withId(R.id.buttonRegister))
//                .perform(click());
//        Espresso.onView(withId(R.id.textViewExistingUser))
//                .perform(click());

        Espresso.onView(ViewMatchers.withId(R.id.editTextLoginUsername))
                .perform(typeText("Polok"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.editTextLoginPassword))
                .perform(typeText("1234@polok"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.buttonLogin))
                .perform(click());

//        Espresso.onView(withText("Login Success"))
//                .check(matches(isDisplayed()));
    }

    @Test
    public void b_testLoginWithInvalidCredentials() {

        Espresso.onView(withId(R.id.editTextLoginUsername))
                .perform(typeText("invaliduser"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.editTextLoginPassword))
                .perform(typeText("invalid"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.buttonLogin))
                .perform(click());


//        Espresso.onView(withText("Invalid Username or password"))
//                .check(matches(isDisplayed()));
    }

    @Test
    public void c_testLoginWithEmptyFields() {

        Espresso.onView(withId(R.id.editTextLoginUsername))
                .perform(typeText(""), closeSoftKeyboard());
        Espresso.onView(withId(R.id.editTextLoginPassword))
                .perform(typeText(""), closeSoftKeyboard());
        Espresso.onView(withId(R.id.buttonLogin))
                .perform(click());


//        Espresso.onView(withText("Please fill all details"))
//                .check(matches(isDisplayed()));
    }

    @Test
    public void d_testLoginWithInvalidUsername() {

        Espresso.onView(withId(R.id.editTextLoginUsername))
                .perform(typeText("invaliduser"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.editTextLoginPassword))
                .perform(typeText("Test@123"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.buttonLogin))
                .perform(click());


//        Espresso.onView(withText("Invalid Username or password"))
//                .check(matches(isDisplayed()));
    }

    @Test
    public void e_testLoginWithInvalidPassword() {

        Espresso.onView(withId(R.id.editTextLoginUsername))
                .perform(typeText("testuser"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.editTextLoginPassword))
                .perform(typeText("invalid"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.buttonLogin))
                .perform(click());


//        Espresso.onView(withText("Invalid Username or password"))
//                .check(matches(isDisplayed()));
    }
}

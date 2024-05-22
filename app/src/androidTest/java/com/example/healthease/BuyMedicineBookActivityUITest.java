package com.example.healthease;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.healthease.BuyMedicineBookActivity;
import com.example.healthease.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class BuyMedicineBookActivityUITest {

    private static final String SHARED_PREFS_NAME = "shared_prefs";
    private static final String USERNAME_KEY = "username";
    private static final String TEST_USERNAME = "test_user";

    @Rule
    public ActivityScenarioRule<BuyMedicineBookActivity> activityScenarioRule =
            new ActivityScenarioRule<>(BuyMedicineBookActivity.class);

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME_KEY, TEST_USERNAME);
        editor.apply();
    }

    @Test
    public void testBuyMedicineBookActivityUI() {
        onView(withId(R.id.editTextBMBFullName)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextBMBAddress)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextBMBContactNumber)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextBMBPincode)).check(matches(isDisplayed()));

        // Verify the book button is displayed
        onView(withId(R.id.buttonBMBBook)).check(matches(isDisplayed()));
    }

//    @Test
//    public void testBuyMedicineBookActivityFunctionality() {
//        onView(withId(R.id.editTextBMBFullName)).perform(replaceText("John Doe"));
//        onView(withId(R.id.editTextBMBAddress)).perform(replaceText("123 Main St"));
//        onView(withId(R.id.editTextBMBContactNumber)).perform(replaceText("1234567890"));
//        onView(withId(R.id.editTextBMBPincode)).perform(replaceText("12345"));
//        onView(withId(R.id.buttonBMBBook)).perform(click());
//        onView(withId(R.id.homeLayout)).check(matches(isDisplayed()));
//
////        onView(withText("Your booking is done successfully")).inRoot(new ToastMatcher())
////                .check(matches(isDisplayed()));
//    }
}

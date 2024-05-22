package com.example.healthease.Doctor;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.healthease.BookAppointmentActivity;
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
public class BookAppointmentActivityUI {



    @Rule
    public ActivityScenarioRule<BookAppointmentActivity> activityScenarioRule =
            new ActivityScenarioRule<>(BookAppointmentActivity.class);



    @Test
    public void test1() {
        onView(withId(R.id.editTextAppFullName)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextAppAddress)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextAppContactNumber)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextAppFees)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonBookAppointment)).check(matches(isDisplayed()));
    }


}

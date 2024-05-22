package com.example.healthease;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.healthease.OrderDetailsActivity;
import com.example.healthease.Database;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.click;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class OrderDetailsActivityUITest {

    @Rule
    public ActivityScenarioRule<OrderDetailsActivity> activityScenarioRule =
            new ActivityScenarioRule<>(OrderDetailsActivity.class);

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();


        SharedPreferences sharedpreferences = context.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("username", "testuser");
        editor.apply();


        Database db = Database.getInstance(context, null);
        db.addOrder("testuser", "John Doe", "123 Main St", "12345678901", 12345, "2023-01-01", "10:00 AM", 100.0f, "Delivery");
    }

    @Test
    public void testOrderDetailsDisplay() {
        Espresso.onView(withId(R.id.listViewOD))
                .check(matches(isDisplayed()));


        Espresso.onView(withId(R.id.buttonBack))
                .check(matches(isDisplayed()))
                .perform(click());


        Espresso.onView(withId(R.id.homeLayout))
                .check(matches(isDisplayed()));
    }
}

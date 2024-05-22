package com.example.healthease.Doctor;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.anything;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.healthease.DoctorDetailsActivity;
import com.example.healthease.FindDoctorActivity;
import com.example.healthease.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DoctorDetailsUITest {
    @Rule
    public ActivityScenarioRule<FindDoctorActivity> activityActivityScenarioRule = new ActivityScenarioRule<FindDoctorActivity>(FindDoctorActivity.class);


    @Test
    public void test1()
    {
        onView(withId(R.id.cardFDCardioloist)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listViewDD)).atPosition(0).perform(click());
        onView(withText("Aisha Khan")).check(matches(isDisplayed()));
        onView(withId(R.id.buttonBack)).perform(click());

    }

    @Test
    public void test2()
    {
        onView(withId(R.id.cardFDDietician)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listViewDD)).atPosition(0).perform(click());
        onView(withText("Leena Rahman")).check(matches(isDisplayed()));
        onView(withId(R.id.buttonBack)).perform(click());

    }

    @Test
    public void test3()
    {
        onView(withId(R.id.cardFDDentist)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listViewDD)).atPosition(0).perform(click());
        onView(withText("Afsana Islam")).check(matches(isDisplayed()));
        onView(withId(R.id.buttonBack)).perform(click());

    }

    @Test
    public void test4()
    {
        onView(withId(R.id.cardFDFamilyPhysician)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listViewDD)).atPosition(0).perform(click());
        onView(withText("Parveen Sultana")).check(matches(isDisplayed()));
        onView(withId(R.id.buttonBack)).perform(click());

    }

    @Test
    public void test5()
    {
        onView(withId(R.id.cardFDCardioloist)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.listViewDD)).atPosition(0).perform(click());
        onView(withText("Aisha Khan")).check(matches(isDisplayed()));
        onView(withId(R.id.buttonBack)).perform(click());

    }


}

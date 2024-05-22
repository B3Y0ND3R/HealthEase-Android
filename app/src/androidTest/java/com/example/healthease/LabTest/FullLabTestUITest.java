package com.example.healthease.LabTest;

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
import com.example.healthease.LabTestActivity;
import com.example.healthease.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FullLabTestUITest {
    @Rule
    public ActivityScenarioRule<LabTestActivity> activityActivityScenarioRule = new ActivityScenarioRule<LabTestActivity>(LabTestActivity.class);


    @Test
    public void test1()
    {
        onData(anything()).inAdapterView(withId(R.id.listViewLT)).atPosition(0).perform(click());
        onView(withText("Package Name: Full Body Checkup(Special)")).check(matches(isDisplayed()));

    }

    @Test
    public void test2()
    {
        onData(anything()).inAdapterView(withId(R.id.listViewLT)).atPosition(1).perform(click());
        onView(withText("Package Name: Full Body Checkup(Special)")).check(matches(isDisplayed()));

    }

    @Test
    public void test3()
    {
        onData(anything()).inAdapterView(withId(R.id.listViewLT)).atPosition(2).perform(click());
        onView(withText("Package Name: Blood Glucose Fasting(Normal)")).check(matches(isDisplayed()));

    }

    @Test
    public void test4()
    {
        onData(anything()).inAdapterView(withId(R.id.listViewLT)).atPosition(3).perform(click());
        onView(withText("Package Name: Blood Glucose Fasting(Normal)")).check(matches(isDisplayed()));

    }

    @Test
    public void test5()
    {
        onData(anything()).inAdapterView(withId(R.id.listViewLT)).atPosition(4).perform(click());
        onView(withText("Package Name: COVID-19 Antibody - IgG(Special)")).check(matches(isDisplayed()));

    }

    @Test
    public void test6()
    {
        onData(anything()).inAdapterView(withId(R.id.listViewLT)).atPosition(5).perform(click());
        onView(withText("Package Name: COVID-19 Antibody - IgG(Special)")).check(matches(isDisplayed()));

    }




}

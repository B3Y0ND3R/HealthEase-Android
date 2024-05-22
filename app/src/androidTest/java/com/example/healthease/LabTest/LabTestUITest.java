package com.example.healthease.LabTest;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.healthease.BuyMedicineActivity;
import com.example.healthease.LabTestActivity;
import com.example.healthease.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class LabTestUITest {

    @Rule
    public ActivityScenarioRule<LabTestActivity> activityScenarioRule =
            new ActivityScenarioRule<>(LabTestActivity.class);

    @Test
    public void test1() {
        onView(withId(R.id.listViewLT)).check(matches(isDisplayed()));
    }

    @Test
    public void test2() {
        onView(withId(R.id.buttonLTBack)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonLTGoToCart)).check(matches(isDisplayed()));
    }

    @Test
    public void test3() {
        onView(withId(R.id.buttonLTGoToCart)).perform(click());
        onView(withId(R.id.labtestcartactivitylayout)).check(matches(isDisplayed()));
    }

    @Test
    public void test4() {
        onView(withId(R.id.buttonLTBack)).perform(click());
        onView(withId(R.id.homeLayout)).check(matches(isDisplayed()));
    }

    @Test
    public void test5() {
        onData(anything()).inAdapterView(withId(R.id.listViewLT)).atPosition(0).perform(click());
        onView(withId(R.id.labtestdetailslayout)).check(matches(isDisplayed()));

        onView(withId(R.id.textViewLDPackageName)).check(matches(withText("Package Name: Full Body Checkup(Special)")));
    }
}



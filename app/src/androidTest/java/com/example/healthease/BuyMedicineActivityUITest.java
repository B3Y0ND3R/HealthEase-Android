package com.example.healthease;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.healthease.BuyMedicineActivity;
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
public class BuyMedicineActivityUITest {

    @Rule
    public ActivityScenarioRule<BuyMedicineActivity> activityScenarioRule =
            new ActivityScenarioRule<>(BuyMedicineActivity.class);

    @Test
    public void testActivityIsDisplayed() {
        onView(withId(R.id.listViewBM)).check(matches(isDisplayed()));
    }

    @Test
    public void testButtonsAreDisplayed() {
        onView(withId(R.id.buttonBMBack)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonBMGoToCart)).check(matches(isDisplayed()));
    }

    @Test
    public void testGoToCartButton() {
        onView(withId(R.id.buttonBMGoToCart)).perform(click());
        onView(withId(R.id.cartLayout)).check(matches(isDisplayed()));
    }

    @Test
    public void testBackButton() {
        onView(withId(R.id.buttonBMBack)).perform(click());
        onView(withId(R.id.homeLayout)).check(matches(isDisplayed()));
    }

    @Test
    public void testItemClickNavigatesToDetails() {
        onData(anything()).inAdapterView(withId(R.id.listViewBM)).atPosition(0).perform(click());
        onView(withId(R.id.detailsLayout)).check(matches(isDisplayed()));

        onView(withId(R.id.textViewBMDPackageName)).check(matches(withText("Napa Paracetamol")));
        onView(withId(R.id.editTestBMDMultiLine)).check(matches(withText("Napa Paracetamol is a common pain reliever and fever reducer. It's used to treat minor aches and pains, colds, and fevers.")));
        // onView(withId(R.id.textViewBMDTotalCost)).check(matches(withText("50")));
    }
}



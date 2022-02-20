package com.example.android.testing.unittesting;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.*;
import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.android.testing.unittesting.BasicSample.MainActivity;
import com.example.android.testing.unittesting.BasicSample.R;

public class DAT153UITest {

    @Rule public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void test_enterEmail() {
        onView(withId(R.id.emailInput)).perform(typeText("vsto@hvl.no"), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(click());
        onView(withId(R.id.emailInput)).check(matches(hasErrorText(nullValue(String.class))));
    }

    @Test
    public void test_enterEmailWrong() {
        onView(withId(R.id.emailInput)).perform(typeText("!!!!@hvl.no"), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(click());
        onView(withId(R.id.emailInput)).check(matches(hasErrorText("Invalid email")));
    }

    @Before
    public void clearField() {
        // Compare with/without
        onView(withId(R.id.emailInput)).perform(clearText());
    }
}

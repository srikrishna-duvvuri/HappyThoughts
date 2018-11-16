package cs2340.happythoughts;

import android.app.Activity;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.filters.MediumTest;

import android.support.test.rule.ActivityTestRule;
import android.util.Log;
import android.view.View;

import junit.extensions.ActiveTestSuite;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cs2340.happythoughts.Controllers.LoginActivity;
import cs2340.happythoughts.Controllers.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class SriTest {
    @Rule
    public ActivityTestRule<LoginActivity> rule  = (ActivityTestRule<LoginActivity>) new ActivityTestRule(LoginActivity.class);

    @Test
    public void testSuccess() {
        /*onView(withId(R.id.registrationButton)).perform(click());
        onView(withId(R.id.email)).perform(typeText("test"));
        onView(withId(R.id.password)).perform(typeText("test"));
        onView(withId(R.id.spinner)).perform(ViewActions.click());
        onView(withId(R.id.spinner)).perform(ViewActions.swipeUp());
        onView(withId(R.id.spinner)).perform(ViewActions.click());
        onView(withId(R.id.email_registration_button)).perform(ViewActions.click());*/

        onView(withId(R.id.email)).perform(typeText("test@"));
        onView(withId(R.id.password)).perform(typeText("test"));
        onView(withId(R.id.email_sign_in_button)).perform(click());
        onView(withId(R.id.logoutButton)).perform(click());
    }

    @Test
    public void testFailure() {
        onView(withId(R.id.email)).perform(typeText("fail@"));
        onView(withId(R.id.password)).perform(typeText("fail"));
        onView(withId(R.id.email_sign_in_button)).perform(click());
        onView(withId(R.id.password)).check(matches(hasErrorText("This password is incorrect")));
    }
}

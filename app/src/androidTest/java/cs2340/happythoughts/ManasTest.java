package cs2340.happythoughts;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Rule;



import cs2340.happythoughts.controllers.RegistrationActivity;
import static android.support.test.espresso.action.ViewActions.click;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class ManasTest {
    @Rule
    public ActivityTestRule<RegistrationActivity> mActivityRule =
            new ActivityTestRule<>(RegistrationActivity.class);

    @Test
    public void testRegistrationSuccess() {
        onView(withId(R.id.email)).perform(typeText("test@"));
        onView(withId(R.id.password)).perform(typeText("test"));
        onView(withId(R.id.email_registration_button)).perform(click());
    }

    @Test
    public void testRegistrationFailure() {
        onView(withId(R.id.email)).perform(typeText("fail@"));
        onView(withId(R.id.password)).perform(typeText("fai"));
        onView(withId(R.id.email_registration_button)).perform(click());
        onView(withId(R.id.password)).check(matches(hasErrorText("This password is too short")));
    }
}

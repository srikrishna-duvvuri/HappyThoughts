package cs2340.happythoughts;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.filters.MediumTest;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cs2340.happythoughts.Controllers.MainActivity;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class SriTest {
    @Rule
    public ActivityTestRule<MainActivity> rule  = new ActivityTestRule(MainActivity.class);

    
}

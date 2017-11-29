package com.hms.mohamedseliem.httpclient;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import com.hms.mohamedseliem.httpclient.fragment.HomeFragment;
import com.hms.mohamedseliem.httpclient.fragment.MapFragment;
import com.hms.mohamedseliem.httpclient.fragment.ProfileFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by Mohamed Seliem on 11/29/2017.
 */
public class PatientMenuActivityTest {
    @Rule
    public ActivityTestRule<PatientMenuActivity> PatientMenuActivityTestRule=new ActivityTestRule<PatientMenuActivity>(PatientMenuActivity.class);
    public PatientMenuActivity lActivity=null;
    Instrumentation.ActivityMonitor homemonitor=getInstrumentation().addMonitor(HomeFragment.class.getName(),null,false);
    Instrumentation.ActivityMonitor profilemonitor=getInstrumentation().addMonitor(ProfileFragment.class.getName(),null,false);
    Instrumentation.ActivityMonitor mapmonitor=getInstrumentation().addMonitor(MapFragment.class.getName(),null,false);
    @Before
    public void setUp() throws Exception {
        lActivity=PatientMenuActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        lActivity=null;
    }

    @Test
    public void loadHomeFragment() throws Exception {
        assertNotNull(lActivity.findViewById(R.id.nav_home));
        onView(withId(R.id.nav_home)).perform(click());
        Activity SecondActivity=getInstrumentation().waitForMonitorWithTimeout(homemonitor,5000);
        assertNotNull(SecondActivity);
        SecondActivity.finish();
    }
    @Test
    public void loadProfileFragment() throws Exception {
        assertNotNull(lActivity.findViewById(R.id.nav_profile));
        onView(withId(R.id.nav_profile)).perform(click());
        Activity SecondActivity=getInstrumentation().waitForMonitorWithTimeout(profilemonitor,5000);
        assertNotNull(SecondActivity);
        SecondActivity.finish();
    }
    @Test
    public void loadMapFragment() throws Exception {
        assertNotNull(lActivity.findViewById(R.id.nav_map));
        onView(withId(R.id.nav_map)).perform(click());
        Activity SecondActivity=getInstrumentation().waitForMonitorWithTimeout(mapmonitor,5000);
        assertNotNull(SecondActivity);
        SecondActivity.finish();
    }


}
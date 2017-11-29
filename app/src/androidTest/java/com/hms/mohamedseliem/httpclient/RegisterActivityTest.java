package com.hms.mohamedseliem.httpclient;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by Mohamed Seliem on 11/29/2017.
 */
public class RegisterActivityTest {
    @Rule
    public ActivityTestRule<RegisterActivity> registerActivityTestRule=new ActivityTestRule<RegisterActivity>(RegisterActivity.class);
    public RegisterActivity lActivity=null;
    Instrumentation.ActivityMonitor monitor=getInstrumentation().addMonitor(PostActivity.class.getName(),null,false);
    @Before
    public void setUp() throws Exception {
        lActivity=registerActivityTestRule.getActivity();
    }
    @Test
    public void registertest(){
        View view=lActivity.findViewById(R.id.til_name);
        assertNotNull(view);

        view=lActivity.findViewById(R.id.til_email);
        assertNotNull(view);

        view=lActivity.findViewById(R.id.til_password);
        assertNotNull(view);

        view=lActivity.findViewById(R.id.go_to_login);
        assertNotNull(view);
    }
    @Test
    public void registercorrectly(){
        assertNotNull(lActivity.findViewById(R.id.go_to_login));
        onView(withId(R.id.til_name)).perform(typeText("new register"));
        onView(withId(R.id.til_email)).perform(typeText("register@app.com"));
        onView(withId(R.id.til_password)).perform(typeText("password"));
        onView(withId(R.id.go_to_login)).perform(click());
        Activity SecondActivity=getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(SecondActivity);
        SecondActivity.finish();

    }
    @Test
    public void registerwithoutname(){
        assertNotNull(lActivity.findViewById(R.id.go_to_login));
        onView(withId(R.id.til_name)).perform(typeText(""));
        onView(withId(R.id.til_email)).perform(typeText("register@app.com"));
        onView(withId(R.id.til_password)).perform(typeText("password"));
        onView(withId(R.id.go_to_login)).perform(click());
        Activity SecondActivity=getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNull(SecondActivity);
        SecondActivity.finish();

    }

    @Test
    public void registerwithoutemail(){
        assertNotNull(lActivity.findViewById(R.id.go_to_login));
        onView(withId(R.id.til_name)).perform(typeText("new register"));
        onView(withId(R.id.til_email)).perform(typeText(""));
        onView(withId(R.id.til_password)).perform(typeText("password"));
        onView(withId(R.id.go_to_login)).perform(click());
        Activity SecondActivity=getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNull(SecondActivity);
        SecondActivity.finish();

    }
    @Test
    public void registerwithoutpassword(){
        assertNotNull(lActivity.findViewById(R.id.go_to_login));
        onView(withId(R.id.til_name)).perform(typeText("new register"));
        onView(withId(R.id.til_email)).perform(typeText(""));
        onView(withId(R.id.til_password)).perform(typeText("password"));
        onView(withId(R.id.go_to_login)).perform(click());
        Activity SecondActivity=getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNull(SecondActivity);
        SecondActivity.finish();

    }

    @Test
    public void exceedingtheinputlimits(){
        assertNotNull(lActivity.findViewById(R.id.go_to_login));
        onView(withId(R.id.til_name)).perform(typeText("new register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register" +
                "new registernew registernew registernew registernew registernew registernew registernew register"));
        onView(withId(R.id.til_email)).perform(typeText(""));
        onView(withId(R.id.til_password)).perform(typeText("password"));
        onView(withId(R.id.go_to_login)).perform(click());
        Activity SecondActivity=getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNull(SecondActivity);
        SecondActivity.finish();

    }




    @After
    public void tearDown() throws Exception {
        lActivity=null;
    }

}
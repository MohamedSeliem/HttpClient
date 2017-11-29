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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by Mohamed Seliem on 11/28/2017.
 */
public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> loginActivityTestRule=new ActivityTestRule<LoginActivity>(LoginActivity.class);
    public LoginActivity lActivity=null;
    Instrumentation.ActivityMonitor monitor=getInstrumentation().addMonitor(PostActivity.class.getName(),null,false);
    @Before
    public void setUp() throws Exception {
        lActivity=loginActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        lActivity=null;
    }


    @Test
    public void logintest(){
        View view=lActivity.findViewById(R.id.til_email);
        assertNotNull(view);

        view=lActivity.findViewById(R.id.loader);
        assertNotNull(view);

        view=lActivity.findViewById(R.id.form_container);
        assertNotNull(view);

        view=lActivity.findViewById(R.id.btn_facebook);
        assertNotNull(view);

        view=lActivity.findViewById(R.id.til_password);
        assertNotNull(view);

        view=lActivity.findViewById(R.id.go_to_register);
        assertNotNull(view);
    }
    @Test
    public void checklogintest(){
    assertNotNull(lActivity.findViewById(R.id.btn_login));
    onView(withId(R.id.btn_login)).perform(click());
    Activity SecondActivity=getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
    assertNotNull(SecondActivity);
    SecondActivity.finish();
    }
}
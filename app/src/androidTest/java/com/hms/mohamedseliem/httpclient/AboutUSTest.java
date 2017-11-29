package com.hms.mohamedseliem.httpclient;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

/**
 * Created by Mohamed Seliem on 11/28/2017.
 */
public class AboutUSTest {
    @Rule
    public ActivityTestRule<AboutUS> AboutUSActivityTestRule=new ActivityTestRule<AboutUS>(AboutUS.class);
    public AboutUS lActivity=null;
    Instrumentation.ActivityMonitor monitor=getInstrumentation().addMonitor(PostActivity.class.getName(),null,false);
    @Before
    public void setUp() throws Exception {
        lActivity=AboutUSActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        lActivity=null;
    }

}
package com.example.project_b_open_day_application;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented fragment_mei, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under fragment_mei.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.project_b_open_day_application", appContext.getPackageName());
    }
}

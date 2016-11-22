package edu.orangecoastcollege.cs273.mpaulding.ocmusicevents;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class JSONLoaderTest {
    private Context mContext;
    @Before
    public void setUp()
    {
        mContext = InstrumentationRegistry.getTargetContext();
    }
@Test
    public void textLoadJSONFromAsset()
{
    try {
        ArrayList<MusicEvent> testList = JSONLoader.loadJSONFromAsset(mContext, "MusicEvents.json");
        assertEquals(8,testList.size());
    } catch (IOException e) {
        fail("Expected Loader to load 8 music events" );
    }
}
    @Test
    public void textAbnormalLoadJSONFromAsset()
    {
        try {
            ArrayList<MusicEvent> testList = JSONLoader.loadJSONFromAsset(mContext, "fileName.json");
            fail("Expected Loader to load 8 music events" );
        } catch (IOException e) {
           //do nothing because you want an IOException
        }
    }
}

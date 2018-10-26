package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by Chenlin Cao on Oct 25,2018.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    @Override
    public void setUp(){
        solo = new Solo(getInstrumentation(),getActivity());
    }

    @Override
    public void tearDown(){
        solo.finishOpenedActivities();
    }

    public void testTweet(){
        solo.assertCurrentActivity("wrong activity",LonelyTwitterActivity.class);
    }

    public void testEquals(){
        assertEquals("not equal","5","5");
    }

    public void testAddtweet(){
        solo.enterText((EditText) solo.getView(R.id.body),"don't know");

        solo.clickOnButton("Save");

        assertTrue(solo.waitForText("don't know")); // This waits for a text from the current screen

    }

    // When an item in ListView is clicked, get the corresponding tweet and send it to EditTweet Activity.
    // Display the tweet in EditTweet Activity. (However you want)
    // Write a UI test case to Verify that the tweet is correct and visible in the new activity.

    public void testEditTweet(){
        solo.clickOnButton("Clear");
        solo.enterText((EditText) solo.getView(R.id.body),"test for edit tweet activity");
        solo.clickOnButton("Save");
        solo.clickInList(1);
        solo.assertCurrentActivity("wrong activity",EditTweetActivity.class);
        assertTrue(solo.waitForText("test for edit tweet activity"));

    }



}
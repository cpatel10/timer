package cs413f15team01p4.timer.test.Android;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.lang.Runnable;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import cs413f15team01p4.timer.android.TimerAdapter;
import cs413f15team01p4.timer.R;

/**
 * Abstract GUI-level test superclass of several essential timer scenarios.
 */
/**
 * Created by Home on 11/11/2015.
 */
public abstract class AbstractTimerActivityTest {
    /**
     * Verifies that the activity under test can be launched.
     */
    @Test
    public void testActivityCheckTestCaseSetUpProperly() {
        assertNotNull("activity should be launched successfully", getActivity());
    }

    /**
     * Verifies the following scenario: time is 0.
     *
     * @throws Throwable
     */
    @Test
    public void testActivityScenarioInit() throws Throwable {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertEquals(0, getDisplayedValue());
            }
        });
    }

    /**
     * Verifies the following scenario: time is 0 (state = stopped), press start  5 times,state = stopped,
     * screen show number 5 on screen when 3 secs elapsed the state = Running
     *
     * @throws Throwable
     */
    @Test
    public void testActivityScenarioRun() throws Throwable {
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertEquals(0, getDisplayedValue());
                asserEquals("Stopped", getStateName());
                clickButton(8);
                asserEquals("Stopped", getStateName());
                assertEquals(0, getDisplayedValue());
            }
        });
        Thread.sleep(3000); // <-- do not run this in the UI thread!
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
        Thread.sleep(3000);
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertEquals("Running", getStateName());
                clickButton(1);
                assertEquals("Stopped", getStateName());
            }
        });
    }

       /* if the user click the "start/stop" button for the first time the state=stopped*/
    @Test

    public void testActivityStopState() throws Throwable {
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertEquals(0, getDisplayedValue());
                clickButton(5);
                assertEquals("Stopped", getStateName());
                assertEquals(5, getDisplayedValue());
            }
        });
        Thread.sleep(5500);
    }
    @Test
    public void testActivityScenarioReset() throws Throwable {
        getActivity().runOnUiThread(new Runnable() {
            @Override public void run() {
                assertEquals(0, getDisplayedValue());
                assertEquals("Stopped", getStateName());
                clickButton(5);
                assertEquals("Stopped", getStateName());
                assertEquals(5, getDisplayedValue());
            }});
        Thread.sleep(5500);
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }});
        Thread.sleep(5500);
        runUiThreadTasks();
        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                assertEquals("Running", getStateName());
                clickButton(1);
                // assertTrue(getStartStopButton().performClick());
                assertEquals("Stopped", getStateName());
                assertEquals(0, getDisplayedValue());


            }
        });
    }

    // auxiliary methods for easy access to UI widgets

    protected abstract TimerAdapter getActivity();

    protected int tvToInt(final TextView t) {
        return Integer.parseInt(t.getText().toString().trim());
    }

    protected int getDisplayedValue() {
        final TextView ts = (TextView) getActivity().findViewById(R.id.seconds);
        return tvToInt(ts);
    }

    protected String getStateName(){
        final TextView txtState = (TextView) getActivity().findViewById(R.id.stateName);
        return txtState.getText().toString();
    }
    protected void clickButton(int j) {
        for(int i=0; i<j; i++)
        assertTrue(getStartStopButton().performClick());
    }


    /**
     * Explicitly runs tasks scheduled to run on the UI thread in case this is required
     * by the testing framework, e.g., Robolectric.
     */
    protected void runUiThreadTasks() { }
}



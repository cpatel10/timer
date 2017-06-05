package cs413f15team01p4.timer;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import cs413f15team01p4.timer.android.TimerAdapter;
import cs413f15team01p4.timer.test.Android.AbstractTimerActivityTest;
/**
 * Created by Shoroog on 11/12/15.
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<TimerAdapter>{

    /**
     * Creates an {@link ActivityInstrumentationTestCase2} for the
     * {@linkSkeletonActivity} activity.
     */

    public ApplicationTest() {
        super(TimerAdapter.class);
        actualTest = new AbstractTimerActivityTest() {
            @Override
            protected TimerAdapter getActivity() {
                // return activity instance provided by instrumentation test
                return TimerActivityTest.this.getActivity();
            }
        };
    }

    private AbstractTimerActivityTest actualTest;

    public void testActivityCheckTestCaseSetUpProperly() {
        actualTest.testActivityCheckTestCaseSetUpProperly();
    }

    public void testActivityScenarioRun() throws Throwable {
        actualTest.testActivityScenarioRun();
    }

    public void testActivityStopState() throws Throwable {
        actualTest.testActivityStopState();
    }
    public void testActivityScenarioReset()throws Throwable{  actualTest.testActivityScenarioReset();}

}

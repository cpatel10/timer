package cs413f15team01p4.timer.test.model.state;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs413f15team01p4.timer.R;
import cs413f15team01p4.timer.common.TimerUIUpdateListener;
import cs413f15team01p4.timer.model.clock.ClockModel;
import cs413f15team01p4.timer.model.clock.OnTickListener;
import cs413f15team01p4.timer.model.state.TimerStateMachine;
import cs413f15team01p4.timer.model.time.TimeModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Testcase superclass for the stopwatch state machine model. Unit-tests the state
 * machine in fast-forward mode by directly triggering successive tick events
 * without the presence of a pseudo-real-time clock. Uses a single unified mock
 * object for all dependencies of the state machine model.
 */
public abstract class AbstractTimerStateMachineTest {

    private TimerStateMachine model;

    private UnifiedMockDependency dependency;

    @Before
    public void setUp() throws Exception {
        dependency = new UnifiedMockDependency();
    }

    @After
    public void tearDown() {
        dependency = null;
    }

    /**
     * Setter for dependency injection. Usually invoked by concrete testcase
     * subclass.
     *
     * @param model
     */
    protected void setModel(final TimerStateMachine model) {
        this.model = model;
        if (model == null)
            return;
        this.model.setUIUpdateListener(dependency);
        this.model.actionInit();
    }

    protected UnifiedMockDependency getDependency() {
        return dependency;
    }

    /**
     * Verifies that we're initially in the stopped state (and told the listener
     * about it).
     */
    @Test
    public void testPreconditions() {
        assertEquals(R.string.STOPPED, dependency.getState());
    }

    /**
     * Verifies the following scenario: time is 0, press start, wait 3+ seconds,
     * expect time 3.
     */
    @Test
    public void testScenarioRun() {
        assertTimeEquals(0);
        // directly invoke the button press event handler methods
        model.onStartStop();
        onTickRepeat(2);
        assertTimeEquals(2);
    }


    /**
     * Sends the given number of tick events to the model.
     *
     *  @param n the number of tick events
     */
    protected void onTickRepeat(final int n) {
        for (int i = 0; i < n; i++)
            model.onTick();
    }

    /**
     * Checks whether the model has invoked the expected time-keeping
     * methods on the mock object.
     */
    protected void assertTimeEquals(final int t) {
        assertEquals(t, dependency.getTime());
    }
}

/**
 * Manually implemented mock object that unifies the three dependencies of the
 * stopwatch state machine model. The three dependencies correspond to the three
 * interfaces this mock object implements.
 *
 * @author laufer
 */
class UnifiedMockDependency implements TimeModel, ClockModel, TimerUIUpdateListener {

    private int timeValue = -1, stateId = -1;

    private int runningTime = 0, stopTime = 0;

    private boolean started = false;

    public int getTime() {
        return timeValue;
    }

    public int getState() {
        return stateId;
    }

    public boolean isStarted() {
        return started;
    }

    @Override
    public void updateTime(final int timeValue) {
        this.timeValue = timeValue;
    }

    @Override
    public void updateState(final int stateId) {
        this.stateId = stateId;
    }

    @Override
    public void setOnTickListener(OnTickListener listener) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void ringAlarm() {
    }

    @Override
    public void onStart() {
        started = true;
    }

    @Override
    public void onStop() {
        started = false;
    }



    @Override
    public int getRuntime() {
        return 0;
    }

    @Override
    public void resetRuntime() {
        runningTime = 0;
    }

    @Override
    public void incRuntime() {

    }

    @Override
    public void resetStopTime() {
        stopTime=0;
    }

    @Override
    public void RunTimeDec() {
        runningTime -- ;
    }

    @Override
    public void StopTimeInc() {
        stopTime ++;
    }

    @Override
    public int getStopTime() {
        return stopTime;
    }
}


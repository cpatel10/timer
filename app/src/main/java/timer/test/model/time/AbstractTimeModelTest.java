package cs413f15team01p4.timer.test.model.time;

import org.junit.Test;
import cs413f15team01p4.timer.model.time.TimeModel;
import static org.junit.Assert.assertEquals;
import static cs413f15team01p4.timer.common.Constants.MIN;
import static cs413f15team01p4.timer.common.Constants.SEC_PER_TICK;
import static cs413f15team01p4.timer.common.Constants.MAX;
/**
 * Created by Home on 11/11/2015.
 */
public class AbstractTimeModelTest {

    private TimeModel model;

    /**
     * Setter for dependency injection. Usually invoked by concrete testcase
     * subclass.
     *
     * @param model
     */
    protected void setModel(final TimeModel model) {
        this.model = model;
    }

    /**
     * Verifies that runtime and stopTime are initially 0 .
     */
    @Test
    public void testPreconditions() {
        assertEquals(0, model.getRuntime());
        assertEquals(0, model.getStoptime());
    }

    /**
     * Verifies that runtime and stoptime is incremented correctly.
     */
    @Test
    public void testIncrementRuntimeOne() {
        final int rt = model.getRuntime();
        final int lt = model.getStoptime();
        model.incRuntime();
        model.incStopTime();
        assertEquals((rt + SEC_PER_TICK) % MIN, model.getRuntime());
        assertEquals((lt + SEC_PER_TICK) % MIN, model.getStoptime());
    }

    /**
     * Verifies that runtime turns over correctly.
     */
    /* @Test
    public void testIncrementRuntimeMany() {
        final int rt = model.getRuntime();
        final int lt = model.getStoptime();
        for (int i = 0; i < MAX; i ++) {
            model.incRuntime();
        }
        assertEquals(rt, model.getRuntime());
        assertEquals(lt, model.getStoptime());
    }

    /**
     * Verifies that runtime works correctly.
     */
    @Test
    public void testRuntime() {
        final int rt = model.getRuntime();
        for (int i = 0; i < 5; i ++) {
            model.incRuntime();
        }
        assertEquals(rt + 5, model.getRuntime());
        for (int i = 0; i < 5; i ++) {
            model.decRunTime();
        }
        assertEquals(rt , model.getRuntime());

    }
}


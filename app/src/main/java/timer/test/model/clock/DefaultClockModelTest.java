package cs413f15team01p4.timer.test.model.clock;

import org.junit.After;
import org.junit.Before;
import cs413f15team01p4.timer.model.clock.DefaultClockModel;

/**
 * Created by Home on 11/11/2015.
 */
public class DefaultClockModelTest extends AbstractClockModelTest {
    @Before
    public void setUp() throws Exception {
        setModel(new DefaultClockModel());
    }

    @After
    public void tearDown() throws Exception {
        setModel(null);
    }
}


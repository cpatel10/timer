package cs413f15team01p4.timer.test.model.time;

import org.junit.After;
import org.junit.Before;
import cs413f15team01p4.timer.model.state.DefaultTimerStateMachine;
/**
 * Created by Home on 11/11/2015.
 */
public class DefaultTimeModelTest extends AbstractTimeModelTest {
    @Before
    public void setUp() throws Exception {
        super.setUp();
        setModel(new DefaultTimerStateMachine(getDependency(), getDependency()));
    }

    @After
    public void tearDown() {
        setModel(null);
        super.tearDown();
    }
}
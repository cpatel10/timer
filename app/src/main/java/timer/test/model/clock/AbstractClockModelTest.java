package cs413f15team01p4.timer.test.model.clock;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;


import cs413f15team01p4.timer.model.clock.ClockModel;
import cs413f15team01p4.timer.model.clock.OnTickListener;

/**
 * Created by Home on 11/11/2015.
 */

    /**
     * Test case superclass for the autonomous clock model abstraction.
     * Unit-tests the pseudo-real-time behavior of the clock.
     * Uses a simple stub object to satisfy the clock's dependency.
     */
    public abstract class AbstractClockModelTest {

        private ClockModel model;

        /**
         * Setter for dependency injection. Usually invoked by concrete testcase
         * subclass.
         *
         * @param model
         */
        protected void setModel(final ClockModel model) {
            this.model = model;
        }

        protected ClockModel getModel() {
            return model;
        }

        /**
         * Verifies that a stopped clock does not emit any tick events.
         *
         * @throws InterruptedException
         */
        @Test
        public void testStopped() throws InterruptedException {
            // use a thread-safe object because the timer inside the
            // clock has its own thread
            final AtomicInteger i = new AtomicInteger(0);
            model.setOnTickListener(new OnTickListener() {
                @Override
                public void onTick() {
                    i.incrementAndGet();
                }
            });
            Thread.sleep(5500);
            assertEquals(0, i.get());
        }

        /**
         * Verifies that a running clock emits about one tick event per second.
         *
         * @throws InterruptedException
         */
        @Test
        public void testRunning() throws InterruptedException {
            final AtomicInteger i = new AtomicInteger(0);
            model.setOnTickListener(new OnTickListener() {
                @Override
                public void onTick() {
                    i.incrementAndGet();
                }
            });
            model.onStart();
            Thread.sleep(5500);
            model.onStop();
            assertEquals(5, i.get());
        }
    }




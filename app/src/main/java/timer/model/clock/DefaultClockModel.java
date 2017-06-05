package cs413f15team01p4.timer.model.clock;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Home on 11/5/2015.
 */
 public class DefaultClockModel implements ClockModel {
    private Timer timer;

    private OnTickListener listener;

    @Override
    public void setOnTickListener(final OnTickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onStart() {
        timer = new Timer();

        // The clock model runs onTick every 1000 milliseconds
        timer.schedule(new TimerTask() {
            @Override public void run() {
                // fire event
                listener.onTick();
            }
        }, /*initial delay*/ 1000, /*periodic delay*/ 1000);
    }

    @Override
    public void onStop() {
        timer.cancel();
    }


}

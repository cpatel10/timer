package cs413f15team01p4.timer.model.state;

import cs413f15team01p4.timer.common.TimerUIListener;
import cs413f15team01p4.timer.model.clock.ClockModel;
import cs413f15team01p4.timer.model.clock.OnTickListener;

/**
 * Created by Home on 11/6/2015.
 */
interface TimerState extends TimerUIListener, OnTickListener {
    void updateView();
    int getId();
}

package cs413f15team01p4.timer.model.state;

import cs413f15team01p4.timer.common.TimerUIListener;
import cs413f15team01p4.timer.common.TimerUIUpdateSource;
import cs413f15team01p4.timer.model.clock.OnTickListener;

/**
 * Created by Home on 11/5/2015.
 */
public interface TimerStateMachine extends TimerUIListener, OnTickListener, TimerUIUpdateSource, TimerStateMachineStateView{
}

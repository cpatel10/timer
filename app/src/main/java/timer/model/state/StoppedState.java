package cs413f15team01p4.timer.model.state;

import cs413f15team01p4.timer.R;
import cs413f15team01p4.timer.model.time.TimeModel;
import cs413f15team01p4.timer.model.clock.ClockModel;

/**
 * Created by Home on 11/5/2015.
 */
 class StoppedState implements TimerState {

    public StoppedState(final TimerStateMachineStateView sm) {
        this.sm = sm;
    }

    private final TimerStateMachineStateView sm;

    @Override
    public void onStartStop() {
        sm.actionStart();
        sm.actionInc();
        sm.actionResetStopTime();
        sm.toStoppedState();

    }

    @Override
    public void onTick() {
        sm.actionStopInc();
        sm.ThreeSecondsElapseState();

    }

    @Override
    public void updateView() {
        sm.updateUIStopTime();
    }

    @Override
    public int getId() {
        return R.string.Stopped;
    }
}
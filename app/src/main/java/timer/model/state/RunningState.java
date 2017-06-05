package cs413f15team01p4.timer.model.state;

import cs413f15team01p4.timer.R;

/**
 * Created by Home on 11/5/2015.
 */
 class RunningState implements TimerState {

    public RunningState(final TimerStateMachineStateView sm) {
        this.sm = sm;
    }

    private final TimerStateMachineStateView sm;

    @Override
    public void onStartStop() {
        sm.actionStop();
        sm.toStoppedState();
    }


    /**
     * On each tick , decrease the time
     */
    @Override
    public void onTick() {
        sm.actionDecrement();
        sm.toRunningState();
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.Running;
    }
}
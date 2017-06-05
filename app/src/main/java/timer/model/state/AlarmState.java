package cs413f15team01p4.timer.model.state;

import cs413f15team01p4.timer.R;

/**
 * Created by Home on 11/5/2015.
 */
 class AlarmState implements TimerState {

    public AlarmState(final TimerStateMachineStateView sm) {
        this.sm = sm;
    }

    private final TimerStateMachineStateView sm;

    @Override
    public void onStartStop() {
        sm.actionStop();
        sm.toStoppedState();
    }
    @Override
    public void onTick() {
        sm.actionSound();
        sm.toSoundState();
    }

    @Override
    public void updateView() {
        sm.updateUISoundTime();
    }

    @Override
    public int getId() {
        return R.string.Ringing;
    }
}

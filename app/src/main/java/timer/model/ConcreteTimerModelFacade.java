package cs413f15team01p4.timer.model;

import cs413f15team01p4.timer.common.TimerUIUpdateListener;
import cs413f15team01p4.timer.model.state.TimerStateMachine;
import cs413f15team01p4.timer.model.time.TimeModel;
import cs413f15team01p4.timer.model.state.DefaultTimerStateMachine;
import cs413f15team01p4.timer.model.time.TimeModel;
import cs413f15team01p4.timer.model.time.DefaultTimeModel;
import cs413f15team01p4.timer.model.clock.ClockModel;
import cs413f15team01p4.timer.model.clock.DefaultClockModel;
/**
 * Created by Home on 11/5/2015.
 */
public class ConcreteTimerModelFacade implements TimerModelFacade {

    private TimerStateMachine stateMachine;

    private ClockModel clockModel;

    private TimeModel timeModel;

    public ConcreteTimerModelFacade() {
        timeModel = new DefaultTimeModel();
        clockModel = new DefaultClockModel();
        stateMachine = new DefaultTimerStateMachine(timeModel, clockModel);
        clockModel.setOnTickListener(stateMachine);
    }

    @Override
    public void onStart() {
        stateMachine.actionInit();
    }

    @Override
    public void setUIUpdateListener(final TimerUIUpdateListener listener) {
        stateMachine.setUIUpdateListener(listener);
    }

    @Override
    public void onStartStop() {
        stateMachine.onStartStop();
    }



}

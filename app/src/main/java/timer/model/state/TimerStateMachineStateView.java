package cs413f15team01p4.timer.model.state;

/**
 * Created by Home on 11/5/2015.
 */
public interface TimerStateMachineStateView {
    void toRunningState();
    void toStoppedState();
    void toSoundState();
    void ThreeSecondsElapseState();

    // actions
    void actionInit();
    void actionReset();
    void actionStart();
    void actionStop();
    void actionInc();
    void actionUpdateView();
    void actionStopInc();
    void actionResetStopTime();
    void actionDecrement();
    void actionSound();

    // state-dependent UI updates
    void updateUIRuntime();
    void updateUISoundTime();
    void updateUIStopTime();
}


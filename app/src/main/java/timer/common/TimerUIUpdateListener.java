package cs413f15team01p4.timer.common;

/**
 * Created by Home on 11/5/2015.
 */
public interface TimerUIUpdateListener {
    void updateTime(int timeValue);
    void updateState(int stateId);
    void ringAlarm();
}

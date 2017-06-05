package cs413f15team01p4.timer.model.time;

/**
 * Created by Home on 11/5/2015.
 */
public interface TimeModel {
    void resetRuntime();
    void incRuntime();
    int getRuntime();
    int getStoptime();
    void resetStopTime();
    void  incStopTime();
    void  decRunTime();
}

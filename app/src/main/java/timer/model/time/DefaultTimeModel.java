package cs413f15team01p4.timer.model.time;

import static cs413f15team01p4.timer.common.Constants.*;
/**
 * Created by Home on 11/5/2015.
 */
public class DefaultTimeModel implements TimeModel {

    private int runningTime = 0;

    private int StopTime = 0;
    /*
    Reset time to 0
     */
    @Override
    public void resetRuntime() {
        runningTime = 0;
    }
    /*
    Update running time
     */
    @Override
    public void incRuntime() {
        if ( runningTime < 99){
            runningTime = (runningTime + SEC_PER_TICK) % MAX;
        }
    }

    @Override
    public int getRuntime(){
        return runningTime;
    }

    @Override
    public int getStopTime() {
        return StopTime;
    }

    @Override
    public void resetStopTime() {
        StopTime = 0;
    }

    @Override
    public void StopTimeInc() {
        StopTime= (StopTime + SEC_PER_TICK) % MAX;
    }

    @Override
    public void RunTimeDec() {
        runningTime = (runningTime  - SEC_PER_TICK) % MAX ;
    }

}
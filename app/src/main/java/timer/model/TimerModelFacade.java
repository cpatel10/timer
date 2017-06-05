package cs413f15team01p4.timer.model;

import cs413f15team01p4.timer.common.TimerUIListener;
import cs413f15team01p4.timer.common.TimerUIUpdateSource;
import java.io.Serializable;

/**
 * Created by Home on 11/5/2015.
 */
public interface TimerModelFacade extends TimerUIListener, TimerUIUpdateSource,Serializable {
 void onStart();
}

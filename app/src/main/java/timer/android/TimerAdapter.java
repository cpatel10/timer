package cs413f15team01p4.timer.android;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.media.Ringtone;
import java.io.IOException;

import cs413f15team01p4.timer.common.Constants;
import cs413f15team01p4.timer.common.TimerUIUpdateListener;
import cs413f15team01p4.timer.model.TimerModelFacade;
import cs413f15team01p4.timer.R;
import cs413f15team01p4.timer.model.ConcreteTimerModelFacade;

/**
 * Created by Home on 11/2/2015.
 */
public class TimerAdapter extends Activity implements TimerUIUpdateListener {
    private static String TAG = "Timer-android-activity";

/**
 * The state-based dynamic model.
 */
private TimerModelFacade model;
private static Ringtone ringtone;
private static boolean ringing;
protected void setModel(final TimerModelFacade  model) {
        this.model = model;
        }

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inject dependency on view so this adapter receives UI events
        setContentView(R.layout.activity_main);
        // inject dependency on model into this so model receives UI events
        this.setModel(new ConcreteTimerModelFacade());
        // inject dependency on this into model to register for UI updates
        model.setUIUpdateListener(this);
        }


@Override //Inflate a menu hierarchy from the specified XML resource
public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        }


/**
 * Preserves the model state for situations such device rotation.
 */
@Override
public void onSaveInstanceState(final Bundle savedInstanceState) {
        Log.i(TAG, "onSaveInstanceState");

        // save model information
        savedInstanceState.putSerializable(getString(R.string.model_key), model);

final TextView seconds = (TextView) findViewById(R.id.seconds);
final TextView stateName = (TextView) findViewById(R.id.stateName);
        // save whether the app is ringing
        savedInstanceState.putBoolean(getString(R.string.ringing_key), ringing);
        // save display state
        savedInstanceState.putString(getString(R.string.state_key), stateName.getText().toString());
        // save display time
        savedInstanceState.putString(getString(R.string.seconds_key), seconds.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
        if(ringtone!=null)
        ringtone.stop();
        }

/**
 * Restores the model state after situations such device rotation.
 */
@Override
public void onRestoreInstanceState(final Bundle savedInstanceState) {
        Log.i(TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);

final TextView seconds = (TextView) findViewById(R.id.seconds);
final TextView stateName = (TextView) findViewById(R.id.stateName);

        // restore model information
        model = (TimerModelFacade) savedInstanceState.getSerializable(getString(R.string.model_key));

        // restore whether the app is ringing
        ringing = savedInstanceState.getBoolean(getString(R.string.ringing_key));

        if (ringing) {
        ringtone.play();
        }

        model.setUIUpdateListener(this);
        }


@Override
protected void onStart() {
        super.onStart();
        model.onStart();
        }

/** adding Alarm feature */

public void ringAlarm(){
final Uri defaultRingtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

final MediaPlayer media = new MediaPlayer();


        try {
        media.setDataSource(getApplicationContext(), defaultRingtoneUri);
        media.setAudioStreamType(AudioManager.STREAM_NOTIFICATION);
        media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

@Override
public void onCompletion(MediaPlayer mp) { mp.release(); }
        });
        media.start();
        } catch (IllegalArgumentException e) {
        e.printStackTrace();
        } catch (SecurityException e) {
        e.printStackTrace();
        } catch (IllegalStateException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
        }

/**
 * Updates the seconds in the UI.
 * @param time
 */
public void updateTime(final int time) {
        // UI adapter responsibility to schedule incoming events on UI thread
        runOnUiThread(new Runnable() {
@Override
public void run() {
final TextView tvS = (TextView) findViewById(R.id.seconds);
final int seconds = time % Constants.MIN;
        tvS.setText(Integer.toString(seconds / 10) + Integer.toString(seconds % 10));

        }
        });
        }

/**
 * Updates the state name in the UI.
 * @param stateId
 */
public void updateState(final int stateId) {
        // UI adapter responsibility to schedule incoming events on UI thread
        runOnUiThread(new Runnable() {
@Override
public void run() {
final TextView stateName = (TextView) findViewById(R.id.stateName);
        stateName.setText(getString(stateId));
        }
        });
        }

// forward event listener methods to the model
public void onStartStop(final View view) {
        model.onStartStop();
        }


        }

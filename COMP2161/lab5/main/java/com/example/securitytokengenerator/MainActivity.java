/*
 * Name: Tanner Watmough
 * Date: December 8, 2022
 *
 * Assignment 5: Security Token
 */

package com.example.securitytokengenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {
    // Variables
    private TextView passcodeGen, timeRemaining;
    private BroadcastReceiver minuteUpdateReceiver;
    private int counter;
    private long timeLeftInMilliseconds = 60000;
    private long timeLeft, milliSecondsLeft;
    private CountDownTimer countDownTimer, startingTimer;
    private boolean isCounterRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning TextView variables to their text views
        passcodeGen = (TextView) findViewById(R.id.passcodeTxtView);
        timeRemaining = (TextView) findViewById(R.id.timeRemainTxtView);

        // Gets user's current minute value from device
        counter = LocalDateTime.now().getMinute();
        // pCode is current minute * 1245 + 100, or the password code.
        int pCode = counter * 1245 + 100;
        // Sets passcode textview to the generated code
        passcodeGen.setText("" + pCode);

        /*
         * Gets current seconds but since we're counting down and seconds count up,
         * we reverse the order by subtracting current seconds from 60, and then
         * multiplying by 1000 to get milliseconds.
         */
        milliSecondsLeft = (60 - LocalDateTime.now().getSecond()) * 1000;

        // Starts a CountDownTimer for 60,000 milliseconds, ticking every 1000ms.
        startingTimer = new CountDownTimer(milliSecondsLeft,
                1000) {
        // This is a starter timer so we can get the exact seconds the user has left in a minute.
            @Override
            // This is every tick, set to 1000. That means l counts down from 1000.
            public void onTick(long l) {
                milliSecondsLeft = l;
                // We don't want l to countdown from 1000 so we convert to seconds.
                int seconds = (int) milliSecondsLeft / 1000;
                // Updates board with current seconds remaining.
                timeRemaining.setText(seconds + " seconds remaining...");
            }
        // On finish, trash collects the startingTimer.
            @Override
            public void onFinish() {
                startingTimer = null;
            }
        }.start(); // Starts timer.
    }

    public void startMinuteUpdater() {
        // Intent filter which gets every minute update from device
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        // Broadcast receiver to receiver action_time_tick intent from device.
        minuteUpdateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // counter set to current minute
                counter = LocalDateTime.now().getMinute();
                // passcode generation
                int pCode = counter * 1245 + 100;
                // set passcode text
                passcodeGen.setText("" + pCode);

                // Reverses seconds to countdown instead of up
                timeLeft = 60 - LocalDateTime.now().getSecond();
                // sets time text
                timeRemaining.setText(timeLeft + " seconds remaining...");

                // timer for 60000ms, interval of 1000ms
                countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
                    @Override
                    public void onTick(long l) {
                        timeLeftInMilliseconds = l;
                        // calls updateTimer() every tick.
                        updateTimer();
                    }

                    @Override
                    public void onFinish() {
                        // resets milliseconds to 60000
                        timeLeftInMilliseconds = 60000;
                        // turns counter off
                        isCounterRunning = false;
                    }
                };
                // If counter isn't running make running true and start it.
                if (!isCounterRunning) {
                    isCounterRunning = true;
                    countDownTimer.start();
                } else {
                    // If counter is running, cancel it, and restart it.
                    countDownTimer.cancel();
                    countDownTimer.start();
                }
            }
        };
        // Registers Receiver
        registerReceiver(minuteUpdateReceiver, intentFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Starts startMinuteUpdater() when app resumes
        startMinuteUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Makes sure the startMinuteUpdater(); stops running away from app.
        unregisterReceiver(minuteUpdateReceiver);
    }

    public void updateTimer() {
        // Converts milliseconds to seconds.
        int seconds = (int) timeLeftInMilliseconds / 1000;
        // Sets display to current seconds remaining
        timeRemaining.setText(seconds + " seconds remaining...");
    }

    // Button calls this command
    public void openPasscode (View target) {
        openPasscodehistory();
    }


    // Controls button for opening passcode history
    public void openPasscodehistory() {
        /*
         * When pressed, time info is passed through
         * an intent to the other activity and that activity is started
        */
        int year = LocalDateTime.now().getYear();
        int month = LocalDateTime.now().getMonthValue();
        int day = LocalDateTime.now().getDayOfMonth();
        int minutes = LocalDateTime.now().getMinute();
        int seconds = LocalDateTime.now().getSecond();
        int hours = LocalDateTime.now().getHour();

        Intent msg = new Intent(this, PasscodeHistory.class);
        Bundle extras = new Bundle();
        extras.putInt("pass_year", year);
        extras.putInt("pass_month", month);
        extras.putInt("pass_day", day);
        extras.putInt("pass_hours", hours);
        extras.putInt("pass_minute", minutes);
        extras.putInt("pass_second", seconds);
        msg.putExtras(extras);
        startActivity(msg);
    }

}
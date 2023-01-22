package com.example.habittrackerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    // Variables
    protected SharedPreferences sp;
    private boolean darkmode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finds agree button
        Button agreeBtn = (Button) findViewById(R.id.agreeBtn);

        // Agree Button Click
        agreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Starts the login activity
                Intent msg = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(msg);
            }
        });

        /*
          Gets NamePref SharedPreferences to change theme based on dark mode toggle. Otherwise
          the application will only remember the setting when you get to the settings activity.
        */
        sp = getApplicationContext().getSharedPreferences("NamePref", Context.MODE_PRIVATE);
        darkmode = sp.getBoolean("darkmode", false);

        SettingsActivity.changeMode(darkmode);

    }




}
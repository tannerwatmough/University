package com.example.habittrackerfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SettingsActivity extends AppCompatActivity {
    // Variables
    private TextView userLoggedIn, subject, email;
    protected Switch modeSwitch;
    protected SharedPreferences sp;
    private Button logout, send;

    boolean darkmode = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Finds View Objects
        userLoggedIn = (TextView) findViewById(R.id.currentUserTextView);
        subject = (TextView) findViewById(R.id.subjectView);
        email = (TextView) findViewById(R.id.emailView);
        logout = (Button) findViewById(R.id.logoutBtn);
        send = (Button) findViewById(R.id.sendEmailBtn);
        modeSwitch = (Switch) findViewById(R.id.modeToggle);

        // Gets SharedPreferences and gets the current user name and darkmode preference.
        sp = getApplicationContext().getSharedPreferences("NamePref", Context.MODE_PRIVATE);
        String name = sp.getString("name", "");
        darkmode = sp.getBoolean("darkmode", false);


        // If name is blank, set current user to guest, otherwise, set it to the name saved.
        if (name.equals("")) {
            userLoggedIn.setText("Current User: Guest");

        } else {
            userLoggedIn.setText("Current User: " + name);
        }

        // When the Dark Mode toggle is switched
        modeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // if it is activated, change theme to darkmode and save it to sharedPreferences.
                if (b) {
                    changeMode(true);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("darkmode", true);
                    editor.commit();
                } else {
                    // if it is not, change theme to basic and save it to sharedPreferences
                    changeMode(false);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("darkmode", false);
                    editor.commit();
                }
            }
        });

        /*
          Ensures that, if the user selects darkmode and exits app, that the toggle is in the
          appropriate location.
        */
        if (darkmode) {
            modeSwitch.setChecked(true);
        } else {
            modeSwitch.setChecked(false);
        }

        // Changes Mode to light or darkmode, depending on boolean value.
        changeMode(darkmode);


        // On Logout Button Pressed
        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Resets current use text field to Current User: Guest
                userLoggedIn.setText("Current User: Guest");

                // Starts the LoginActivity
                Intent msg = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(msg);
            }
        } );

        // Sends an email using intents
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gets subject and email body fields and stores them in a string
                String sub = subject.getText().toString();
                String body = email.getText().toString();

                // Creates new intent and sends it to the email.
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                // The Recipient Email
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"T00712721@mytru.ca"});
                // The Subject Text
                i.putExtra(Intent.EXTRA_SUBJECT, sub);
                // The Body Text
                i.putExtra(Intent.EXTRA_TEXT, body);
                // Creates an activity for the user to choose which mail app they wish to use
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                }
                // If the user has no email app installed, a toast message is displayed
                catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(SettingsActivity.this,
                            "There are no email clients installed.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    // Switches the app between dark mode theme and light mode.
    protected static void changeMode(boolean darkmode) {
        if (darkmode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

}
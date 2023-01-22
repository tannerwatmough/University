package com.example.habittrackerfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    // Variables
    private TextView enterNameEditText, enterPassEditText;
    private Button loginBtn;
    protected SharedPreferences sp;
    private static final String KEY_NAME = "name_key";
    private static final String KEY_PASS = "pass_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Gets View Objects.
        enterNameEditText = (TextView) findViewById(R.id.enterNameEditText);
        enterPassEditText = (TextView) findViewById(R.id.enterPasswordEditText);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        sp = getSharedPreferences("NamePref", MODE_PRIVATE);

        // Login Button Click
        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Gets System Service for software keyboard
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                // Hides the software keyboard when login is pressed, otherwise it stays open
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                login();
            }
        });

        if (savedInstanceState != null) {
            // If there's a savedInstanceState, restore the text fields with stored variables
            String savedName = savedInstanceState.getString(KEY_NAME);
            String savedPass = savedInstanceState.getString(KEY_PASS);
            enterNameEditText.setText(savedName);
            enterPassEditText.setText(savedPass);
        }
    }

    public void login() {

        /*
           Opens SharedPreferences Editor and adds in the name and password values from the edit
           text. This could be expanded to ensure the username and password match and what settings
           were saved under each user profile.
        */
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("name", enterNameEditText.getText().toString());
        editor.putString("pass", enterPassEditText.getText().toString());
        editor.apply();

        /*
          Checks entered login name and password to see if it matches the "admin" default. If the
          fields are blank, it logs you in as a guest.
         */

        String loginName = enterNameEditText.getText().toString();
        String password = enterPassEditText.getText().toString();

        if (!loginName.equals("")) {
            if (loginName.equals("admin") && password.equals("12345")) {
                // Expandable Toast which will take any login name and create a toast.
                Toast.makeText(LoginActivity.this, "Logged in as " +
                        loginName, Toast.LENGTH_SHORT).show();
                // Intent starts Tracker Activity
                Intent msg = new Intent(LoginActivity.this, TrackerActivity.class);
                startActivity(msg);
            } else {
                // If the name isn't blank but doesn't match admin and 12345, it shows incorrect password.
                Toast.makeText(LoginActivity.this, "Incorrect username or password",
                        Toast.LENGTH_SHORT).show();
            }

        } else {
            // Toast message shows you are loggined in as a guest and starts Tracker Activity
            Toast.makeText(LoginActivity.this, "Logged in as Guest",
                    Toast.LENGTH_SHORT).show();
            Intent msg = new Intent(LoginActivity.this, TrackerActivity.class);
            startActivity(msg);
        }

        // Clears the edit text fields
        enterNameEditText.setText("");
        enterPassEditText.setText("");

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Ensures app name and password stay saved on device orientation.
        savedInstanceState.putString(KEY_NAME, enterNameEditText.getText().toString());
        savedInstanceState.putString(KEY_PASS, enterPassEditText.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }
}
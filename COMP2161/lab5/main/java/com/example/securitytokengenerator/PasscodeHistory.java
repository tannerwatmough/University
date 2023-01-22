/*
 * Name: Tanner Watmough
 * Date: December 8, 2022
 *
 * Assignment 5: Security Token
 */

package com.example.securitytokengenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PasscodeHistory extends AppCompatActivity {
    // Variables
    private ListView passHistory;
    ArrayList<String> list;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode_history);

        // Gets list view for password history
        passHistory = (ListView) findViewById(R.id.passList);

        // Creates a new array and adapter to edit list
        list = new ArrayList<String>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, list);

        // Gets date information from Main Activity when user presses history
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int seconds = extras.getInt("pass_second");
        int minutes = extras.getInt("pass_minute");
        int hours = extras.getInt("pass_hours");
        int day = extras.getInt("pass_day");
        int month = extras.getInt("pass_month");
        int year = extras.getInt("pass_year");

        String monthName = "";

        // Converts month as int to String.
        if (month < 13) {
            switch (month) {
                case 1:
                    monthName = "Jan";
                    break;
                case 2:
                    monthName = "Feb";
                    break;
                case 3:
                    monthName = "Mar";
                    break;
                case 4:
                    monthName = "Apr";
                    break;
                case 5:
                    monthName = "May";
                    break;
                case 6:
                    monthName = "Jun";
                    break;
                case 7:
                    monthName = "Jul";
                    break;
                case 8:
                    monthName = "Aug";
                    break;
                case 9:
                    monthName = "Sep";
                    break;
                case 10:
                    monthName = "Oct";
                    break;
                case 11:
                    monthName = "Nov";
                    break;
                case 12:
                    monthName = "Dec";
                    break;
                default:
                    break;
            }
        }

        // Shared Preference to save previous codes.
        sp = getSharedPreferences("PreviousCodes", Context.MODE_PRIVATE);

        // String to display code date.
        String passDate = monthName + " " + day + ", " + year + "--" + hours + ":" + minutes + ":" +
                seconds;

        // Adds passcode to list.
        list.add(passDate);

        SharedPreferences.Editor editor = sp.edit();

        // Commits previous code to date.
        editor.putString("PreviousCodes", passDate);
        editor.commit();
        Toast.makeText(this, "Password Saved", Toast.LENGTH_SHORT).show();

        // Sets listview adapter.
        passHistory.setAdapter(arrayAdapter);
    }

    public void clearPasswords (View target) {
        // When button pressed, calls clearHistory();
        clearHistory();
    }

    public void clearHistory() {
        // Finds listview and sets adapter to null.
        passHistory = findViewById(R.id.passList);
        passHistory.setAdapter(null);
    }

    // Saved so no info is lost when orientation changes
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        passHistory = findViewById(R.id.passList);
        outState.putStringArrayList("list", list);
    }

    // Saved so no info is lost when orientation changes
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        list = savedInstanceState.getStringArrayList("list");
    }
}
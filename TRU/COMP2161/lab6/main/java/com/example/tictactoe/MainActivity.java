package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creates shared preferences to save previous name1.
        SharedPreferences sp = getApplicationContext().getSharedPreferences("NamePrefs", Context.MODE_PRIVATE);
        String name1 = sp.getString("name1", "");

        // Flash message to welcome user back.
        name1 = "Welcome back " + name1;

        Toast.makeText(this, name1, Toast.LENGTH_SHORT).show();
    }

    // Opens Enter Name Activity
    public void openEnterName(View target) {
        Intent msg = new Intent (this, EnterName.class);
        startActivity(msg);
    }

    // Opens Play Game Activity
    public void openGame(View target) {

        Intent msg = new Intent (this, PlayGame.class);
        startActivity(msg);
    }

    // Opens Standings
    public void openStandings(View target) {
        Intent msg = new Intent (this, ShowStanding.class);
        startActivity(msg);
    }
}
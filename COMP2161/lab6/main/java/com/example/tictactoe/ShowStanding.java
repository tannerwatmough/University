package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowStanding extends AppCompatActivity {
    // Variables
    private ListView listView;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_standing);

        // Gets names SharedPreference to put names in leaderboard
        SharedPreferences sp = getApplicationContext().getSharedPreferences("NamePrefs", Context.MODE_PRIVATE);
        String name1 = sp.getString("name1", "");
        String name2 = sp.getString("name2", "");

        // Finds list view
        listView = findViewById(R.id.standingsList);

        // Array initialization and adaption
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, arrayList);
        listView.setAdapter(adapter);

        // Attempt at populating wins section of board
        SharedPreferences sp2 = getApplicationContext().getSharedPreferences("Wins", Context.MODE_PRIVATE);
        int compWins = sp2.getInt("compScore", 0);
        int play1Wins = sp2.getInt("play1Score", 0);
        int play2Wins = sp2.getInt("play2Score", 0);

        // Combines name strings and wins
        String android = "Android" + " Wins: " + compWins;
        name1 = name1 + " Wins: " + play1Wins;
        name2 = name2 + " Wins: " + play2Wins;

        // Adds items onto array
        arrayList.add(android);
        arrayList.add(name1);
        // If name2 isn't blank, add them to list, otherwise ignore.
        if (!name2.equals(" Wins: 0")) {
            arrayList.add(name2);
        }
        adapter.notifyDataSetChanged();


    }

}
package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayGame extends AppCompatActivity {

    // Variables (Object TicTacBoard)
    private TicTacBoard ticTacBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);


        // Finds playAgainBtn and playerTurn TextView
        Button playAgainBtn = findViewById(R.id.playAgainBtn);
        TextView playerTurn = findViewById(R.id.playerTurnDisplay);

        // Saves names for use in program.
        SharedPreferences sp = getApplicationContext().getSharedPreferences("NamePrefs", Context.MODE_PRIVATE);
        String name1 = sp.getString("name1", "");
        String name2 = sp.getString("name2", "");

        // Turns off play again button when initially loading activity.
        playAgainBtn.setVisibility(View.GONE);

        // Puts two names in array
        String[] playerNames = {name1, name2};

        // If user entered player names, do...
        if (playerNames != null) {
            playerTurn.setText((playerNames[0] + "'s Turn"));
        }
        // Otherwise it uses the generic Player 1/2 name in other class

        // Finds board
        ticTacBoard = findViewById(R.id.ticTacBoard);

        // Runs setup on the board.
        ticTacBoard.setUpGame(playAgainBtn, playerTurn, playerNames);

    }

    public void playAgain(View view) {
        // Resets the game logic and board canvas
        ticTacBoard.resetGame();
        ticTacBoard.invalidate();
    }

}
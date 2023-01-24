package com.example.tictactoe;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLogic {
    // Variables and 3D array representing board.
    private int[][] gameBoard;

    // Default player names if none chosen.
    private String[] playerNames = {"Player 1", "Player 2"};

    private Button playAgainBtn;
    private TextView playerTurn;

    private int player = 1;
    private int play1Wins = 0, play2Wins = 0, compWins = 0;

    // Constructor for board (3x3 grid)
    GameLogic() {
        gameBoard = new int[3][3];
        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                gameBoard[r][c] = 0;
            }
        }
    }

    // Updates board
    public boolean updateGameBoard(int row, int col) {
        if (gameBoard[row-1][col-1] == 0){
            gameBoard[row-1][col-1] = player;
            // Determines player turn.
            if (player == 1){
                playerTurn.setText((playerNames[1] + "'s Turn"));
            } else {
                playerTurn.setText((playerNames[0] + "'s Turn"));
            }

            return true;
        }
        else {
            return false;
        }
    }

    // Checks if there's a winner
    public boolean winnerCheck() {
        boolean isWinner = false;

        // Checks the rows for three in a row
        for (int r = 0; r < 3; r++) {
            if (gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] &&
                gameBoard[r][0] != 0){
                isWinner = true;
            }
        }

        // Checks the columns for three in a column.
        for (int c = 0; c < 3; c++) {
            if (gameBoard[0][c] == gameBoard[1][c] && gameBoard[2][c] == gameBoard[0][c] &&
                    gameBoard[0][c] != 0){
                isWinner = true;
            }
        }

        // Checks Diagonals
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] &&
                gameBoard[0][0] != 0){
            isWinner = true;
        }

        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] &&
                gameBoard[2][0] != 0){
            isWinner = true;

        }

        // Checks if board is filled
        int boardFilled = 0;

        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                if (gameBoard[r][c] != 0) {
                    boardFilled += 1;
                }
            }
        }

        // Sets play again button to visible if there's a winner and displays player name won!
        if (isWinner) {
            playAgainBtn.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player-1] + " Won!"));

            if (playerNames[player-1] == playerNames[0]) {
                // If player 1 won, add 1 to their win count.
                play1Wins += 1;
            } else if (playerNames[player-1] == playerNames[0]) {
                // If player 2 won, add 1 to their win count
                play2Wins += 1;
            } else {
                // If computer wins, add 1 to their win count (NO AI IMPLEMENTED RAN OUT OF TIME)
                compWins += 1;
            }
            return true;

        } else if(boardFilled == 9) {
            // If no winner and board is filled, it's a draw.
            playAgainBtn.setVisibility(View.VISIBLE);
            playerTurn.setText("Tie");
            return true;
        } else {
            return false;
        }
    }

    public void resetGame() {
        // Resets all grid squares to 0.
        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                gameBoard[r][c] = 0;
            }
        }

        player = 1; // Makes it player 1's turn.

        playAgainBtn.setVisibility(View.GONE); // Hides the play again button (active game)

        playerTurn.setText((playerNames[0] + "'s turn")); // Puts text to player 1's turn.
    }
    // Setter Methods
    public void setPlayAgainBtn(Button playAgainBtn) {
        this.playAgainBtn = playAgainBtn;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    // Getter Methods
    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

}

package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class TicTacBoard extends View {
    // Variables
    private final int boardColor;
    private final int XColor;
    private final int OColor;
    private final int winningLineColor;

    private boolean winningLine = false;

    private int cellSize = getWidth() / 3;

    private final Paint paint = new Paint();

    protected final GameLogic game;

    public TicTacBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // Creates new game object
        game = new GameLogic();

        // Gets typed array for drawing themes for custom view.
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.TicTacBoard, 0, 0);

        // Gets custom styles for board
        try {
            boardColor = a.getInteger(R.styleable.TicTacBoard_boardColor, 0);
            XColor = a.getInteger(R.styleable.TicTacBoard_XColor, 0);
            OColor = a.getInteger(R.styleable.TicTacBoard_OColor, 0);
            winningLineColor = a.getInteger(R.styleable.TicTacBoard_winningLineColor, 0);

        } finally {
            a.recycle();
        }


    }

    @Override
    protected void onMeasure(int width, int height) {
        // Measures device and sets cell size appropriately to smallest dimension
        super.onMeasure(width, height);

        int dimension = Math.min(getMeasuredWidth(), getMeasuredHeight());
        cellSize = dimension / 3;

        // Sets dimension to smallest and creates a square
        setMeasuredDimension(dimension, dimension);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Sets drawing style and draws the board and markers.
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        drawBoard(canvas);
        drawMarkers(canvas);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Gets X and Y of tap
        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();

        // Sees if tap was down
        if (action == MotionEvent.ACTION_DOWN) {
            // Determines row and column based on tap location and cell size for screen
            int row = (int) Math.ceil(y/cellSize);
            int col = (int) Math.ceil(x/cellSize);

            // Occurs only if there is not a winning line yet
            if (!winningLine){
                if (game.updateGameBoard(row, col)) {
                    // Clears board
                    invalidate();

                    if (game.winnerCheck()){
                        // Clears board if there's a winner.
                        winningLine = true;
                        invalidate();
                    }

                    // Updates player turn as player 2 will equal 0, resetting to player 1
                    if (game.getPlayer() % 2 == 0) {
                        game.setPlayer(game.getPlayer()-1);
                    } else {
                        // If player 1 went, add 1, get player 2.
                        game.setPlayer(game.getPlayer()+1);
                    }
                }
            }

            // Clears board
            invalidate();

            return true;
        }

        return false;
    }

    private void drawBoard(Canvas canvas) {
        // Draws board, intersecting grid.
        paint.setColor(boardColor);
        paint.setStrokeWidth(14);

        for (int c = 1; c < 3; c++ ) {
            canvas.drawLine(cellSize * c, 0, cellSize * c, canvas.getWidth(), paint);
        }

        for (int r = 1; r < 3; r++ ) {
            canvas.drawLine(0, cellSize * r, canvas.getWidth(), cellSize * r, paint);
        }
    }

    private void drawMarkers(Canvas canvas) {
        // Allows placing markers only if the square is empty (not a 0)
        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                if (game.getGameBoard()[r][c] != 0) {
                     if (game.getGameBoard()[r][c] == 1) {
                         drawX(canvas, r, c);
                     } else {
                         drawO(canvas, r, c);
                     }
                }
            }
        }
    }

    private void drawX(Canvas canvas, int row, int col) {
        paint.setColor(XColor);
        // Draws the two intersecting lines to make an X.

        canvas.drawLine((float) ((col+1)*cellSize - cellSize * 0.2),
                        (float) (row*cellSize + cellSize * 0.2),
                        (float) (col*cellSize + cellSize * 0.2),
                        (float)((row+1)*cellSize - cellSize * 0.2),
                        paint);

        canvas.drawLine((float) (col*cellSize + cellSize * 0.2),
                        (float) (row*cellSize + cellSize * 0.2),
                        (float) ((col+1)*cellSize - cellSize * 0.2),
                        (float)((row+1)*cellSize - cellSize * 0.2),
                        paint);

    }

    private void drawO(Canvas canvas, int row, int col) {
        paint.setColor(OColor);
        // Draws the O
        canvas.drawOval((float)(col*cellSize + cellSize * 0.2), (float)(row*cellSize + cellSize * 0.2),
                (float)((col*cellSize + cellSize) - cellSize * 0.2),
                (float)((row*cellSize + cellSize) - cellSize * 0.2), paint);
    }

    public void setUpGame(Button playAgain, TextView playerDisplay, String[] names) {
        // Sets up game
        game.setPlayAgainBtn(playAgain);
        game.setPlayerTurn(playerDisplay);
        game.setPlayerNames(names);
    }

    public void resetGame(){
        // Resets game object and sets winningLine to false so you can place markers again
        game.resetGame();
        winningLine = false;
    }

}

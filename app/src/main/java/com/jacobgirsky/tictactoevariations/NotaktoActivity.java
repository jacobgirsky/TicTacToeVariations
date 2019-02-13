package com.jacobgirsky.tictactoevariations;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NotaktoActivity extends AppCompatActivity implements View.OnClickListener {
    // board 1 array declaration:
    int[][] board1_ids = new int[][]{{R.id.b_00, R.id.b_01, R.id.b_02},
            {R.id.b_10, R.id.b_11, R.id.b_12}, {R.id.b_20, R.id.b_21, R.id.b_22}
    };
    // board 2 array declaration:
    int[][] board2_ids = new int[][]{{R.id.bu_00, R.id.bu_01, R.id.bu_02},
            {R.id.bu_10, R.id.bu_11, R.id.bu_12}, {R.id.bu_20, R.id.bu_21, R.id.bu_22}
    };
    // board 3 array declaration:
    int[][] board3_ids = new int[][]{{R.id.bt_00, R.id.bt_01, R.id.bt_02},
            {R.id.bt_10, R.id.bt_11, R.id.bt_12}, {R.id.bt_20, R.id.bt_21, R.id.bt_22}
    };

    int piecesPlayed = 0;
    private final int PURPLE = 0xAAA600FF;
    private long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_notakto);

        // get the ids for board 1,2,and 3 buttons:
        getIds(board1_ids);
        getIds(board2_ids);
        getIds(board3_ids);

    }

    @Override
    public void onClick(View view) {
        TextView winner_text = (TextView) findViewById(R.id.winner_textView);
        TextView turnText = (TextView) findViewById(R.id.player_textView);
        turnText.setText("Player 1 turn");
        String turn = "";
        boolean board1_dead, board2_dead, board3_dead;

        TextView board1_tv = findViewById(R.id.board1_textView);
        board1_dead = isBoardDead(board1_ids, view, board1_tv);

        TextView board2_tv = findViewById(R.id.board2_textView);
        board2_dead = isBoardDead(board2_ids, view, board2_tv);

        TextView board3_tv = findViewById(R.id.board3_textView);
        board3_dead = isBoardDead(board3_ids, view, board3_tv);

        if (board1_dead && board2_dead && board3_dead) {
            turnText.setText("GAME OVER!");
            if (turn == "player2") {

                winner_text.setText("Player 1 Loses!");
            } else {
                winner_text.setText("Player 2 Loses!");
            }

        }
    }

    // this function prevents the user from exiting the game.
    @Override
    public void onBackPressed() {
        long t = System.currentTimeMillis();
        if (t - backPressedTime > 4000) {
            backPressedTime = t;
            Toast.makeText(this, "Press back again to leave the game",
                    Toast.LENGTH_LONG).show();
        } else {
            super.onBackPressed();
        }
    }


    private void getIds(int[][] ids) {
        for (int row = 0; row < ids.length; row++) {
            for (int col = 0; col < ids.length; col++) {
                Button button = findViewById(ids[row][col]);
                button.setText("");
                button.setOnClickListener(this);
            }
        }
    }

    private boolean isBoardDead(int[][] ids, View view, View board_tv) {
        boolean isDead = false;
        TextView turnText = (TextView) findViewById(R.id.player_textView);
        String turn = "";
        for (int row = 0; row < ids.length; row++) {
            for (int col = 0; col < ids.length; col++) {
                Button button = (Button) view;
                button.setText("X");
                button.setTextColor(Color.BLACK);
                TextView tv = (TextView) board_tv;
                if (button.isClickable() == true) {
                    piecesPlayed++;
                    button.setClickable(false);
                }
                turn = setTurn(piecesPlayed, turnText);

                if (isHorizonatalWin(ids) || isVerticalWin(ids) || isDiagonalRightWin(ids) || isDiagonalLeftWin(ids)) {
                    setEnabled(ids, tv);
                    isDead = true;

                } else {
                    isDead = false;
                }
            }
        }
        return isDead;
    }

    private void setEnabled(int[][] ids, View v) {

        for (int row = 0; row < ids.length; row++) {
            for (int col = 0; col < ids.length; col++) {
                Button button = findViewById(ids[row][col]);
                button.setClickable(false);
            }
            TextView tv = (TextView) v;
            tv.setText("DEAD BOARD");
            tv.setTextColor(Color.RED);

        }
    }

    private String setTurn(int piecesPlayed, View turn_v) {
        String turn = "";
        TextView tv = (TextView) turn_v;
        if (piecesPlayed % 2 == 0) {
            turn = "player1";
            tv.setTextColor(Color.GREEN);
            tv.setText("Player 1 turn");
        } else {
            turn = "player2";
            tv.setTextColor(Color.YELLOW);
            tv.setText("Player 2 turn");
        }
        return turn;
    }

    private boolean isHorizonatalWin(int[][] ids) {
        boolean win = false;
        int numOfMatchElements = 0;
        Button button;
        for (int row = 0; row < ids.length; row++) {
            numOfMatchElements = 0;
            for (int col = 1; col < (ids[row].length); col++) {
                Button button1 = findViewById(ids[row][col]);
                Button button2 = findViewById(ids[row][col - 1]);
                //Log.i("message", "row is " + row + " column is " + col + image1.getBackground());
                if ((button1.getText().equals("X")) && (button2.getText().equals("X"))) {
                    // if (button1.getText().equals(button2.getText())) {
                    //Log.i("message", "TRUE ==== here " + row + " " + col);
                    numOfMatchElements += 1;
                    //  }
                }
                if (numOfMatchElements == 2) {
                    return true;
                } else {
                    continue;
                }
            }
        }
        return win;
    }

    private boolean isVerticalWin(int[][] ids) {
        boolean win = false;
        int numOfMatchElements;
        for (int col = 0; col < ids.length; col++) {
            numOfMatchElements = 0;
            for (int row = 1; row < (ids[col].length); row++) {
                Button button1 = findViewById(ids[row][col]);
                Button button2 = findViewById(ids[row - 1][col]);
                if ((button1.getText().equals("X")) && (button2.getText().equals("X"))) {
                    // if (button1.getText().equals(button2.getText())) {
                    //Log.i("message", "TRUE ==== here " + row + " " + col);
                    numOfMatchElements += 1;
                    //    }
                }
                if (numOfMatchElements == 2) {
                    return true;
                } else {
                    continue;
                }
            }
        }
        return win;
    }


    private boolean isDiagonalRightWin(int[][] ids) {
        boolean win = false;
        int numOfMatchElements = 0;
        for (int row = 1, col = 1; row < ids.length; row++, col++) {
            Button button1 = findViewById(ids[row][col]);
            Button button2 = findViewById(ids[row - 1][col - 1]);
            if ((button1.getText().equals("X")) && (button2.getText().equals("X"))) {
                // if (button1.getText().equals(button2.getText())) {
                //Log.i("message", "TRUE ==== here " + row + " " + col);
                numOfMatchElements += 1;
                //  }
            }
        }
        if (numOfMatchElements == 2) {
            win = true;
        } else {
            win = false;
        }
        return win;
    }

    private boolean isDiagonalLeftWin(int[][] ids) {
        boolean win = false;
        int numOfMatchElements = 0;
        for (int row = 1, col = 1; row < ids.length; row++, col--) {
            Button button1 = findViewById(ids[row][col]);
            Button button2 = findViewById(ids[row - 1][col + 1]);
            if ((button1.getText().equals("X")) && (button2.getText().equals("X"))) {
                // if (button1.getText().equals(button2.getText())) {
                //Log.i("message", "TRUE ==== here " + row + " " + col);
                numOfMatchElements += 1;
                // }
            }
        }
        if (numOfMatchElements == 2) {
            win = true;
        } else {
            win = false;
        }
        return win;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    public void onResume() {
        super.onResume();
    }
}









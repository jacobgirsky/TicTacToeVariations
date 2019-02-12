package com.jacobgirsky.tictactoevariations;

import android.graphics.Color;
import android.hardware.camera2.params.BlackLevelPattern;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NotaktoActivity extends AppCompatActivity implements View.OnClickListener {
    // board 1 arraylist:
    int[][] board1_ids = new int[][]{{R.id.b_00, R.id.b_01, R.id.b_02},
            {R.id.b_10, R.id.b_11, R.id.b_12}, {R.id.b_20, R.id.b_21, R.id.b_22}
    };

    int[][] board2_ids = new int[][]{{R.id.bu_00, R.id.bu_01, R.id.bu_02},
            {R.id.bu_10, R.id.bu_11, R.id.bu_12}, {R.id.bu_20, R.id.bu_21, R.id.bu_22}
    };

    int[][] board3_ids = new int[][]{{R.id.bt_00, R.id.bt_01, R.id.bt_02},
            {R.id.bt_10, R.id.bt_11, R.id.bt_12}, {R.id.bt_20, R.id.bt_21, R.id.bt_22}
    };

    int piecesPlayed = 0;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_notakto);

        // get the ids for board 1 buttons:
        for (int row = 0; row < board1_ids.length; row++) {
            for (int col = 0; col < board1_ids.length; col++) {
                Button button = findViewById(board1_ids[row][col]);
                button.setText("");
                button.setOnClickListener(this);
            }
        }
        // get the ids for board 2 buttons
        for (int row = 0; row < board2_ids.length; row++) {
            for (int col = 0; col < board2_ids.length; col++) {
                Button button = findViewById(board2_ids[row][col]);
                button.setOnClickListener(this);
            }
        }
        // get the ids for board 3 buttons
        for (int row = 0; row < board3_ids.length; row++) {
            for (int col = 0; col < board3_ids.length; col++) {
                Button button = findViewById(board3_ids[row][col]);
                button.setOnClickListener(this);
            }
        }
       // Log.i("message", "TRUE ==== here " + board1_ids.length);


    }

    @Override
    public void onClick(View view) {
        TextView winner_text = (TextView) findViewById(R.id.winner_textView);
        TextView player_text = (TextView) findViewById(R.id.player_textView);
        player_text.setText("Player 1 turn");
        String turn = "";

        for (int row = 0; row < board1_ids.length; row++) {
            for (int col = 0; col < board1_ids.length; col++) {
                Button button = (Button) view;
                button.setText("X");
                button.setTextColor(Color.BLACK);

                if (button.isClickable() == true) {
                    piecesPlayed++;
                    button.setClickable(false);
                }

                if (piecesPlayed % 2 == 0) {
                    turn = "player1";
                    player_text.setText("Player 1 turn");
                } else {
                    turn = "player2";
                    player_text.setText("Player 2 turn");
                }

                TextView tv = findViewById(R.id.board1_textView);
                if (isHorizonatalWin(board1_ids) || isVerticalWin(board1_ids) || isDiagonalRightWin(board1_ids) || isDiagonalLeftWin(board1_ids)) {
                    setEnabled(board1_ids, tv);
                    if (tv.getText() == "DEAD BOARD") {
                        i++;
                    }
                    Log.i("message", "TRUE ======================== here " + i);
                    if (i == 3) {
                        if (turn == "player2") {
                            winner_text.setText("Player 1 Loses!");
                        } else {
                            winner_text.setText("Player 2 Loses!");
                        }
                    }

                } else {
                    continue;
                }
            }
        }

        for (int row = 0; row < board2_ids.length; row++) {
            for (int col = 0; col < board2_ids.length; col++) {
                Button button = (Button) view;
                button.setText("X");
                button.setTextColor(Color.BLACK);

                if (button.isClickable() == true) {
                    piecesPlayed++;
                    button.setClickable(false);
                }

                if (piecesPlayed % 2 == 0) {
                    turn = "player1";
                    player_text.setText("Player 1 turn");
                } else {
                    turn = "player2";
                    player_text.setText("Player 2 turn");
                }

                TextView tv = findViewById(R.id.board2_textView);
                if (isHorizonatalWin(board2_ids) || isVerticalWin(board2_ids) || isDiagonalRightWin(board2_ids) || isDiagonalLeftWin(board2_ids)) {
                    setEnabled(board2_ids, tv);
                    if (tv.getText() == "DEAD BOARD") {
                        i++;
                    }
                    Log.i("message", "TRUE ======================== here " + i);
                    if (i == 3) {
                        if (turn == "player2") {
                            winner_text.setText("Player 1 Loses!");
                        } else {
                            winner_text.setText("Player 2 Loses!");
                        }
                    }

                } else {
                    continue;
                }
            }
        }


        for (int row = 0; row < board3_ids.length; row++) {
            for (int col = 0; col < board3_ids.length; col++) {
                Button button = (Button) view;
                button.setText("X");
                button.setTextColor(Color.BLACK);

                if (button.isClickable() == true) {
                    piecesPlayed++;
                    button.setClickable(false);
                }

                if (piecesPlayed % 2 == 0) {
                    turn = "player1";
                    player_text.setText("Player 1 turn");
                } else {
                    turn = "player2";
                    player_text.setText("Player 2 turn");
                }

                TextView tv = findViewById(R.id.board3_textView);
                if (isHorizonatalWin(board3_ids) || isVerticalWin(board3_ids) || isDiagonalRightWin(board3_ids) || isDiagonalLeftWin(board3_ids)) {
                    setEnabled(board3_ids, tv);
                    if (tv.getText() == "DEAD BOARD") {
                        i++;
                    }
                    Log.i("message", "TRUE ======================== here " + i);
                    if (i == 3) {
                        if (turn == "player2") {
                            winner_text.setText("Player 1 Loses!");
                        } else {
                            winner_text.setText("Player 2 Loses!");
                        }
                    }

                } else {
                    continue;
                }
               /* boolean isWin = isHorizonatalWin();
                if (isWin) {
                    if (turn == "player2") {
                        winner_text.setText("Player 1 Loses!");
                    } else {
                        winner_text.setText("Player 2 Loses!");
                    }
                    setEnabled(board1_ids,tv);
                } else {
                    isWin = isVerticalWin();
                    if (isWin) {
                        if (turn == "player2") {
                            winner_text.setText("Player 1 Loses!");
                        } else {
                            winner_text.setText("Player 2 Loses!");
                        }
                        setEnabled(board1_ids,tv);
                    } else {
                        isWin = isDiagonalRightWin();
                        if (isWin) {
                            if (turn == "player2") {
                                winner_text.setText("Player 1 Loses!");
                            } else {
                                winner_text.setText("Player 2 Loses!");
                            }
                            setEnabled(board1_ids,tv);
                        } else {
                            isWin = isDiagonalLeftWin();
                            if (isWin) {
                                if (turn == "player2") {
                                    winner_text.setText("Player 1 Loses!");
                                } else {
                                    winner_text.setText("Player 2 Loses!");
                                }
                                setEnabled(board1_ids,tv);
                            }
                        }
                    }
                }*/
            }
        }
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

}






package com.jacobgirsky.tictactoevariations;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// shows the turns of the players
enum GameTurn {
    PLAYER_1,
    PLAYER_2
}

public class Misere_avtivity extends Activity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];
    private int roundCount = 0;
    private int player1Points;
    private int player2Points;


    GameTurn turn = GameTurn.PLAYER_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misere_avtivity);

        // get the ids for all the buttons
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }

        // onClick for the reset button
        Button b = findViewById(R.id.reset_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }

    @Override
    public void onClick(View v) {
        TextView textView = findViewById(R.id.player_turn_tv);
        TextView tv = findViewById(R.id.winnter_tv);

        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (turn == GameTurn.PLAYER_1) {
            textView.setText("Turn: Player 1");
            ((Button) v).setText("X");
            ((Button)v).setTextSize(30);
            ((Button) v).setTextColor(Color.RED);
            turn = GameTurn.PLAYER_2;

        } else if (turn == GameTurn.PLAYER_2) {
            textView.setText("Turn: Player 2");
            ((Button) v).setText("O");
            ((Button) v).setTextSize(30);
            ((Button) v).setTextColor(Color.BLUE);
            turn = GameTurn.PLAYER_1;
        }

            roundCount++;

            if (checkForWin()) {
                if (turn == GameTurn.PLAYER_1) {
                    player1Points++;
                    Toast.makeText(this, "Player 1 loses!", Toast.LENGTH_SHORT).show();
                    tv.setText("Player 1 loses!!");
                    //reset();
                } else {
                    Toast.makeText(this, "Player 2 loses!", Toast.LENGTH_SHORT).show();
                    tv.setText("Player 2 loses!!");
                }
            }
            if (roundCount == 9) {
                Toast.makeText(this, "It's a tie!!!", Toast.LENGTH_SHORT).show();
            }
        }


    private boolean checkForWin() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }

        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }

        return false;
    }


    private void reset() {
        findViewById(R.id.player_turn_tv);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                roundCount = 0;
                TextView tv = findViewById(R.id.player_turn_tv);
                TextView textView = findViewById(R.id.winnter_tv);
                textView.setText("");
                tv.setText("Turn: Player 1");
            }
        }
    }
}

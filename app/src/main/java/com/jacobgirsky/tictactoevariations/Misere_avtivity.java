package com.jacobgirsky.tictactoevariations;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

enum GameTurn {
    PLAYER_1,
    PLAYER_2
}

public class Misere_avtivity extends Activity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];
    private int roundCount = 0;


    GameTurn turn = GameTurn.PLAYER_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misere_avtivity);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }

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

        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (turn == GameTurn.PLAYER_1) {
            textView.setText("Turn: Player 1");
            ((Button) v).setText("X");
            ((Button) v).setTextColor(Color.RED);
            turn = GameTurn.PLAYER_2;

        } else if (turn == GameTurn.PLAYER_2) {
            textView.setText("Turn: Player 2");
            ((Button) v).setText("O");
            ((Button) v).setTextColor(Color.BLUE);
            turn = GameTurn.PLAYER_1;

            roundCount++;

            if (checkForWin()) {
                textView.setText("Player 1 wins!!");
                Toast.makeText(this, "Player 1 Wins!!", Toast.LENGTH_LONG).show();
            } else if (roundCount == 36) {
                Toast.makeText(this, "Player 2 wins!!", Toast.LENGTH_LONG).show();
            }
        }

    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        return true;
    }

    private void reset() {
        findViewById(R.id.player_turn_tv);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                roundCount = 0;
                TextView tv = findViewById(R.id.player_turn_tv);
                tv.setText("Turn: Player 1");
            }
        }
    }
}

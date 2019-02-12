package com.jacobgirsky.tictactoevariations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotaktoActivity extends AppCompatActivity implements View.OnClickListener{
     // board 1 arraylist:
    int[][] board1_ids = new int[][]{{R.id.b_00, R.id.b_01, R.id.b_02},
            {R.id.b_10, R.id.b_11, R.id.b_12},{ R.id.b_20, R.id.b_21, R.id.b_22}
    };

    int[][] board2_ids = new int[][]{{R.id.bu_00, R.id.bu_01, R.id.bu_02},
            {R.id.bu_10, R.id.bu_11, R.id.bu_12},{ R.id.bu_20, R.id.bu_21, R.id.bu_22}
    };

    int[][] board3_ids = new int[][]{{R.id.bt_00, R.id.bt_01, R.id.bt_02},
            {R.id.bt_10, R.id.bt_11, R.id.bt_12},{ R.id.bt_20, R.id.bt_21, R.id.bt_22}
    };

    int piecesPlayed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_notakto);

        // get the ids for all the buttons

        for (int row = 0; row < board1_ids.length; row++) {
            for (int col = 0; col < board1_ids.length; col++) {
                Button button = findViewById(board1_ids[row][col]);
                button.setOnClickListener(this);
            }
        }

        for (int row = 0; row < board2_ids.length; row++) {
            for (int col = 0; col < board2_ids.length; col++) {
                Button button = findViewById(board2_ids[row][col]);
                button.setOnClickListener(this);
            }
        }

        for (int row = 0; row < board3_ids.length; row++) {
            for (int col = 0; col < board3_ids.length; col++) {
                Button button = findViewById(board3_ids[row][col]);
                button.setOnClickListener(this);
            }
        }
        Log.i("message", "TRUE ==== here " + board1_ids.length);


    }

    @Override
    public void onClick(View view) {
        TextView winner_text = (TextView) findViewById(R.id.winner_textView);
        TextView player_text = (TextView) findViewById(R.id.player_textView);
        player_text.setText("PLAYER 1");

        for (int row = 0, col = 0; row < board1_ids.length; row++, col++) {
            Button button = (Button) view;
            button.setText("X");

            if (button.isClickable() == true) {
                piecesPlayed++;
                button.setClickable(false);
            }

            if(piecesPlayed % 2 == 0){
                player_text.setText("Player 1 turn");
            }else{
                player_text.setText("Player 2 turn");
            }
        }



    }
}

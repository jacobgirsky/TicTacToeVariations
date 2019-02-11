package com.jacobgirsky.tictactoevariations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NotaktoActivity extends AppCompatActivity implements View.OnClickListener{

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

    }

    @Override
    public void onClick(View view) {
        TextView winner_text = (TextView) findViewById(R.id.winner_textView);
        TextView player_text = (TextView) findViewById(R.id.player_textView);
        player_text.setText("PLAYER 1");


    }
}

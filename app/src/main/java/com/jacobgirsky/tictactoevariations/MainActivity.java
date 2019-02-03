package com.jacobgirsky.tictactoevariations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // code to handle the how to button being pressed
        findViewById(R.id.how_to_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHowTo();
            }
        });

        findViewById(R.id.game1_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGame1();
            }
        });

        findViewById(R.id.game2_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGame2();
            }
        });
    }

    // Intent to open up the how to play activity
    private void goToHowTo() {
        Intent intent = new Intent(getApplicationContext(), activity_how_to.class);
        startActivity(intent);
    }

    // Intent to open up the how to play activity
    private void goToGame1() {
        Intent intent = new Intent(getApplicationContext(), NotaktoActivity.class);
        startActivity(intent);
    }

    // Intent to open up the how to play activity
    private void goToGame2() {
        Intent intent = new Intent(getApplicationContext(), Misere_avtivity.class);
        startActivity(intent);
    }
}

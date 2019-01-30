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

        findViewById(R.id.how_to_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHowTo();
            }
        });
    }

    private void goToHowTo() {
        Intent intent = new Intent(getApplicationContext(), activity_how_to.class);
        startActivity(intent);
    }
}

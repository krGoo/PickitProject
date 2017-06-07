package com.cookandroid.pickit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PauseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause);
        final Button returnlevel = (Button) findViewById(R.id.returnlevel);
        final Button option = (Button) findViewById(R.id.option);
        final Button quit = (Button) findViewById(R.id.quitandgoselect);

        returnlevel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                Intent intent_5 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_5);

            }
        });

        option.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                Intent intent_6 = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent_6);

            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                Intent intent_7 = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent_7);

            }
        });
    }

}

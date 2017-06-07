package com.cookandroid.pickit;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cookandroid.pickit.ExitActivity;
import com.cookandroid.pickit.ModeActivity;
import com.cookandroid.pickit.R;

public class StartActivity extends AppCompatActivity implements  AccessibleAnotherActivity{
    static Activity thisActivity;
    protected void onCreate(Bundle savedInstanceState) {
        thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final Button start = (Button) findViewById(R.id.start2);
        final Button exit = (Button) findViewById(R.id.exit);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                Intent intent_2 = new Intent(getApplicationContext(), ModeActivity.class);
                startActivity(intent_2);

            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_1 = new Intent(getApplicationContext(), ExitActivity.class);
                startActivity(intent_1);

            }
        });

    }
}

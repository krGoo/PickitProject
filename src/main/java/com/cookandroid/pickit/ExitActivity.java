package com.cookandroid.pickit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        final Button yes = (Button) findViewById(R.id.YES);
        final Button no = (Button) findViewById(R.id.NO);

        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                StartActivity.thisActivity.finish();
      }
        });
    }
}

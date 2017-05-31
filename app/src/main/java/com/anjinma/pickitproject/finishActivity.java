package com.anjinma.pickitproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class finishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        final Button start = (Button) findViewById(R.id.button);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}

package com.anjinma.pickitproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final Button start = (Button) findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                Intent intent_2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_2);

            }
        });
    }
}

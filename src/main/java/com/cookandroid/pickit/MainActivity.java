package com.cookandroid.pickit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private long lastTimeBackPressed;


    BallClass thisStage = new BallClass(0);


    @Override
    public void onBackPressed(){
        if(System.currentTimeMillis()-lastTimeBackPressed<1500){
            Toast.makeText(this,"게임포기",Toast.LENGTH_SHORT).show();
            finish();
            Intent intent_1 = new Intent(this, StartActivity.class);
            startActivity(intent_1);
        }
        Toast.makeText(this,"(뒤로) 버튼을 한번 더 누르면 게임이 포기됩니다",Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();
    }

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<ArrayList<Button>> dontseeButton = new ArrayList<ArrayList<Button>>();
        final ArrayList<ArrayList<Button>> buttonMap = new ArrayList<ArrayList<Button>>();
        final ArrayList<ArrayList<ArrayList<Button>>> queueMap = new ArrayList<ArrayList<ArrayList<Button>>>();


        buttonMap.add(new ArrayList<Button>());
        buttonMap.get(0).add((Button) findViewById(R.id.button1));
        buttonMap.get(0).add((Button) findViewById(R.id.button2));
        buttonMap.get(0).add((Button) findViewById(R.id.button3));
        buttonMap.get(0).add((Button) findViewById(R.id.button4));
        buttonMap.add(new ArrayList<Button>());
        buttonMap.get(1).add((Button) findViewById(R.id.button5));
        buttonMap.get(1).add((Button) findViewById(R.id.button6));
        buttonMap.get(1).add((Button) findViewById(R.id.button7));
        buttonMap.get(1).add((Button) findViewById(R.id.button8));
        buttonMap.add(new ArrayList<Button>());
        buttonMap.get(2).add((Button) findViewById(R.id.button9));
        buttonMap.get(2).add((Button) findViewById(R.id.button10));
        buttonMap.get(2).add((Button) findViewById(R.id.button11));
        buttonMap.get(2).add((Button) findViewById(R.id.button12));
        buttonMap.add(new ArrayList<Button>());
        buttonMap.get(3).add((Button) findViewById(R.id.button13));
        buttonMap.get(3).add((Button) findViewById(R.id.button14));
        buttonMap.get(3).add((Button) findViewById(R.id.button15));
        buttonMap.get(3).add((Button) findViewById(R.id.button16));

        queueMap.add(new ArrayList<ArrayList<Button>>());
        queueMap.get(0).add(new ArrayList<Button>());
        queueMap.get(0).add(new ArrayList<Button>());
        queueMap.get(0).get(0).add((Button) findViewById(R.id.QueueButton1_1));
        queueMap.get(0).get(0).add((Button) findViewById(R.id.QueueButton1_2));
        queueMap.get(0).get(1).add((Button) findViewById(R.id.QueueButton1_3));
        queueMap.get(0).get(1).add((Button) findViewById(R.id.QueueButton1_4));
        queueMap.add(new ArrayList<ArrayList<Button>>());
        queueMap.get(1).add(new ArrayList<Button>());
        queueMap.get(1).add(new ArrayList<Button>());
        queueMap.get(1).get(0).add((Button) findViewById(R.id.QueueButton1_5));
        queueMap.get(1).get(0).add((Button) findViewById(R.id.QueueButton1_6));
        queueMap.get(1).get(1).add((Button) findViewById(R.id.QueueButton1_7));
        queueMap.get(1).get(1).add((Button) findViewById(R.id.QueueButton1_8));
        queueMap.add(new ArrayList<ArrayList<Button>>());
        queueMap.get(2).add(new ArrayList<Button>());
        queueMap.get(2).add(new ArrayList<Button>());
        queueMap.get(2).get(0).add((Button) findViewById(R.id.QueueButton1_9));
        queueMap.get(2).get(0).add((Button) findViewById(R.id.QueueButton1_10));
        queueMap.get(2).get(1).add((Button) findViewById(R.id.QueueButton1_11));
        queueMap.get(2).get(1).add((Button) findViewById(R.id.QueueButton1_12));

        queueMap.add(new ArrayList<ArrayList<Button>>());
        queueMap.get(3).add(new ArrayList<Button>());
        queueMap.get(3).add(new ArrayList<Button>());
        queueMap.get(3).get(0).add((Button) findViewById(R.id.QueueButton2_1));
        queueMap.get(3).get(0).add((Button) findViewById(R.id.QueueButton2_2));
        queueMap.get(3).get(1).add((Button) findViewById(R.id.QueueButton2_3));
        queueMap.get(3).get(1).add((Button) findViewById(R.id.QueueButton2_4));
        queueMap.add(new ArrayList<ArrayList<Button>>());
        queueMap.get(4).add(new ArrayList<Button>());
        queueMap.get(4).add(new ArrayList<Button>());
        queueMap.get(4).get(0).add((Button) findViewById(R.id.QueueButton2_5));
        queueMap.get(4).get(0).add((Button) findViewById(R.id.QueueButton2_6));
        queueMap.get(4).get(1).add((Button) findViewById(R.id.QueueButton2_7));
        queueMap.get(4).get(1).add((Button) findViewById(R.id.QueueButton2_8));
        queueMap.add(new ArrayList<ArrayList<Button>>());
        queueMap.get(5).add(new ArrayList<Button>());
        queueMap.get(5).add(new ArrayList<Button>());
        queueMap.get(5).get(0).add((Button) findViewById(R.id.QueueButton2_9));
        queueMap.get(5).get(0).add((Button) findViewById(R.id.QueueButton2_10));
        queueMap.get(5).get(1).add((Button) findViewById(R.id.QueueButton2_11));
        queueMap.get(5).get(1).add((Button) findViewById(R.id.QueueButton2_12));

        queueMap.add(new ArrayList<ArrayList<Button>>());
        queueMap.get(6).add(new ArrayList<Button>());
        queueMap.get(6).add(new ArrayList<Button>());
        queueMap.get(6).get(0).add((Button) findViewById(R.id.QueueButton3_1));
        queueMap.get(6).get(0).add((Button) findViewById(R.id.QueueButton3_2));
        queueMap.get(6).get(1).add((Button) findViewById(R.id.QueueButton3_3));
        queueMap.get(6).get(1).add((Button) findViewById(R.id.QueueButton3_4));
        queueMap.add(new ArrayList<ArrayList<Button>>());
        queueMap.get(7).add(new ArrayList<Button>());
        queueMap.get(7).add(new ArrayList<Button>());
        queueMap.get(7).get(0).add((Button) findViewById(R.id.QueueButton3_5));
        queueMap.get(7).get(0).add((Button) findViewById(R.id.QueueButton3_6));
        queueMap.get(7).get(1).add((Button) findViewById(R.id.QueueButton3_7));
        queueMap.get(7).get(1).add((Button) findViewById(R.id.QueueButton3_8));
        queueMap.add(new ArrayList<ArrayList<Button>>());
        queueMap.get(8).add(new ArrayList<Button>());
        queueMap.get(8).add(new ArrayList<Button>());
        queueMap.get(8).get(0).add((Button) findViewById(R.id.QueueButton3_9));
        queueMap.get(8).get(0).add((Button) findViewById(R.id.QueueButton3_10));
        queueMap.get(8).get(1).add((Button) findViewById(R.id.QueueButton3_11));
        queueMap.get(8).get(1).add((Button) findViewById(R.id.QueueButton3_12));

        dontseeButton.add(new ArrayList<Button>());
        dontseeButton.get(0).add((Button) findViewById(R.id.dontSeeButton1));
        dontseeButton.get(0).add((Button) findViewById(R.id.dontSeeButton2));
        dontseeButton.get(0).add((Button) findViewById(R.id.dontSeeButton3));
        dontseeButton.add(new ArrayList<Button>());
        dontseeButton.get(1).add((Button) findViewById(R.id.dontSeeButton4));
        dontseeButton.get(1).add((Button) findViewById(R.id.dontSeeButton5));
        dontseeButton.get(1).add((Button) findViewById(R.id.dontSeeButton6));
        dontseeButton.add(new ArrayList<Button>());
        dontseeButton.get(2).add((Button) findViewById(R.id.dontSeeButton7));
        dontseeButton.get(2).add((Button) findViewById(R.id.dontSeeButton8));
        dontseeButton.get(2).add((Button) findViewById(R.id.dontSeeButton9));


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttonMap.get(i).get(j).setAlpha(0);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    queueMap.get(i).get(j).get(k).setAlpha(0);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dontseeButton.get(i).get(j).setAlpha(0);
            }
        }

        dontseeButton.get(0).get(0).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                thisStage.x = 0;
                thisStage.y = 0;
                thisStage.setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(0).get(1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                thisStage.x = 0;
                thisStage.y = 1;
                thisStage.setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(0).get(2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                thisStage.x = 0;
                thisStage.y = 2;
                thisStage.setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(1).get(0).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                thisStage.x = 1;
                thisStage.y = 0;
                thisStage.setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(1).get(1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                thisStage.x = 1;
                thisStage.y = 1;
                thisStage.setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(1).get(2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                thisStage.x = 1;
                thisStage.y = 2;
                thisStage.setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(2).get(0).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                thisStage.x = 2;
                thisStage.y = 0;
                thisStage.setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(2).get(1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                thisStage.x = 2;
                thisStage.y = 1;
                thisStage.setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(2).get(2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                thisStage.x = 2;
                thisStage.y = 2;
                thisStage.setMap(queueMap, buttonMap);

            }
        });





        //createMap()
        while (true) {
            thisStage.myMap.randomMap();
            thisStage.saveMap = thisStage.myMap.clone();
            while (!thisStage.saveMap.matching(thisStage.emptyArray, 0, 0)) {
                thisStage.myQueue.currentQueue.add(thisStage.saveMap.generateQueue(2));
            }

            if (thisStage.myQueue.currentQueue.size() >= 9)
                break;
            else
                thisStage.myQueue.currentQueue = new ArrayList<BallClass.Ball_Array>();

        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttonMap.get(i).get(j).setText(thisStage.myMap.map.get(i).get(j).ballType + "");
                buttonMap.get(i).get(j).setAlpha(1);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    queueMap.get(i).get(j).get(k).setText(thisStage.myQueue.currentQueue.get(i).map.get(j).get(k).ballType + "");
                    queueMap.get(i).get(j).get(k).setAlpha(1);
                }
            }
        }
    }


}

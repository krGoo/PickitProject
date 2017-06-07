package com.cookandroid.pickit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ScrollActivity extends AppCompatActivity implements AccessibleAnotherActivity{
    static Activity thisActivity;
    BallClass thisStage = new BallClass(0);

    class ballQueuemanager{
        int NumQuebutton;
        ArrayList<ArrayList<ArrayList<Button>>> QueuebuttonMap;

        public ballQueuemanager(int id[]){
            NumQuebutton=id.length/4;
            int i,j,k;
            k=0;
            for( i=0;i<NumQuebutton;i++ ){
                QueuebuttonMap.add(new ArrayList<ArrayList<Button>>());
                for(j=0;j<2;j++){
                    QueuebuttonMap.get(i).add(new ArrayList<Button>());
                    QueuebuttonMap.get(i).get(j).add((Button)findViewById(id[k++]));
                    QueuebuttonMap.get(i).get(j).add((Button)findViewById(id[k++]));
                }
            }




        }
        public View getQueueButton(int queue,int ball_x,int ball_y){

            if(1>queue||queue>NumQuebutton)
                return null;
            if(ball_x<0||ball_x>1||ball_y<0||ball_y>1)
                return null;
            return null;

        }

    }
    private long lastTimeBackPressed;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        final ArrayList<ArrayList<ArrayList<Button>>> queueMap = new ArrayList<ArrayList<ArrayList<Button>>>();
        int []btnId_que={
                R.id.ball1_00,R.id.ball1_01,R.id.ball1_10,R.id.ball1_11,
                R.id.ball2_00,R.id.ball2_01,R.id.ball2_10,R.id.ball2_11,
                R.id.ball3_00,R.id.ball3_01,R.id.ball3_10,R.id.ball3_11,
                R.id.ball4_00,R.id.ball4_01,R.id.ball4_10,R.id.ball4_11,
                R.id.ball5_00,R.id.ball5_01,R.id.ball5_10,R.id.ball5_11,
                R.id.ball6_00,R.id.ball6_01,R.id.ball6_10,R.id.ball6_11,
                R.id.ball7_00,R.id.ball7_01,R.id.ball7_10,R.id.ball7_11,
                R.id.ball8_00,R.id.ball8_01,R.id.ball8_10,R.id.ball8_11,
                R.id.ball9_00,R.id.ball9_01,R.id.ball9_10,R.id.ball9_11,
                R.id.ball10_00,R.id.ball10_01,R.id.ball10_10,R.id.ball10_11,
                R.id.ball11_00,R.id.ball11_01,R.id.ball11_10,R.id.ball11_11,
                R.id.ball12_00,R.id.ball12_01,R.id.ball12_10,R.id.ball12_11,
                R.id.ball13_00,R.id.ball13_01,R.id.ball13_10,R.id.ball13_11,
                R.id.ball14_00,R.id.ball14_01,R.id.ball14_10,R.id.ball14_11,
                R.id.ball15_00,R.id.ball15_01,R.id.ball15_10,R.id.ball15_11,
                R.id.ball16_00,R.id.ball16_01,R.id.ball16_10,R.id.ball16_11,
                R.id.ball17_00,R.id.ball17_01,R.id.ball17_10,R.id.ball17_11,
                R.id.ball18_00,R.id.ball18_01,R.id.ball18_10,R.id.ball18_11,
                R.id.ball19_00,R.id.ball19_01,R.id.ball19_10,R.id.ball19_11,
                R.id.ball20_00,R.id.ball20_01,R.id.ball20_10,R.id.ball20_11

        };


        final ArrayList<ArrayList<Button>> dontseeButton = new ArrayList<ArrayList<Button>>();
        final ArrayList<ArrayList<Button>> buttonMap = new ArrayList<ArrayList<Button>>();
        final Button undoButton = (Button) findViewById(R.id.undo);


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
        /*
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttonMap.get(i).get(j).setAlpha(0);
            }
        }
        */
        for (int i = 0; i < 20; i++) {
            queueMap.add(new ArrayList<ArrayList<Button>>());
            for (int j = 0; j < 2; j++) {
                queueMap.get(i).add(new ArrayList<Button>());
                for (int k = 0; k < 2; k++) {
                    queueMap.get(i).get(j).add((Button) findViewById(btnId_que[i*4+j*2+k]));
                    //queueMap.get(i).get(j).get(k).setAlpha(0);
                    if(i == 0)
                        queueMap.get(0).get(j).get(k).setTextColor(Color.parseColor("red"));
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
        undoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(thisStage.beforeStage != null) {
                    thisStage = thisStage.beforeStage;
                    thisStage.refreshMap(queueMap, buttonMap);
                }
            }
        });
        while (true) {
            //thisStage.myMap.randomMap();
            thisStage.myMap.generateMap(new int[][]{{2,2,2,2},{2,2,2,2},{2,2,2,0},{2,1,2,0}});
            thisStage.saveMap = thisStage.myMap.clone();

            while (!thisStage.saveMap.matching(thisStage.emptyArray, 0, 0)) {
                thisStage.myQueue.currentQueue.add(thisStage.saveMap.generateQueue(2));
            }



            if (thisStage.myQueue.currentQueue.size() >= 0)
                break;
            else
                thisStage.myQueue.currentQueue = new ArrayList<BallClass.Ball_Array>();

        }
        thisStage.refreshMap(queueMap, buttonMap);
    }


}

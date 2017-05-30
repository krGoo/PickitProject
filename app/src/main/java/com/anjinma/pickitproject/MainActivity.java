package com.anjinma.pickitproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.lang.String;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    class Ball{
        int ballType;
        Ball(){
            ballType = 0;
        }
        Ball(int n){
            ballType = n;
        }
    }
    class Ball_Array implements  Cloneable{
        ArrayList<ArrayList<Ball>> map;
        int sizeOfArray;
        Ball_Array(){
            map = new ArrayList<ArrayList<Ball>>();
            sizeOfArray = 0;
        }
        Ball_Array(int n){
            map = new ArrayList<ArrayList<Ball>>();
            for(int i = 0; i < n; i ++) {
                map.add(i, new ArrayList<Ball>());
                for(int j = 0; j < n; j ++)
                for (int j = 0; j < n; j++)
                    map.get(i).add(new Ball(0));
            }
            sizeOfArray = n;
        }
        Ball_Array(int n, int[][] sample){
            map = new ArrayList<ArrayList<Ball>>();
            sizeOfArray = n;
            for(int i = 0; i < n; i++){
                map.set(i,new ArrayList<Ball>());
                for(int j = 0; j < n; j++){
                    map.get(i).set(j,new Ball(sample[i][j]));
                }
            }
        }
        Ball_Array(Ball_Array copy){
            map = copy.map;
            sizeOfArray = copy.sizeOfArray;
        }
        protected Ball_Array clone(){
            Ball_Array temp = new Ball_Array(sizeOfArray);
            Ball tempBall;
            for(int i = 0; i < sizeOfArray; i++){
                for(int j = 0; j < sizeOfArray; j++) {
                    tempBall = new Ball(map.get(i).get(j).ballType);
                    temp.map.get(i).set(j, tempBall);
                }
            }
            return temp;
        }
        void randomMap(){
            for(int i = 0; i < sizeOfArray; i++){
                for(int j = 0; j < sizeOfArray; j++){
                    map.get(i).set(j, new Ball((int)(Math.random()*100)%4));
                }
            }
        }
        boolean matching(Ball_Array target, int x, int y){
            int count = 0;
            map.size();
            if (sizeOfArray < target.sizeOfArray)
                return false;
            else {
                for (int i = 0; i < target.sizeOfArray; i++) {
                    for (int j = 0; j < target.sizeOfArray; j++) {
                        if (map.get(x+i).get(y+j).ballType == target.map.get(i).get(j).ballType)
                            count++;
                    }
                }
            }
            if (count == target.sizeOfArray*target.sizeOfArray) {
                return true;
            }
            else
                return false;
        }
        void subArray(int n, int x, int y) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map.get(x + i).get(y + j).ballType >= 1)
                        map.get(x + i).get(y + j).ballType--;

                }
            }
        }
        Ball_Array generateQueue(int n) {
            int x;
            int y;
            Ball_Array emptyArray = new Ball_Array(n);
            Ball_Array outputArray = new Ball_Array(n);
            do {
                x = (int)(Math.random()*1000) % (sizeOfArray - n + 1);
                y = (int)(Math.random()*1000) % (sizeOfArray - n + 1);
                if (!matching(emptyArray, x, y))
                    break;
            } while (true);
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    outputArray.map.get(i).get(j).ballType = map.get(x + i).get(y + j).ballType;
            subArray(n, x, y);
            return outputArray;
        }
    }
    class Ball_Queue {
        ArrayList <Ball_Array> currentQueue;
        int top = 0;
        Ball_Queue (){
            currentQueue = new ArrayList<Ball_Array>();
        }
        void printQueue(Button [] queueButton, int n) {
            queueButton[0].setText(currentQueue.get(n).map.get(0).get(0).ballType);
            queueButton[1].setText(currentQueue.get(n).map.get(0).get(1).ballType);
            queueButton[2].setText(currentQueue.get(n).map.get(1).get(0).ballType);
            queueButton[3].setText(currentQueue.get(n).map.get(1).get(1).ballType);
        }
    }


    int count = 0;
    int max;
    int i=0, j=0, k=0;
    int x = 0, y = 0;

    Ball_Queue myQueue = new Ball_Queue();
    Ball_Array myMap = new Ball_Array(4);            //맵 구성
    Ball_Array emptyArray = new Ball_Array(4);
    Ball_Array saveMap = new Ball_Array(4);



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button start = (Button) findViewById(R.id.start);

        final ArrayList<ArrayList<Button>> buttonMap = new ArrayList<ArrayList<Button>>();
        final ArrayList<ArrayList<ArrayList<Button>>> queueMap = new ArrayList<ArrayList<ArrayList<Button>>>();
        final ArrayList<ArrayList<Button>> dontseeButton = new ArrayList<ArrayList<Button>>();

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
                x = 0;
                y = 0;
                setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(0).get(1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = 0;
                y = 1;
                setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(0).get(2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = 0;
                y = 2;
                setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(1).get(0).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = 1;
                y = 0;
                setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(1).get(1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = 1;
                y = 1;
                setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(1).get(2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = 1;
                y = 2;
                setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(2).get(0).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = 2;
                y = 0;
                setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(2).get(1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = 2;
                y = 1;
                setMap(queueMap, buttonMap);
            }
        });
        dontseeButton.get(2).get(2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = 2;
                y = 2;
                setMap(queueMap, buttonMap);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                while(true) {
                    myMap.randomMap();
                    saveMap = myMap.clone();
                    while (!saveMap.matching(emptyArray, 0, 0)) {
                        myQueue.currentQueue.add(saveMap.generateQueue(2));
                    }
                    if(myQueue.currentQueue.size() == 9)
                        break;
                    else
                        myQueue.currentQueue = new ArrayList<Ball_Array>();
                }
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        buttonMap.get(i).get(j).setText(myMap.map.get(i).get(j).ballType + "");
                        buttonMap.get(i).get(j).setAlpha(1);
                    }
                }

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 2; j++) {
                        for (int k = 0; k < 2; k++) {
                            queueMap.get(i).get(j).get(k).setText(myQueue.currentQueue.get(i).map.get(j).get(k).ballType + "");
                            queueMap.get(i).get(j).get(k).setAlpha(1);
                        }
                    }
                }


            }
        });
    }



        public void setMap(ArrayList<ArrayList<ArrayList<Button>>> queueMap, ArrayList<ArrayList<Button>> buttonMap) {
            if(myMap.matching(myQueue.currentQueue.get(count),x,y)) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        queueMap.get(count).get(j).get(k).setAlpha(0);
                    }
                }
                count++;
                myMap.subArray(2, x, y);
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        buttonMap.get(i).get(j).setText(myMap.map.get(i).get(j).ballType + "");
                    }
                }
            }
        }

}

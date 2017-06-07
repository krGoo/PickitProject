package com.cookandroid.pickit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.widget.Button;

import java.util.ArrayList;


/**
 * Created by fotok on 2017-06-05.
 */

public class BallClass implements Cloneable{
    Ball_Queue myQueue = new Ball_Queue();
    Ball_Array myMap = new Ball_Array(4);            //맵 구성
    Ball_Array emptyArray = new Ball_Array(4);
    Ball_Array saveMap = new Ball_Array(4);
    BallClass beforeStage = null;
    int level = 0;
    int count = 0;
    int x = 0, y = 0;
    BallClass(){
        this.level = 0;
    }
    BallClass(int level){
        this.level = level;
    }
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

        void generateMap(int[][] intSet){
            for(int i = 0; i < sizeOfArray; i++){
                for(int j = 0; j < sizeOfArray; j++){
                    map.get(i).set(j, new Ball(intSet[i][j]));
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
        Ball_Array generateQueue(int n, int x, int y) {
            Ball_Array emptyArray = new Ball_Array(n);
            Ball_Array outputArray = new Ball_Array(n);
            do {
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
    class Ball_Queue implements Cloneable{
        ArrayList <Ball_Array> currentQueue;
        int top = 0;
        Ball_Queue (){
            currentQueue = new ArrayList<Ball_Array>();
        }

        protected Ball_Queue clone() {
            Ball_Queue clone = new Ball_Queue();
            for(int i = 0; i < this.currentQueue.size(); i++)
                 clone.currentQueue.add(this.currentQueue.get(i).clone());
            return clone;
        }
    }
    protected BallClass clone(){
        BallClass clone = new BallClass(level);
        clone.myMap = this.myMap.clone();
        clone.saveMap = this.saveMap.clone();
        clone.emptyArray = this.emptyArray.clone();
        clone.myQueue = this.myQueue.clone();
        clone.level = this.level;
        clone.count = this.count;
        clone.beforeStage = this.beforeStage;
        return clone;
    }
    public void setMap(ArrayList<ArrayList<ArrayList<Button>>> queueMap, ArrayList<ArrayList<Button>> buttonMap) {
        if(myMap.matching(myQueue.currentQueue.get(count),x,y)) {
            beforeStage = this.clone();

            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    queueMap.get(count).get(j).get(k).setAlpha(0);
                }
            }
            myMap.subArray(2, x, y);
            count++;
            refreshMap(queueMap, buttonMap);
            endOfStage(ScrollActivity.thisActivity);

        }
    }
    public void refreshMap(ArrayList<ArrayList<ArrayList<Button>>> queueMap, ArrayList<ArrayList<Button>> buttonMap){
        for(int i = 0; i < myQueue.currentQueue.size(); i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if(i < count) {
                        queueMap.get(i).get(j).get(k).setAlpha(0);
                    }
                    else {
                        queueMap.get(i).get(j).get(k).setText(myQueue.currentQueue.get(i).map.get(j).get(k).ballType + "");
                        queueMap.get(i).get(j).get(k).setTextColor(Color.parseColor("black"));
                        queueMap.get(i).get(j).get(k).setAlpha(1);
                    }
                    if(i == count)
                        queueMap.get(i).get(j).get(k).setTextColor(Color.parseColor("red"));
                }
            }
        }
        for(int i = myQueue.currentQueue.size(); i < 20; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    queueMap.get(i).get(j).get(k).setAlpha(0);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttonMap.get(i).get(j).setText(myMap.map.get(i).get(j).ballType + "");
            }
        }
    }
    public void endOfStage(Activity thisActivity){
        if(count  == myQueue.currentQueue.size()){
            thisActivity.finish();
            Intent intent_1 = new Intent(thisActivity.getApplicationContext(), StartActivity.class);
            thisActivity.startActivity(intent_1);
        }
    }
}

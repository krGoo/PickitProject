package com.cookandroid.pickit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModeActivity extends AppCompatActivity {
    class ModeManager{
        public String[] Modename;
        public int Nmode;
        public int mode;
        public Button menubutton;
        public Button startbutton;
        ModeManager(String[] name){
            Nmode = name.length;
            Modename=name.clone();
            menubutton=(Button)findViewById(R.id.mode);
            startbutton=(Button)findViewById(R.id.start2);
            for(int i=0;i<Nmode;i++)
                System.out.println(Modename[i]);
            menubutton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mode ++;
                    if(mode==Nmode)
                        mode=0;
                    settext_button1(mode);
                }
            });

            startbutton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startgame();}
            });
        }


        boolean startgame(){
                /*if i is not in (0 ~ Nmode-1)*/
            if (mode < 0 || Nmode <= mode)
                return false;
            if(mode==0) {
                finish();
                Intent intent_3=new Intent(getApplicationContext(),ScrollActivity.class);
                startActivity(intent_3);
            }
            else if(mode==2) {
                finish();
                Intent intent_2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_2);
            }
            else if(mode==1) {

            }
            return true;
        }


        boolean settext_button1(int i) {
        /*if i is not in (0 ~ Nmode-1)*/
            if (i < 0 || Nmode <= i)
                return false;

            menubutton.setText(Modename[i]);

            return true;
        }


    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        //TODO :: testpattern
        String[] modename= new String[3];
        modename[0]="Practice";
        modename[1] = "Rank";
        modename[2] = "bunseok";

        final Button start = (Button) findViewById(R.id.start2);
        final ModeManager Manager = new ModeManager(modename);


    }
}

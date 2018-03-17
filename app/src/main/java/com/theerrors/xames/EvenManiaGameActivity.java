package com.theerrors.xames;

import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;


public class EvenManiaGameActivity extends AppCompatActivity {
    EditText choice1;
    EditText choice2;
    int p1_choice, p2_choice;
    int moveing_thing_x = 0, moveing_thing_y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_mania_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.p1_choice)
    public void onPlayer1Input() {
        choice1 = (EditText) findViewById(R.id.p1_choice);
        choice2 = (EditText) findViewById(R.id.p2_choice);

        String p1Value = choice1.getText().toString();
        if (p1Value.length() >= 1) {
            p1_choice = Integer.parseInt(p1Value);
            Log.d("EvenMania", "" + p1_choice);

            // EXPERIMENT
            ImageView image_moving_thing = (ImageView) findViewById(R.id.image_moving_thing);

            TranslateAnimation moveLefttoRight = new TranslateAnimation(moveing_thing_x + 0,moveing_thing_x + 100, moveing_thing_y + 0, moveing_thing_y + 0);
            moveLefttoRight.setDuration(1000);
            moveLefttoRight.setFillAfter(true);

            image_moving_thing.startAnimation(moveLefttoRight);
        }

    }

    @OnClick(R.id.p2_choice)
    public void onPlayer2Input(){

        String p2Value = choice2.getText().toString();
        if(p2Value.length() >= 1){
            p2_choice = Integer.parseInt(p2Value);
            Log.d("EvenMania", "" + p2_choice);
            // EXPERIMENT
            ImageView image_moving_thing = (ImageView) findViewById(R.id.image_moving_thing);

            TranslateAnimation moveLefttoRight = new TranslateAnimation(moveing_thing_x + 0,moveing_thing_x + 0 , moveing_thing_y + 0, moveing_thing_y + 100);
            moveLefttoRight.setDuration(1000);
            moveLefttoRight.setFillAfter(true);

            image_moving_thing.startAnimation(moveLefttoRight);
        }


    }


    public void MoveObject() {

    }

}

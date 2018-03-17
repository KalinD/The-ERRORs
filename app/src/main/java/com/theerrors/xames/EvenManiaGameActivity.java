package com.theerrors.xames;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
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
    int p1_choice_num, p2_choice_num;
    int moving_thing_x = 0, moving_thing_y = 0;
    int boundary_value = 5; //for now
    int one_graphBox_size = 154;

    ImageView image_moving_thing;


    public void CheckWin() {
        if (moving_thing_x - moving_thing_y >= boundary_value * one_graphBox_size) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(EvenManiaGameActivity.this);
            builder.setMessage("Someone won!!");
            builder.setTitle("Game Over!");
            builder.setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(EvenManiaGameActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            AlertDialog endGame = builder.create();
            endGame.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_mania_main);
        ButterKnife.bind(this);


    }

    @BindView(R.id.p1_choice)
    EditText p1_choice;
    @BindView(R.id.p2_choice)
    EditText p2_choice;

    @OnClick(R.id.p1_choice)
    public void onPlayer1Input() {
        choice1 = (EditText) findViewById(R.id.p1_choice);

        ImageView image_moving_thing = (ImageView) findViewById(R.id.image_moving_thing);

        String p1Value = choice1.getText().toString();

        if (p1Value.length() >= 1) {
            p1_choice_num = Integer.parseInt(p1Value);

            TranslateAnimation move = new TranslateAnimation(moving_thing_x + 0, moving_thing_x + (one_graphBox_size * p1_choice_num), moving_thing_y + 0, moving_thing_y + 0);
            move.setDuration(1000);
            move.setFillAfter(true);

            int predicted_location = (moving_thing_x + one_graphBox_size * p1_choice_num) - moving_thing_y;

            if (predicted_location >= boundary_value * one_graphBox_size) {
                int more_than_needed = predicted_location - boundary_value * one_graphBox_size;
                moving_thing_x = moving_thing_x + (p1_choice_num * one_graphBox_size - more_than_needed);
                Log.d("EvenMania", "" + moving_thing_x);

            } else {
                moving_thing_x += one_graphBox_size * p1_choice_num;
            }


            image_moving_thing.startAnimation(move);

            CheckWin();
        }

    }

    @OnClick(R.id.p2_choice)
    public void onPlayer2Input() {

        choice2 = (EditText) findViewById(R.id.p2_choice);
        String p2Value = choice2.getText().toString();
        ImageView image_moving_thing = (ImageView) findViewById(R.id.image_moving_thing);

        if (p2Value.length() >= 1) {
            p2_choice_num = Integer.parseInt(p2Value);


            int predicted_location = moving_thing_x - (moving_thing_y - one_graphBox_size * p1_choice_num);

            if (predicted_location >= boundary_value * one_graphBox_size) {
                int more_than_needed = predicted_location - boundary_value * one_graphBox_size;
                moving_thing_x = moving_thing_x + (p1_choice_num * one_graphBox_size - more_than_needed);

            } else {
                moving_thing_x += one_graphBox_size * p1_choice_num;
            }

            TranslateAnimation move = new TranslateAnimation(moving_thing_x + 0, moving_thing_x + 0, moving_thing_y + 0, moving_thing_y - (one_graphBox_size * p2_choice_num));
            move.setDuration(1000);
            move.setFillAfter(true);
            image_moving_thing.startAnimation(move);

        }


        moving_thing_y -= one_graphBox_size * p2_choice_num;

    }

}




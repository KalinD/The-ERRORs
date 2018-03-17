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
    int boundary_value = 15; //for now
    int one_graphBox_size = 61;




    @BindView(R.id.image_moving_thing)
    ImageView image_moving_thing;
    @BindView(R.id.MainBoard)
    ImageView MainBoard;
    @BindView(R.id.p1_choice)
    EditText p1_choice;
    @BindView(R.id.p2_choice)
    EditText p2_choice;

    public void CheckWin() {
        if (moving_thing_x - moving_thing_y >= boundary_value * one_graphBox_size) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(EvenManiaGameActivity.this);
            if((moving_thing_x / one_graphBox_size) % 2 == 0){
                builder.setMessage("Player 1 wins!!");
            }else if((moving_thing_y / one_graphBox_size)% 2 == 0){
                builder.setMessage("Player 2 wins!!");
            }
            builder.setTitle("We have a winner!");
            builder.setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(EvenManiaGameActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            MainBoard.setImageResource(R.drawable.graph15_on_win);
            AlertDialog endGame = builder.create();
            endGame.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_mania_main);
        ButterKnife.bind(this);
        TranslateAnimation fix_position = new TranslateAnimation(moving_thing_x + 0, moving_thing_x + 10, moving_thing_y + 0, moving_thing_y - 5);
        fix_position.setDuration(1); //instant

        image_moving_thing.startAnimation(fix_position); //because i can make it start from the exact starting position!


    }

    @OnClick(R.id.p1_choice)
    public void onPlayer1Input() {
        choice1 = (EditText) findViewById(R.id.p1_choice);


        ImageView image_moving_thing = (ImageView) findViewById(R.id.image_board); //image_moving_thing


        String p1Value = choice1.getText().toString();

        if (p1Value.length() >= 1) {
            p1_choice_num = Integer.parseInt(p1Value);

            TranslateAnimation move = new TranslateAnimation(moving_thing_x + 0, moving_thing_x + (one_graphBox_size * p1_choice_num), moving_thing_y + 0, moving_thing_y + 0);
            move.setDuration(1000);
            move.setFillAfter(true);

            int predicted_location = (moving_thing_x + one_graphBox_size * p1_choice_num) - moving_thing_y;

<<<<<<< HEAD
            if(predicted_location >= boundary_value * one_graphBox_size){
                int more_than_needed = predicted_location - boundary_value * one_graphBox_size;
                moving_thing_x = moving_thing_x + (p1_choice_num * one_graphBox_size - more_than_needed);
                Log.d("EvenMania", "moving thing x: " + moving_thing_x + ", more than needed" + more_than_needed);

            }else{
=======
            if (predicted_location >= boundary_value * one_graphBox_size) {
                int more_than_needed = predicted_location - boundary_value * one_graphBox_size;
                moving_thing_x = moving_thing_x + (p1_choice_num * one_graphBox_size - more_than_needed);
                Log.d("EvenMania", "" + moving_thing_x);

            } else {
>>>>>>> fe7d707e19f004ba471e94321c1693a58b897017
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

        ImageView image_moving_thing = (ImageView) findViewById(R.id.image_board); //image_moving_thing


        if (p2Value.length() >= 1) {
            p2_choice_num = Integer.parseInt(p2Value);

            int predicted_location = moving_thing_x - (moving_thing_y - one_graphBox_size * p1_choice_num);
<<<<<<< HEAD
=======

>>>>>>> fe7d707e19f004ba471e94321c1693a58b897017

            TranslateAnimation move = new TranslateAnimation(moving_thing_x + 0, moving_thing_x + 0, moving_thing_y + 0, moving_thing_y - (one_graphBox_size * p2_choice_num));
            move.setDuration(1000);
            move.setFillAfter(true);

<<<<<<< HEAD
            TranslateAnimation move = new TranslateAnimation(moving_thing_x + 0, moving_thing_x + 0, moving_thing_y + 0, moving_thing_y - (one_graphBox_size * p2_choice_num));
            move.setDuration(1000);
            move.setFillAfter(true);

=======
>>>>>>> fe7d707e19f004ba471e94321c1693a58b897017

            if (predicted_location >= boundary_value * one_graphBox_size) {
                int more_than_needed = predicted_location - boundary_value * one_graphBox_size;
                moving_thing_y =  (p2_choice_num * one_graphBox_size - more_than_needed) - moving_thing_y;
<<<<<<< HEAD
                Log.d("EvenMania", "moving thing y: " + moving_thing_y + ", more than needed" + more_than_needed);
            }else{
                moving_thing_y -= one_graphBox_size * p2_choice_num;
=======

            }else{
                moving_thing_y -= one_graphBox_size * p2_choice_num;

>>>>>>> fe7d707e19f004ba471e94321c1693a58b897017
            }
            CheckWin();
            image_moving_thing.startAnimation(move);
        }



    }

}




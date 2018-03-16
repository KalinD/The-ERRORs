package com.theerrors.xames;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BasheGameActivity extends AppCompatActivity {
    int points = 21;
    @BindView(R.id.btn_player1_submit) Button mSubmitBtn1;
    @BindView(R.id.btn_player2_submit) Button mSubmitBtn2;
    @BindView(R.id.sb_player1) SeekBar mPlayer1Bar;
    @BindView(R.id.sb_player2) SeekBar mPlayer2Bar;
    @BindView(R.id.tv_player1_points) TextView mPlayer1Points;
    @BindView(R.id.tv_player2_points) TextView mPlayer2Points;
    @BindView(R.id.tv_points) TextView mPointsTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bashe_main);
        ButterKnife.bind(this);

        mPlayer1Bar.setMax(4);
        mPlayer2Bar.setMax(4);
        mPlayer2Bar.setEnabled(false);
        mSubmitBtn2.setEnabled(false);
        mPlayer1Points.setText(Integer.toString(mPlayer1Bar.getProgress() + 1));
        mPlayer2Points.setText(Integer.toString(mPlayer2Bar.getProgress() + 1));
        mPointsTextView.setText(Integer.toString(points));
        mPlayer1Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                mPlayer1Points.setText(Integer.toString(progress + 1));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){

            }
        });
        mPlayer2Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                mPlayer2Points.setText(Integer.toString(progress + 1));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){

            }
        });

    }
    @OnClick(R.id.btn_player1_submit)
    public void onSubmitButton1Clicked(){
        points -= mPlayer1Bar.getProgress() + 1;
        mPointsTextView.setText(Integer.toString(points));
        mPlayer2Bar.setEnabled(true);
        mSubmitBtn2.setEnabled(true);
        mPlayer1Bar.setEnabled(false);
        mSubmitBtn1.setEnabled(false);
    }
    @OnClick(R.id.btn_player2_submit)
    public void onSubmitButton2Clicked() {
        points -= mPlayer2Bar.getProgress() + 1;
        mPointsTextView.setText(Integer.toString(points));
        mPlayer2Bar.setEnabled(false);
        mSubmitBtn2.setEnabled(false);
        mPlayer1Bar.setEnabled(true);
        mSubmitBtn1.setEnabled(true);
    }
}

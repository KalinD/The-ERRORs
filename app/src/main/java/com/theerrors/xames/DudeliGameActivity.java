package com.theerrors.xames;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


// game of dudeli main activity
public class DudeliGameActivity extends AppCompatActivity {
    int points = 0;
    @BindView(R.id.btn_p1_1) Button mBtn1P1;
    @BindView(R.id.btn_p1_2) Button mBtn2P1;
    @BindView(R.id.btn_p1_3) Button mBtn3P1;
    @BindView(R.id.btn_p1_4) Button mBtn4P1;
    @BindView(R.id.btn_p1_5) Button mBtn5P1;
    @BindView(R.id.btn_p2_1) Button mBtn1P2;
    @BindView(R.id.btn_p2_2) Button mBtn2P2;
    @BindView(R.id.btn_p2_3) Button mBtn3P2;
    @BindView(R.id.btn_p2_4) Button mBtn4P2;
    @BindView(R.id.btn_p2_5) Button mBtn5P2;
    @BindView(R.id.tv_player1_points) TextView mP1Points;
    @BindView(R.id.tv_player2_points) TextView mP2Points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dudeli_main);
        ButterKnife.bind(this);
        mP1Points.setText(Integer.toString(points));
        mP2Points.setText(Integer.toString(points));
    }
    @OnClick(R.id.btn_p1_1)
    public void OnP1Btn1Clicked(){
        mBtn1P2.setEnabled(false);
        mBtn2P2.setEnabled(true);
        mBtn3P2.setEnabled(true);
        mBtn4P2.setEnabled(true);
        mBtn5P2.setEnabled(true);
        BtnsP1SetDisabled();
        points += 1;
        mP1Points.setText(Integer.toString(points));
        if(CheckForWinner() != 0){
            Winner();
        }
    }
    @OnClick(R.id.btn_p1_2)
    public void OnP1Btn2Clicked(){
        mBtn2P2.setEnabled(false);
        mBtn1P2.setEnabled(true);
        mBtn3P2.setEnabled(true);
        mBtn4P2.setEnabled(true);
        mBtn5P2.setEnabled(true);
        BtnsP1SetDisabled();
        points += 2;
        mP1Points.setText(Integer.toString(points));
        if(CheckForWinner() != 0){
            Winner();
        }
    }
    @OnClick(R.id.btn_p1_3)
    public void OnP1Btn3Clicked(){
        mBtn3P2.setEnabled(false);
        mBtn2P2.setEnabled(true);
        mBtn1P2.setEnabled(true);
        mBtn4P2.setEnabled(true);
        mBtn5P2.setEnabled(true);
        BtnsP1SetDisabled();
        points += 3;
        mP1Points.setText(Integer.toString(points));
        if(CheckForWinner() != 0){
            Winner();
        }
    }
    @OnClick(R.id.btn_p1_4)
    public void OnP1Btn4Clicked(){
        mBtn4P2.setEnabled(false);
        mBtn2P2.setEnabled(true);
        mBtn3P2.setEnabled(true);
        mBtn1P2.setEnabled(true);
        mBtn5P2.setEnabled(true);
        BtnsP1SetDisabled();
        points += 4;
        mP1Points.setText(Integer.toString(points));
        if(CheckForWinner() != 0){
            Winner();
        }
    }
    @OnClick(R.id.btn_p1_5)
    public void OnP1Btn5Clicked(){
        mBtn5P2.setEnabled(false);
        mBtn2P2.setEnabled(true);
        mBtn3P2.setEnabled(true);
        mBtn4P2.setEnabled(true);
        mBtn1P2.setEnabled(true);
        BtnsP1SetDisabled();
        points += 5;
        mP1Points.setText(Integer.toString(points));
        if(CheckForWinner() != 0){
            Winner();
        }
    }
    @OnClick(R.id.btn_p2_1)
    public void OnP2Btn1Clicked(){
        mBtn1P1.setEnabled(false);
        mBtn2P1.setEnabled(true);
        mBtn3P1.setEnabled(true);
        mBtn4P1.setEnabled(true);
        mBtn5P1.setEnabled(true);
        BtnsP2SetDisabled();
        points += 1;
        mP2Points.setText(Integer.toString(points));
        if(CheckForWinner() != 0){
            Winner();
        }
    }
    @OnClick(R.id.btn_p2_2)
    public void OnP2Btn2Clicked(){
        mBtn2P1.setEnabled(false);
        mBtn1P1.setEnabled(true);
        mBtn3P1.setEnabled(true);
        mBtn4P1.setEnabled(true);
        mBtn5P1.setEnabled(true);
        BtnsP2SetDisabled();
        points += 2;
        mP2Points.setText(Integer.toString(points));
        if(CheckForWinner() != 0){
            Winner();
        }
    }
    @OnClick(R.id.btn_p2_3)
    public void OnP2Btn3Clicked(){
        mBtn3P1.setEnabled(false);
        mBtn2P1.setEnabled(true);
        mBtn1P1.setEnabled(true);
        mBtn4P1.setEnabled(true);
        mBtn5P1.setEnabled(true);
        BtnsP2SetDisabled();
        points += 3;
        mP2Points.setText(Integer.toString(points));
        if(CheckForWinner() != 0){
            Winner();
        }
    }
    @OnClick(R.id.btn_p2_4)
    public void OnP2Btn4Clicked(){
        mBtn4P1.setEnabled(false);
        mBtn2P1.setEnabled(true);
        mBtn3P1.setEnabled(true);
        mBtn1P1.setEnabled(true);
        mBtn5P1.setEnabled(true);
        BtnsP2SetDisabled();
        points += 4;
        mP2Points.setText(Integer.toString(points));
        if(CheckForWinner() != 0){
            Winner();
        }
    }
    @OnClick(R.id.btn_p2_5)
    public void OnP2Btn5Clicked(){
        mBtn5P1.setEnabled(false);
        mBtn2P1.setEnabled(true);
        mBtn3P1.setEnabled(true);
        mBtn4P1.setEnabled(true);
        mBtn1P1.setEnabled(true);
        BtnsP2SetDisabled();
        points += 5;
        mP2Points.setText(Integer.toString(points));
        if(CheckForWinner() != 0){
            Winner();
        }
    }
    public void BtnsP1SetDisabled(){
        mBtn1P1.setEnabled(false);
        mBtn2P1.setEnabled(false);
        mBtn3P1.setEnabled(false);
        mBtn4P1.setEnabled(false);
        mBtn5P1.setEnabled(false);
    }
    public void BtnsP2SetDisabled(){
        mBtn1P2.setEnabled(false);
        mBtn2P2.setEnabled(false);
        mBtn3P2.setEnabled(false);
        mBtn4P2.setEnabled(false);
        mBtn5P2.setEnabled(false);
    }
    public int CheckForWinner(){
        if(points == 37){
            if(!mBtn1P1.isEnabled() && !mBtn2P1.isEnabled()){
                return 2;
            }
            else{
                return 1;
            }
        }
        if(points > 37){
            if(!mBtn1P1.isEnabled() && !mBtn2P1.isEnabled()){
                return 1;
            }
            else{
                return 2;
            }
        }
        return 0;
    }
    public void Winner() {
        //TODO winner function
    }
}
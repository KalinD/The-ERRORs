package com.theerrors.xames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.iv_game_one) ImageView iv_game_one;
    @BindView(R.id.iv_game_two) ImageView iv_game_two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.iv_game_one)
    public void onClickGameOne(){
        Intent intent = new Intent(MainActivity.this, BasheMenuActivity.class);
        startActivity(intent);
    }

    /*@OnClick(R.id.iv_game_two)
    public void OnClickImageTwo(){
        Intent intent = new Intent(this, DudeliMenuActivity.class);
        startActivity(intent);
    }*/

    @OnClick(R.id.iv_game_three)
    public void OnClickImageThree(){
        Intent intent = new Intent(this, EvenManiaGameActivity.class);
        startActivity(intent);
    }
}

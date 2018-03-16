package com.theerrors.xames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DudeliMenuActivity extends AppCompatActivity {
    @BindView(R.id.btn_one_player)
    Button mBtnOnePlayer;
    @BindView(R.id.btn_two_players)
    Button mBtnTwoPlayers;
    @BindView(R.id.btn_back)
    ImageButton mBtnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dudeli_menu);
        ButterKnife.bind(DudeliMenuActivity.this);
    }
    @OnClick(R.id.btn_one_player)
    public void OnePlayerGameClicked(){
        Intent intent = new Intent(DudeliMenuActivity.this, DudeliGameActivity.class);
        intent.putExtra("PlayerAmount", 1);
        startActivity(intent);
    }
    @OnClick(R.id.btn_two_players)
    public void TwoPlayersGameClicked(){
        Intent intent = new Intent(DudeliMenuActivity.this, DudeliGameActivity.class);
        intent.putExtra("PlayerAmount", 2);
        startActivity(intent);
    }
    @OnClick(R.id.btn_back)
    public void BackButtonClicked(){
        Intent intent = new Intent(DudeliMenuActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

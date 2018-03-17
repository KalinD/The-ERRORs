package com.theerrors.xames;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;




import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.iv_game_one)
    ImageView mIvGameOne;
    @BindView(R.id.iv_game_two)
    ImageView mIvGameTwo;

    private final int[] imageArrayGameOne = { R.drawable.bachet_menu_screenshot, R.drawable.bachet_game_screenshot};

    public void changingImages(final int[] images,final ImageView iv) {
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                iv.setImageResource(images[i]);
                i++;
                if (i > images.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 2000);

            }

        };
        handler.postDelayed(runnable, 2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        changingImages(imageArrayGameOne,mIvGameOne);
    }

    @OnClick(R.id.iv_game_one)
    public void onClickGameOne() {
        Intent intent = new Intent(MainActivity.this, BasheMenuActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.iv_game_two)
    public void OnClickImageTwo(){
        Intent intent = new Intent(this, DudeliMenuActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.iv_game_three)
    public void OnClickImageThree(){
        Intent intent = new Intent(this, EvenManiaGameActivity.class);
        startActivity(intent);
    }
}

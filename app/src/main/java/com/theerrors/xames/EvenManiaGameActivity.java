package com.theerrors.xames;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;



import butterknife.ButterKnife;


public class EvenManiaGameActivity extends AppCompatActivity {
    EditText choice1;
    EditText choice2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_mania_main);
        ButterKnife.bind(this);

        int p1_choice, p2_choice;

        choice1 = (EditText) findViewById(R.id.p1_choice);
        choice2 = (EditText) findViewById(R.id.p2_choice);

        String p1Value = choice1.getText().toString();
        if(p1Value.length() >= 1){
            p1_choice = Integer.parseInt(p1Value);
            Log.d("EvenMania", "" + p1_choice);
        }

        String p2Value = choice2.getText().toString();

        if(p2Value.length() >= 1){
            p2_choice = Integer.parseInt(p2Value);
            Log.d("EvenMania", "" + p2_choice);
        }


    }
}

package com.example.andriod.tictactoe;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.M;

public class twoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);


        TextView user = (TextView) findViewById(R.id.free);

        Typeface userFont = Typeface.createFromAsset(getAssets(),  "fonts/fish.ttf");

        user.setTypeface(userFont);

    }

    public void boardThree (View view){

        Intent j = new Intent(twoPlayer.this, boardThree.class);
        startActivity(j);
    }

    public void boardFive (View view){

        Intent p = new Intent(twoPlayer.this, boardFive.class);
        startActivity(p);
    }

    }

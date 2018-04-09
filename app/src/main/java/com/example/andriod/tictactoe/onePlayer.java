package com.example.andriod.tictactoe;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class onePlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);


        TextView user = (TextView) findViewById(R.id.free);

        Typeface userFont = Typeface.createFromAsset(getAssets(),  "fonts/fish.ttf");

        user.setTypeface(userFont);

    }

    public void boardThreeA (View view){

        Intent m = new Intent(onePlayer.this, boardThreeComputer.class);
        startActivity(m);
    }

    public void boardFiveA (View view){

        Intent n = new Intent(onePlayer.this, broardFiveComputer.class);
        startActivity(n);
    }

}

package com.example.andriod.tictactoe;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class threeXO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_xo);
        TextView user = (TextView) findViewById(R.id.free);

        Typeface userFont = Typeface.createFromAsset(getAssets(),  "fonts/fish.ttf");

        user.setTypeface(userFont);

    }

    public void threeX (View view){

        Intent m = new Intent(threeXO.this, boardThree.class);
        startActivity(m);
    }

    public void threep (View view){

        Intent n = new Intent(threeXO.this, boardThreeO.class);
        startActivity(n);
    }

}

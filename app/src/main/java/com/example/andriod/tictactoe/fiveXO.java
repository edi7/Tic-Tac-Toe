package com.example.andriod.tictactoe;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class fiveXO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_xo);

        TextView user = (TextView) findViewById(R.id.free);

        Typeface userFont = Typeface.createFromAsset(getAssets(),  "fonts/fish.ttf");

        user.setTypeface(userFont);

    }

    public void fiveX (View view){

        Intent m = new Intent(fiveXO.this, boardFive.class);
        startActivity(m);
    }

    public void fiveO (View view){

        Intent n = new Intent(fiveXO.this, boardFiveO.class);
        startActivity(n);
    }

}

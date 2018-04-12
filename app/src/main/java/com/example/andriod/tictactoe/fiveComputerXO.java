package com.example.andriod.tictactoe;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class fiveComputerXO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_computer_xo);


        TextView user = (TextView) findViewById(R.id.free);
        Typeface userFont = Typeface.createFromAsset(getAssets(),  "fonts/fish.ttf");

        user.setTypeface(userFont);

    }

    public void fiveComputerX (View view){

        Intent m = new Intent(fiveComputerXO.this, broardFiveComputer.class);
        startActivity(m);
    }

    public void fiveComputerO (View view){

        Intent n = new Intent(fiveComputerXO.this, boardFiveComputerO.class);
        startActivity(n);
    }

}
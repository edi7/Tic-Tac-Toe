package com.example.andriod.tictactoe;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView user = (TextView) findViewById(R.id.free);

        Typeface userFont = Typeface.createFromAsset(getAssets(),  "fonts/fish.ttf");

        user.setTypeface(userFont);


    }
    //making user name italic//

    public void playerTwo(View view){

        Intent j = new Intent(MainActivity.this, twoPlayer.class);
        startActivity(j);
    }

    public void playerOne(View view){

        Intent i = new Intent(MainActivity.this, onePlayer.class);
        startActivity(i);
    }
}

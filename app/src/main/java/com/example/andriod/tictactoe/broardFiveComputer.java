package com.example.andriod.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class broardFiveComputer extends AppCompatActivity implements View.OnClickListener {


    private Button[][] buttons = new Button[5][5];

    private boolean player1Turn = true;
    private final int nice = 0xFF890725;
    private final int nicc = 0xFF000000;

    private int roundCount;
    private static final Random p = new Random();
    private static final Random q = new Random();

    private int player1Points;
    private int player2Points;

    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broard_five_computer);

        textViewPlayer1 = (TextView) findViewById(R.id.text_view_p1);
        textViewPlayer2 = (TextView) findViewById(R.id.text_view_p2);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = (Button) findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = (Button) findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }


        if (player1Turn) {
            ((Button) v).setText("X");
        }
        ((Button) v).setTextColor(nice);


        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            }

        } else if (roundCount == 25) {
            draw();
        } else {
            player1Turn = !player1Turn;

            play();
        }

    }

    public void play() {
        if (!player1Turn) {
            cup();
        }
        roundCount++;

        if (checkForWin()) {
            if (!player1Turn) {
                player2Wins();
            }

        } else if (roundCount == 25) {
            draw();
        } else {
            player1Turn = true;


        }
    }

    public void cup() {
        if (!AI()) {
            computer();
        }
    }

    private boolean checkForWin() {
        String[][] field = new String[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 5; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && field[i][0].equals(field[i][3])
                    && field[i][0].equals(field[i][4])
                    && !field[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && field[0][i].equals(field[3][i])
                    && field[0][i].equals(field[4][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && field[0][0].equals(field[2][2])
                && field[0][0].equals(field[3][3])
                && field[0][0].equals(field[4][4])
                && !field[0][0].equals("")) {
            return true;
        }

        if (field[0][4].equals(field[1][3])
                && field[0][4].equals(field[2][2])
                && field[0][4].equals(field[3][1])
                && field[0][4].equals(field[4][0])
                && !field[0][4].equals("")) {
            return true;
        }

        return false;
    }

    public boolean AI() {

        String[][] field = new String[5][5];

        for (int o = 0; o < 5; o++) {
            for (int g = 0; g < 5; g++) {
                field[o][g] = buttons[o][g].getText().toString();
            }
        }

        for (int o = 0; o < 5; o++) {
            //checking horizontally //
            if (field[o][0].equals(field[o][1])
                    && field[o][0].equals(field[o][2])
                    && field[o][0].equals(field[o][3])
                    && !field[o][0].equals("")
                    && field[o][4].equals("")) {
                buttons[o][4].setText("O");
                buttons[o][4].setTextColor(nicc);

                return true;
            }

            if (field[o][0].equals(field[o][1])
                    && field[o][0].equals(field[o][2])
                    && field[o][0].equals(field[o][4])
                    && !field[o][0].equals("")
                    && field[o][3].equals("")) {
                buttons[o][3].setText("O");
                buttons[o][3].setTextColor(nicc);

                return true;
            }

            if (field[o][0].equals(field[o][1])
                    && field[o][0].equals(field[o][3])
                    && field[o][0].equals(field[o][4])
                    && !field[o][0].equals("")
                    && field[o][2].equals("")) {
                buttons[o][2].setText("O");
                buttons[o][2].setTextColor(nicc);

                return true;
            }

            if (field[o][0].equals(field[o][2])
                    && field[o][0].equals(field[o][3])
                    && field[o][0].equals(field[o][4])
                    && !field[o][0].equals("")
                    && field[o][1].equals("")) {
                buttons[o][1].setText("O");
                buttons[o][1].setTextColor(nicc);

                return true;
            }

            if (field[o][1].equals(field[o][2])
                    && field[o][1].equals(field[o][3])
                    && field[o][1].equals(field[o][4])
                    && !field[o][1].equals("")
                    && field[o][0].equals("")) {
                buttons[o][0].setText("O");
                buttons[o][0].setTextColor(nicc);

                return true;
            }
        }


        for (int g = 0; g < 5; g++) {
            if (field[0][g].equals(field[1][g])
                    && field[0][g].equals(field[2][g])
                    && field[0][g].equals(field[3][g])
                    && !field[0][g].equals("")
                    && field[4][g].equals("")) {
                buttons[4][g].setText("O");
                buttons[4][g].setTextColor(nicc);

                return true;
            }
            //checking for three//
            if (field[0][g].equals(field[1][g])
                    && field[0][g].equals(field[2][g])
                    && field[0][g].equals(field[4][g])
                    && !field[0][g].equals("")
                    && field[3][g].equals("")) {
                buttons[3][g].setText("O");
                buttons[3][g].setTextColor(nicc);

                return true;
            }
            //checking for two//
            if (field[0][g].equals(field[1][g])
                    && field[0][g].equals(field[3][g])
                    && field[0][g].equals(field[4][g])
                    && !field[0][g].equals("")
                    && field[2][g].equals("")) {
                buttons[2][g].setText("O");
                buttons[2][g].setTextColor(nicc);

                return true;
            }
            //checking for one//
            if (field[0][g].equals(field[2][g])
                    && field[0][g].equals(field[3][g])
                    && field[0][g].equals(field[4][g])
                    && !field[0][g].equals("")
                    && field[1][g].equals("")) {
                buttons[1][g].setText("O");
                buttons[1][g].setTextColor(nicc);

                return true;
            }
            //checking for zero index //
            if (field[1][g].equals(field[2][g])
                    && field[1][g].equals(field[3][g])
                    && field[1][g].equals(field[4][g])
                    && !field[1][g].equals("")
                    && field[0][g].equals("")) {
                buttons[0][g].setText("O");
                buttons[0][g].setTextColor(nicc);

                return true;
            }

        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && field[0][0].equals(field[3][3])
                && !field[0][0].equals("")
                && field[4][4].equals("")) {
            buttons[4][4].setText("O");
            buttons[4][4].setTextColor(nicc);

            return true;
        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && field[0][0].equals(field[4][4])
                && !field[0][0].equals("")
                && field[3][3].equals("")) {
            buttons[3][3].setText("O");
            buttons[3][3].setTextColor(nicc);

            return true;
        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[3][3])
                && field[0][0].equals(field[4][4])
                && !field[0][0].equals("")
                && field[2][2].equals("")) {
            buttons[2][2].setText("O");
            buttons[2][2].setTextColor(nicc);

            return true;
        }


        if (field[0][0].equals(field[2][2])
                && field[0][0].equals(field[3][3])
                && field[0][0].equals(field[4][4])
                && !field[0][0].equals("")
                && field[1][1].equals("")) {
            buttons[1][1].setText("O");
            buttons[1][1].setTextColor(nicc);

            return true;
        }
        if (field[1][1].equals(field[2][2])
                && field[1][1].equals(field[3][3])
                && field[1][1].equals(field[4][4])
                && !field[1][1].equals("")
                && field[0][0].equals("")) {
            buttons[0][0].setText("O");
            buttons[0][0].setTextColor(nicc);

            return true;
        }

        if (field[0][4].equals(field[1][3])
                && field[0][4].equals(field[2][2])
                && field[0][4].equals(field[3][1])
                && !field[0][4].equals("")
                && field[4][0].equals("")) {
            buttons[4][0].setText("O");
            buttons[4][0].setTextColor(nicc);

            return true;
        }

        if (field[0][4].equals(field[1][3])
                && field[0][4].equals(field[2][2])
                && field[0][4].equals(field[4][0])
                && !field[0][4].equals("")
                && field[3][1].equals("")) {
            buttons[3][1].setText("O");
            buttons[3][1].setTextColor(nicc);

            return true;
        }

        if (field[0][4].equals(field[1][3])
                && field[0][4].equals(field[3][1])
                && field[0][4].equals(field[4][0])
                && !field[0][4].equals("")
                && field[2][2].equals("")) {
            buttons[2][2].setText("O");
            buttons[2][2].setTextColor(nicc);

            return true;
        }

        if (field[0][4].equals(field[2][2])
                && field[0][4].equals(field[3][1])
                && field[0][4].equals(field[4][0])
                && !field[0][4].equals("")
                && field[1][3].equals("")) {
            buttons[1][3].setText("O");
            buttons[1][3].setTextColor(nicc);

            return true;
        }
        if (field[1][3].equals(field[2][2])
                && field[1][3].equals(field[3][1])
                && field[1][3].equals(field[4][0])
                && !field[1][3].equals("")
                && field[0][4].equals("")) {
            buttons[0][4].setText("O");
            buttons[0][4].setTextColor(nicc);

            return true;
        }

        return false;
    }


    public void computer() {
        String[][] field = new String[5][5];


        int i = p.nextInt(5 - 0) + 0;
        int j = q.nextInt(5 - 0) + 0;

        field[i][j] = buttons[i][j].getText().toString();
        if (field[i][j] == "") {
            buttons[i][j].setText("O");
            buttons[i][j].setTextColor(nicc);
            return;

        } else {
            for (int t = 0; t < 5; t++) {
                for (int v = 0; v < 5; v++) {
                    field[t][v] = buttons[t][v].getText().toString();

                    if (field[0][0] == "") {
                        buttons[0][0].setText("O");
                        buttons[0][0].setTextColor(nicc);
                        return;
                    }
                    if (field[0][1] == "") {
                        buttons[0][1].setText("O");
                        buttons[0][1].setTextColor(nicc);
                        return;
                    }
                    if (field[0][2] == "") {
                        buttons[0][2].setText("O");
                        buttons[0][2].setTextColor(nicc);
                        return;
                    }

                    if (field[0][3] == "") {
                        buttons[0][3].setText("O");
                        buttons[0][3].setTextColor(nicc);
                        return;
                    }
                    if (field[0][4] == "") {
                        buttons[0][4].setText("O");
                        buttons[0][4].setTextColor(nicc);
                        return;
                    }
                    if (field[1][0] == "") {
                        buttons[1][0].setText("O");
                        buttons[1][0].setTextColor(nicc);
                        return;
                    }
                    if (field[1][1] == "") {
                        buttons[1][1].setText("O");
                        buttons[1][1].setTextColor(nicc);
                        return;
                    }
                    if (field[1][2] == "") {
                        buttons[1][2].setText("O");
                        buttons[1][2].setTextColor(nicc);
                        return;
                    }
                    if (field[1][3] == "") {
                        buttons[1][3].setText("O");
                        buttons[1][3].setTextColor(nicc);
                        return;
                    }
                    if (field[1][4] == "") {
                        buttons[1][4].setText("O");
                        buttons[1][4].setTextColor(nicc);
                        return;
                    }
                    if (field[2][0] == "") {
                        buttons[2][0].setText("O");
                        buttons[2][0].setTextColor(nicc);
                        return;
                    }
                    if (field[2][1] == "") {
                        buttons[2][1].setText("O");
                        buttons[2][1].setTextColor(nicc);
                        return;
                    }
                    if (field[2][2] == "") {
                        buttons[2][2].setText("O");
                        buttons[2][2].setTextColor(nicc);
                        return;
                    }
                    if (field[2][3] == "") {
                        buttons[2][3].setText("O");
                        buttons[2][3].setTextColor(nicc);
                        return;
                    }
                    if (field[2][4] == "") {
                        buttons[2][4].setText("O");
                        buttons[2][4].setTextColor(nicc);
                        return;
                    }
                    if (field[3][0] == "") {
                        buttons[3][0].setText("O");
                        buttons[3][0].setTextColor(nicc);
                        return;
                    }
                    if (field[3][1] == "") {
                        buttons[3][1].setText("O");
                        buttons[3][1].setTextColor(nicc);
                        return;
                    }
                    if (field[3][2] == "") {
                        buttons[3][2].setText("O");
                        buttons[3][2].setTextColor(nicc);
                        return;
                    }
                    if (field[3][3] == "") {
                        buttons[3][3].setText("O");
                        buttons[3][3].setTextColor(nicc);
                        return;
                    }
                    if (field[3][4] == "") {
                        buttons[3][4].setText("O");
                        buttons[3][4].setTextColor(nicc);
                        return;
                    }
                    if (field[4][0] == "") {
                        buttons[4][0].setText("O");
                        buttons[4][0].setTextColor(nicc);
                        return;
                    }
                    if (field[4][1] == "") {
                        buttons[4][1].setText("O");
                        buttons[4][1].setTextColor(nicc);
                        return;
                    }
                    if (field[4][2] == "") {
                        buttons[4][2].setText("O");
                        buttons[4][2].setTextColor(nicc);
                        return;
                    }
                    if (field[4][3] == "") {
                        buttons[4][3].setText("O");
                        buttons[4][3].setTextColor(nicc);
                        return;
                    }
                    if (field[4][4] == "") {
                        buttons[4][4].setText("O");
                        buttons[4][4].setTextColor(nicc);
                        return;
                    }


                }

            }
        }
    }

    private void player1Wins() {
        player1Points++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void player2Wins() {
        player2Points++;
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePointsText() {
        textViewPlayer1.setText("Player 1: " + player1Points);
        textViewPlayer2.setText("Player 2: " + player2Points);
    }

    private void resetBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setText("");
            }
        }

        roundCount = 0;
        player1Turn = true;
    }

    private void resetGame() {
        player1Points = 0;
        player2Points = 0;
        updatePointsText();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", roundCount);
        outState.putInt("player1Points", player1Points);
        outState.putInt("player2Points", player2Points);
        outState.putBoolean("player1Turn", player1Turn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        roundCount = savedInstanceState.getInt("roundCount");
        player1Points = savedInstanceState.getInt("player1Points");
        player2Points = savedInstanceState.getInt("player2Points");
        player1Turn = savedInstanceState.getBoolean("player1Turn");
    }

}

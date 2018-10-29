package com.example.leili.papiersteinschere;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.leili.papiersteinschere.MainActivity.sharedPref;

public class ResultScreen extends AppCompatActivity {

    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultscreen);
        ButterKnife.bind(this);
        message = findViewById(R.id.changeText);
    }

    @OnClick(R.id.startNewRound)
    void onClickStartNewRound() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
    }
    @OnClick(R.id.winner)
    void onClickShowWinner() {

        int defValuePlayers = getResources().getInteger(R.integer.defValuePlayers);
        int auswahlPTwo = sharedPref.getInt(getString(R.string.auswahlPTwo), defValuePlayers);
        int auswahlPOne = sharedPref.getInt("auswahlPOne", defValuePlayers);

        determineWinner(auswahlPTwo, auswahlPOne);
    }

    private void determineWinner(int auswahlPTwo, int auswahlPOne) {
        if (auswahlPOne == auswahlPTwo) {
            message.setText("Unentschieden, beide Spielenden haben die Auswahl " + getAuswahl(auswahlPOne));
        } else {
            if (auswahlPOne == 0) {
                if (auswahlPTwo == 1) {
                    message.setText("Person 1 schlägt Person 2 " + getAuswahl(auswahlPOne) + " > " + getAuswahl(auswahlPTwo));
                } else {
                    message.setText("Person 2 umwickelt Person 1 " + getAuswahl(auswahlPTwo) + ">" + getAuswahl(auswahlPOne));
                }
            } else if (auswahlPOne == 1) {
                if (auswahlPTwo == 0) {
                    message.setText("Person 2 schlägt Person 1 " + getAuswahl(auswahlPTwo) + ">" + getAuswahl(auswahlPOne));
                } else {
                    message.setText("Person 1 zerschneidet Person 2 " + getAuswahl(auswahlPOne) + ">" + getAuswahl(auswahlPTwo));
                }

            } else {
                if (auswahlPTwo == 0) {
                    message.setText("Person 1 umwickelt Person 2 " + getAuswahl(auswahlPOne) + ">" + getAuswahl(auswahlPTwo));
                } else {
                    message.setText("Person 2 zerschneidet Person 1 " + getAuswahl(auswahlPTwo) + ">" + getAuswahl(auswahlPOne));
                }
            }
        }
    }

    private String getAuswahl(int auswahlPlayer) {
        if (auswahlPlayer == 0) {
            return "Stein";
        } else if (auswahlPlayer == 1) {
            return "Schere";
        } else {
            return "Papier";
        }

        }


    }


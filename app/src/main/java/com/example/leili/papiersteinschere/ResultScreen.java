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
    void onClickWin(){

        int defValuePlayers = getResources().getInteger(R.integer.defValuePlayers);
        int auswahlPTwo = sharedPref.getInt(getString(R.string.auswahlPTwo), defValuePlayers);
        int auswahlPOne = sharedPref.getInt("auswahlPOne", defValuePlayers);

        if (auswahlPOne == auswahlPTwo) {
            message.setText("Draw, beide Player haben die Auswahl " + getAuswahl(auswahlPOne));
        } else {
            if (auswahlPOne == 0) {
                if (auswahlPTwo == 1) {
                    message.setText("Player1 schlägt Player2 " + getAuswahl(auswahlPOne) + ">" + getAuswahl(auswahlPTwo));
                } else {
                    message.setText("Player2 umwickelt Player1 " + getAuswahl(auswahlPTwo) + ">" + getAuswahl(auswahlPOne));
                }
            } else if (auswahlPOne == 1) {
                if (auswahlPTwo == 0) {
                    message.setText("Player2 schlägt Player1 " + getAuswahl(auswahlPTwo) + ">" + getAuswahl(auswahlPOne));
                } else {
                    message.setText("Player1 zerschneidet Player2 " + getAuswahl(auswahlPOne) + ">" + getAuswahl(auswahlPTwo));
                }

            } else {
                if (auswahlPTwo == 0) {
                    message.setText("Player1 umwickelt Player2 " + getAuswahl(auswahlPOne) + ">" + getAuswahl(auswahlPTwo));
                } else {
                    message.setText("Player2 zerschneidet Player1 " + getAuswahl(auswahlPTwo) + ">" + getAuswahl(auswahlPOne));
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


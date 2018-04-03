package com.example.leili.papiersteinschere;

import android.content.Context;
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
        message = (TextView) (findViewById(R.id.changeText));
    }

    @OnClick(R.id.testButtonPTwo)
    void onClickTestButtonTwo() {
        int defValuePlayers = getResources().getInteger(R.integer.defValuePlayers);
        int auswahlPTwo = sharedPref.getInt(getString(R.string.auswahlPTwo), defValuePlayers);
        Context context = getApplicationContext();
        String text = String.valueOf(auswahlPTwo);
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    @OnClick(R.id.winner)
    void onClickWin(){

        int defValuePlayers = getResources().getInteger(R.integer.defValuePlayers);
        int auswahlPTwo = sharedPref.getInt(getString(R.string.auswahlPTwo), defValuePlayers);
        message.setText("funktioniert");
        }


    }


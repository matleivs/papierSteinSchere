package com.example.leili.papiersteinschere;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.leili.papiersteinschere.MainActivity.sharedPref;

public class WaitPlayer2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_player2);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.goButton)
    void onClickGoButton(){
        openPlayer2Chose();
    }
    @OnClick(R.id.testButton)
    void onClickTestbutton(){
        int defValuePlayers = getResources().getInteger(R.integer.defValuePlayers);
        int auswahlPOne = sharedPref.getInt(getString(R.string.auswahlPOne), defValuePlayers);
        Context context = getApplicationContext();
        String text = String.valueOf(auswahlPOne);
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
    }
    private void openPlayer2Chose(){
        Intent intent = new Intent(this,Player2Choose.class);
        startActivity(intent);
    }
}

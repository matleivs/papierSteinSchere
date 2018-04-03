package com.example.leili.papiersteinschere;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.leili.papiersteinschere.MainActivity.editor;
import static com.example.leili.papiersteinschere.MainActivity.sharedPref;

public class Player2Choose extends AppCompatActivity {
    @BindView(R.id.stoneButtonP2) Button steinKnopf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2_choose);
        ButterKnife.bind(this);
        editor = sharedPref.edit();

        steinKnopf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("auswahlPTwo",0);
                editor.commit();
                openResultScreen();

            }
        });
    }
    private void openResultScreen(){
        Intent intent = new Intent(this,ResultScreen.class);
        startActivity(intent);
    }
    @OnClick(R.id.scissorsButtonP2)
    void onClickScissors(){
        editor.putInt("auswahlPTwo",1);
        editor.commit();
        openResultScreen();
    }

    @OnClick(R.id.paperButtonP2)
    void onClickPaper(){
        editor.putInt("auswahlPTwo",2);
        editor.commit();
        openResultScreen();
    }
}
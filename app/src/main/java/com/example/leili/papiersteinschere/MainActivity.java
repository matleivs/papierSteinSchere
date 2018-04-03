package com.example.leili.papiersteinschere;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.stoneButton)
    Button steinKnopf;
    public static SharedPreferences sharedPref;
    public static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sharedPref = this.getSharedPreferences(
                getString(R.string.sharedPrefSteinScherePapier), Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        steinKnopf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt(getString(R.string.auswahlPOne), 0);
                editor.commit();
                openWaitPlayer2();

            }
        });
    }

    private void openWaitPlayer2() {
        Intent intent = new Intent(this, WaitPlayer2.class);
        startActivity(intent);
    }

    @OnClick(R.id.scissorsButton)
    void onClickScissors() {
        editor.putInt(getString(R.string.auswahlPOne), 1);
        editor.commit();
        openWaitPlayer2();
    }

    @OnClick(R.id.paperButton)
    void onClickPaper() {
        editor.putInt(getString(R.string.auswahlPOne), 2);
        editor.commit();
        openWaitPlayer2();
    }


}

package com.example.android.pms_victory;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by tomas on 07/09/2017.
 */

public class CorrectAddress extends AppCompatActivity {

    EditText mCorrectAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correct_address);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        mCorrectAddress = (EditText) findViewById(R.id.edit_address);
        mCorrectAddress.setText(MainActivity.holder.getmAddress());

        Button start = (Button) findViewById(R.id.comeback_to_map);
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MainActivity.holder.setmAddress(mCorrectAddress.getText().toString());

                finish();
            }
        });

    }
}

package com.example.android.pms_victory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by tomas on 05/10/2017.
 */

public class Comment extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment);


        Button sell = (Button) findViewById(R.id.button_next);

        sell.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText comment = (EditText) findViewById(R.id.commentText);
                MainActivity.holder.mComments = comment.getText().toString();

                Intent lastIntend = new Intent(Comment.this, ScreenLast.class);

                // Start the new activity
                startActivity(lastIntend);
            }
        });


    }

}

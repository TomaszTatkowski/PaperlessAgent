package com.example.android.pms_victory;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by tomas on 05/09/2017.
 */

public class SellBuy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell_rent);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button sell = (Button) findViewById(R.id.button_sell);

        sell.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MainActivity.holder.mSellOrRent = "Sell";
                // Create a new intent to open the {@link NumbersActivity}
                Intent lastIntend = new Intent(SellBuy.this, FormOwnership.class);

                // Start the new activity
                startActivity(lastIntend);
            }
        });


        Button rent = (Button) findViewById(R.id.button_rent);

        rent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MainActivity.holder.mEICR = "N/A";
                MainActivity.holder.mEPC = "N/A";
                MainActivity.holder.mGC = "N/A";
                MainActivity.holder.mPAT = "N/A";
                MainActivity.holder.mCooker = "N/A";
                MainActivity.holder.mFridge = "N/A";
                MainActivity.holder.mWasher = "N/A";
                MainActivity.holder.mSellOrRent = "Rent";
                // Create a new intent to open the {@link NumbersActivity}
                Intent lastIntend = new Intent(SellBuy.this, Price.class);

                // Start the new activity
                startActivity(lastIntend);
            }
        });



    }
}

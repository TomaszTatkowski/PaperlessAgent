package com.example.android.pms_victory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by tomas on 01/08/2017.
 */

public class ScreenLast extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_screen);

        if (MainActivity.holder.mSellOrRent == "Rent")
            MainActivity.holder.mOwnership = "N/A";


        //display all informaction from storage class @Storage (holder)
        TextView view = (TextView) findViewById(R.id.text);
        view.setText("Address: " + MainActivity.holder.mAddress + "\n" +
                "Sell/Rent: " + MainActivity.holder.mSellOrRent + "\n" +
                "Ownership Type: " + MainActivity.holder.mOwnership + "\n" +
                "Property Type: " + MainActivity.holder.mPropertyType + "\n" +
                "Availability: " + MainActivity.holder.mAvailability + "\n" +
                "Price: " + MainActivity.holder.mPrice + "\n" +
                "Bills Included: " + MainActivity.holder.mBillsIncluded + "\n" +
                "EICR: " + MainActivity.holder.mEICR + "\n" +
                "EPC: " + MainActivity.holder.mEPC + "\n" +
                "GC: " + MainActivity.holder.mGC + "\n" +
                "PAT: " + MainActivity.holder.mPAT + "\n" +
                "Cooker: " + MainActivity.holder.mCooker + "\n" +
                "Fridge: " + MainActivity.holder.mFridge + "\n" +
                "Washer: " + MainActivity.holder.mWasher + "\n" +
                "Renovation Required: " + MainActivity.holder.mRenovationRequired + "\n" +
                "No of room: " + MainActivity.holder.mNoOfRooms + "\n" +
                "Furnished: " + MainActivity.holder.mFurnished + "\n" +
                "No of bathrooms: " + MainActivity.holder.mNoOfBathrooms + "\n" +
                "No of toilets: " + MainActivity.holder.mNoOfToilets + "\n" +
                "Toilets in bathroms: " + MainActivity.holder.mToiletsInBathrooms + "\n" +
                "Garden: " + MainActivity.holder.mGarden + "\n" +
                "Driveway: " + MainActivity.holder.mDriveway + "\n" +
                "Carpark: " + MainActivity.holder.mCarpark + "\n" +
                "Pictures: " + MainActivity.holder.mDirectoryPath + "\n"+
                "Comment: " + MainActivity.holder.mComments + "\n");
        //view.setText(MainActivity.holder.toString());


        Button finish = (Button) findViewById(R.id.button_finish);

        finish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //TO DO on finish
                finish();
                moveTaskToBack(true);
            }
        });
    }

        public void OnSend(View view) {
//            String address = MainActivity.holder.mAddress.replace(",", "_");
            String address = MainActivity.holder.mAddress.replaceAll("(\\r|\\n|\\r\\n)+", "");

//            String address = MainActivity.holder.mAddress;
            String type = "insert";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, address);
        }


}
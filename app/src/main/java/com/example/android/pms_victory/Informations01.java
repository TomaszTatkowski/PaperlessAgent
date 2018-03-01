package com.example.android.pms_victory;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by tomas on 07/09/2017.
 */

public class Informations01 extends AppCompatActivity {

    EditText iNoOfRooms;
    CheckBox iFurnished;
    EditText iNoOfBathrooms;
    EditText iNoOfToilets;
    CheckBox iToiletsInBathrooms;
    CheckBox iGarden;
    CheckBox iDriveway;
    CheckBox iCarpark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informations_1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button sell = (Button) findViewById(R.id.button_next);

        sell.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                iNoOfRooms = (EditText) findViewById(R.id.rooms_no);
                MainActivity.holder.mNoOfRooms = iNoOfRooms.getText().toString();
                if (TextUtils.isEmpty(MainActivity.holder.mNoOfRooms))
                    MainActivity.holder.mNoOfRooms = "Unknown";

                iFurnished = (CheckBox) findViewById(R.id.checkBox_furnished);
                if (iFurnished.isChecked())
                    MainActivity.holder.mFurnished = "YES";
                else MainActivity.holder.mFurnished = "NO";


                iNoOfBathrooms = (EditText) findViewById(R.id.bathrooms_no);
                MainActivity.holder.mNoOfBathrooms = iNoOfBathrooms.getText().toString();
                if (TextUtils.isEmpty(MainActivity.holder.mNoOfBathrooms))
                    MainActivity.holder.mNoOfBathrooms = "Unknown";



                iNoOfToilets = (EditText) findViewById(R.id.toilets_no);
                MainActivity.holder.mNoOfToilets = iNoOfToilets.getText().toString();
                if (TextUtils.isEmpty(MainActivity.holder.mNoOfToilets))
                    MainActivity.holder.mNoOfToilets = "Unknown";

                iToiletsInBathrooms = (CheckBox) findViewById(R.id.checkBox_in_bathroom);
                if (iToiletsInBathrooms.isChecked())
                    MainActivity.holder.mToiletsInBathrooms = "YES";
                else MainActivity.holder.mToiletsInBathrooms = "NO";


                iGarden = (CheckBox) findViewById(R.id.checkBox_garden);
                if (iGarden.isChecked())
                    MainActivity.holder.mGarden = "YES";
                else MainActivity.holder.mGarden = "NO";

                iDriveway = (CheckBox) findViewById(R.id.checkBox_driveway);
                if (iDriveway.isChecked())
                    MainActivity.holder.mDriveway = "YES";
                else MainActivity.holder.mDriveway = "NO";

                iCarpark = (CheckBox) findViewById(R.id.checkBox_carpark);
                if (iCarpark.isChecked())
                    MainActivity.holder.mCarpark = "YES";
                else MainActivity.holder.mCarpark = "NO";





                // Create a new intent to open the {@link NumbersActivity}
                Intent lastIntend = new Intent(Informations01.this, Photo.class);

                // Start the new activity
                startActivity(lastIntend);
            }
        });




    }

}

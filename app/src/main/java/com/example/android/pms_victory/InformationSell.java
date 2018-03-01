package com.example.android.pms_victory;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by tomas on 08/09/2017.
 */

public class InformationSell extends AppCompatActivity {


    private CheckBox iEICR;
    private CheckBox iEPC;
    private CheckBox iGC;
    private CheckBox iPAT;
    private CheckBox iCooker;
    private CheckBox iFridge;
    private CheckBox iWasher;
    private CheckBox iRenovationRequired;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_sell);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button sell = (Button) findViewById(R.id.button_next);

        sell.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                iEICR = (CheckBox) findViewById(R.id.checkBox_cert_EICR);
                if (iEICR.isChecked())
                    MainActivity.holder.mEICR = "YES";
                else MainActivity.holder.mEICR = "NO";

                iEPC = (CheckBox) findViewById(R.id.checkBox_cert_EPC);
                if (iEPC.isChecked())
                    MainActivity.holder.mEPC = "YES";
                else MainActivity.holder.mEPC = "NO";

                iGC = (CheckBox) findViewById(R.id.checkBox_cert_GC);
                if (iGC.isChecked())
                    MainActivity.holder.mGC = "YES";
                else MainActivity.holder.mGC = "NO";

                iPAT = (CheckBox) findViewById(R.id.checkBox_cert_PAT);
                if (iPAT.isChecked())
                    MainActivity.holder.mPAT = "YES";
                else MainActivity.holder.mPAT = "NO";

                iCooker = (CheckBox) findViewById(R.id.checkBox_cooker);
                if (iCooker.isChecked())
                    MainActivity.holder.mCooker = "YES";
                else MainActivity.holder.mCooker = "NO";

                iFridge = (CheckBox) findViewById(R.id.checkBox_fridge);
                if (iFridge.isChecked())
                    MainActivity.holder.mFridge = "YES";
                else MainActivity.holder.mFridge = "NO";

                iWasher = (CheckBox) findViewById(R.id.checkBox_washer);
                if (iWasher.isChecked())
                    MainActivity.holder.mWasher = "YES";
                else MainActivity.holder.mWasher = "NO";

                iRenovationRequired = (CheckBox) findViewById(R.id.checkBox_renovation);
                if (iRenovationRequired.isChecked())
                    MainActivity.holder.mRenovationRequired = "YES";
                else MainActivity.holder.mRenovationRequired = "NO";


                // Create a new intent to open the {@link NumbersActivity}
                Intent lastIntend = new Intent(InformationSell.this, Price.class);

                // Start the new activity
                startActivity(lastIntend);
            }
        });




    }

}

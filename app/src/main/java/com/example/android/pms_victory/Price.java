package com.example.android.pms_victory;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by tomas on 06/09/2017.
 */

public class Price extends AppCompatActivity {

    private Spinner mPropertyTypeSpinner;
    private EditText mAvailableData;
    private EditText mPrice;
    private CheckBox mBillsIncluded;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.price);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button sell = (Button) findViewById(R.id.to_informations01);

        sell.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mAvailableData = (EditText) findViewById(R.id.data_value);
                MainActivity.holder.mAvailability = mAvailableData.getText().toString();
                if (TextUtils.isEmpty(MainActivity.holder.mAvailability))
                    MainActivity.holder.mAvailability = "Unknown";

                mPrice = (EditText) findViewById(R.id.price_value);
                MainActivity.holder.mPrice = 0;
                try {
                MainActivity.holder.mPrice = Integer.parseInt(mPrice.getText().toString());}
                catch (Exception e){
                Log.e("", "int needed but is alright");
                }

                mBillsIncluded = (CheckBox) findViewById(R.id.checkBox_bills);

                if (mBillsIncluded.isChecked())
                    MainActivity.holder.mBillsIncluded = "YES";
                else MainActivity.holder.mBillsIncluded = "NO";

                // Create a new intent to open the {@link NumbersActivity}
                Intent lastIntend = new Intent(Price.this, Informations01.class);

                // Start the new activity
                startActivity(lastIntend);
            }
        });

        mPropertyTypeSpinner= (Spinner) findViewById(R.id.spinner_property_type);
        setupSpinner();



    }

    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter propertyTypeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_property_type_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        propertyTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mPropertyTypeSpinner.setAdapter(propertyTypeSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mPropertyTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {

                    if (selection.equals(getString(R.string.flat))) {
                        MainActivity.holder.mPropertyType = "Flat";}

                    else if (selection.equals(getString(R.string.house))) {
                        MainActivity.holder.mPropertyType = "House";}

                    else if (selection.equals(getString(R.string.other_property_type))) {
                        MainActivity.holder.mPropertyType = "Other";}

                    else if (selection.equals(getString(R.string.choose_a_option))) {
                        MainActivity.holder.mPropertyType = "Unknown";}


                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                MainActivity.holder.mPropertyType = "Unknown"; // Unknown
            }
        });
    }

}

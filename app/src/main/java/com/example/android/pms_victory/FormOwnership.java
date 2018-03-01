package com.example.android.pms_victory;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by tomas on 06/09/2017.
 */

public class FormOwnership extends AppCompatActivity {

    private Spinner mOwnershipSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_ownership);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button sell = (Button) findViewById(R.id.to_sell_information);

        sell.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                // Create a new intent to open the {@link NumbersActivity}
                Intent lastIntend = new Intent(FormOwnership.this, InformationSell.class);

                // Start the new activity
                startActivity(lastIntend);
            }
        });

        mOwnershipSpinner = (Spinner) findViewById(R.id.spinner_ownership);

        setupSpinner();


    }

    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter ownershipSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_ownership_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        ownershipSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mOwnershipSpinner.setAdapter(ownershipSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mOwnershipSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {

                    if (selection.equals(getString(R.string.freehold))) {
                        MainActivity.holder.mOwnership = "Freehold";}

                    else if (selection.equals(getString(R.string.leasehold))) {
                        MainActivity.holder.mOwnership = "Leasehold";}

                    else if (selection.equals(getString(R.string.choose_a_option))) {
                        MainActivity.holder.mOwnership = "Unknown";}


                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                MainActivity.holder.mOwnership = "N/A"; // Unknown
            }
        });
    }

}

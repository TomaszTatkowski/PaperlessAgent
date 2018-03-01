package com.example.android.pms_victory;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

import static com.example.android.pms_victory.MainActivity.holder;

/**
 * Created by tomas on 01/08/2017.
 */

public class MapAddress extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap m_map;
    boolean mapReady=false;
    MarkerOptions defaultPosition;




    double lat = holder.getLat();
    double lng = holder.getLgn();
    LatLng currentPosition = new LatLng(lat,lng);

    private TextView addressFirstLine;
    private TextView addressSecondLine;
    private TextView addressThirdLine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_address);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button start = (Button) findViewById(R.id.button_next);
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent sellBuyIntend = new Intent(MapAddress.this, SellBuy.class);

                // Start the new activity
                startActivity(sellBuyIntend);
            }
        });

        Button correctAddress = (Button) findViewById(R.id.go_to_correct_addres);
        correctAddress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent correctAdd = new Intent(MapAddress.this, CorrectAddress.class);

                // Start the new activity
                startActivity(correctAdd);
            }
        });


        if(mapReady)
            m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        String address = getCompleteAddressString(lat, lng);
        addressFirstLine = (TextView) findViewById(R.id.first_line);
        addressFirstLine.setText(address);
        holder.setmAddress(getCompleteAddressString(lat, lng));
        MainActivity.holder.mAddress = MainActivity.holder.mAddress.replaceAll("(\\r|\\n|\\r\\n)+", "");




    }

    @Override
    protected void onStart() {
        super.onStart();
        addressFirstLine.setText(MainActivity.holder.getmAddress());
    }

    @Override
    public void onMapReady(GoogleMap map) {

        mapReady=true;
        m_map = map;
        //LatLng home = new LatLng(lat, lng);
        CameraPosition target = CameraPosition.builder().target(currentPosition).zoom(12).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));

        defaultPosition = new MarkerOptions()
                .position(new LatLng(lat, lng))
                .title("You are here");
        m_map.addMarker(defaultPosition);

    }


    private String getCompleteAddressString(double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<android.location.Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                android.location.Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                strAdd = strReturnedAddress.toString();
                Log.w("My Current loction ", "" + strReturnedAddress.toString());
            } else {
                Log.w("My Current loction ", "No Address returned!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.w("My Current loction ", "Canont get Address!");
        }
        return strAdd;
    }
}
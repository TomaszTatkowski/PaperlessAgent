package com.example.android.pms_victory;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by tomas on 03/10/2017.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    BackgroundWorker (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

        String login_url = "http://awful-implementatio.000webhostapp.com/insert.php";
        if(type.equals("insert")) {
            try {
                String address = params[1];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+"&"
                        +URLEncoder.encode("ownership","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mOwnership,"UTF-8")+"&"
                        +URLEncoder.encode("sellOrRent","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mSellOrRent,"UTF-8")+"&"
                        +URLEncoder.encode("propertyType","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mPropertyType,"UTF-8")+"&"
                        +URLEncoder.encode("eICR","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mEICR,"UTF-8")+"&"
                        +URLEncoder.encode("ePC","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mEPC,"UTF-8")+"&"
                        +URLEncoder.encode("gC","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mGC,"UTF-8")+"&"
                        +URLEncoder.encode("pAT","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mPAT,"UTF-8")+"&"
                        +URLEncoder.encode("cooker","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mCooker,"UTF-8")+"&"
                        +URLEncoder.encode("fridge","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mFridge,"UTF-8")+"&"
                        +URLEncoder.encode("washer","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mWasher,"UTF-8")+"&"
                        +URLEncoder.encode("renovationRequired","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mRenovationRequired,"UTF-8")+"&"
                        +URLEncoder.encode("availability","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mAvailability,"UTF-8")+"&"
                        +URLEncoder.encode("price","UTF-8")+"="+URLEncoder.encode(Integer.toString(MainActivity.holder.mPrice),"UTF-8")+"&"
                        +URLEncoder.encode("billsIncluded","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mBillsIncluded,"UTF-8")+"&"
                        +URLEncoder.encode("noOfRooms","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mNoOfRooms,"UTF-8")+"&"
                        +URLEncoder.encode("furnished","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mFurnished,"UTF-8")+"&"
                        +URLEncoder.encode("noOfBathrooms","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mNoOfBathrooms,"UTF-8")+"&"
                        +URLEncoder.encode("noOfToilets","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mNoOfToilets,"UTF-8")+"&"
                        +URLEncoder.encode("toiletsInBathrooms","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mToiletsInBathrooms,"UTF-8")+"&"
                        +URLEncoder.encode("garden","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mGarden,"UTF-8")+"&"
                        +URLEncoder.encode("driveway","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mDriveway,"UTF-8")+"&"
                        +URLEncoder.encode("carpark","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mCarpark,"UTF-8")+"&"
                        +URLEncoder.encode("comments","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mComments,"UTF-8")+"&"
                        +URLEncoder.encode("directoryPath","UTF-8")+"="+URLEncoder.encode(MainActivity.holder.mDirectoryPath,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

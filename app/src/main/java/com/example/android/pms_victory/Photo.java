package com.example.android.pms_victory;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
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
 * Created by tomas on 21/09/2017.
 */

public class Photo extends AppCompatActivity {


    Button sendPictures;
    ImageView photo1;
    ImageView photo2;
    ImageView photo3;
    ImageView photo4;
    ImageView photo5;
    ImageView photoView1;
    ImageView photoView2;
    ImageView photoView3;
    ImageView photoView4;
    ImageView photoView5;
    ImageView bin1;
    ImageView bin2;
    ImageView bin3;
    ImageView bin4;
    ImageView bin5;

    private static final String SERVER_ADDRESS = "http://awful-implementatio.000webhostapp.com/savePicture.php";
    private static final int CAMERA_REQUEST_1 = 1884;
    private static final int CAMERA_REQUEST_2 = 1885;
    private static final int CAMERA_REQUEST_3 = 1886;
    private static final int CAMERA_REQUEST_4 = 1887;
    private static final int CAMERA_REQUEST_5 = 1888;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photos);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button sell = (Button) findViewById(R.id.button_next);

        sell.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent lastIntend = new Intent(Photo.this, Comment.class);

                startActivity(lastIntend);
            }
        });

        sendPictures = (Button) findViewById(R.id.send_pictures);


        sendPictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (photoView1.getDrawable() != null) {
                    Bitmap image1 = ((BitmapDrawable) photoView1.getDrawable()).getBitmap();
                    String encodedImage = convertImageToString(image1);
                    //Log.e("picture", encodedImage1);
                    new UploadImage(encodedImage).execute();
                }


                if (photoView2.getDrawable() != null) {
                    Bitmap image2 = ((BitmapDrawable) photoView2.getDrawable()).getBitmap();
                    String encodedImage2 = convertImageToString(image2);
                    //Log.e("picture", encodedImage1);
                    new UploadImage(encodedImage2).execute();
                }


                if (photoView3.getDrawable() != null) {
                    Bitmap image3 = ((BitmapDrawable) photoView3.getDrawable()).getBitmap();
                    String encodedImage3 = convertImageToString(image3);
                    //Log.e("picture", encodedImage1);
                    new UploadImage(encodedImage3).execute();
                }

                if (photoView4.getDrawable() != null) {
                    Bitmap image4 = ((BitmapDrawable) photoView4.getDrawable()).getBitmap();
                    String encodedImage4 = convertImageToString(image4);
                    //Log.e("picture", encodedImage1);
                    new UploadImage(encodedImage4).execute();
                }

                if (photoView5.getDrawable() != null) {
                    Bitmap image5 = ((BitmapDrawable) photoView5.getDrawable()).getBitmap();
                    String encodedImage5 = convertImageToString(image5);
                    //Log.e("picture", encodedImage1);
                    new UploadImage(encodedImage5).execute();
                }


            }
        });

        photo1 = (ImageView) findViewById(R.id.photo_1);
        photoView1 = (ImageView) findViewById(R.id.Photo_view_1);
        bin1 = (ImageView) findViewById(R.id.bin_1);


        photo2 = (ImageView) findViewById(R.id.photo_2);
        photoView2 = (ImageView) findViewById(R.id.Photo_view_2);
        bin2 = (ImageView) findViewById(R.id.bin_2);

        photo3 = (ImageView) findViewById(R.id.photo_3);
        photoView3 = (ImageView) findViewById(R.id.Photo_view_3);
        bin3 = (ImageView) findViewById(R.id.bin_3);

        photo4 = (ImageView) findViewById(R.id.photo_4);
        photoView4 = (ImageView) findViewById(R.id.Photo_view_4);
        bin4 = (ImageView) findViewById(R.id.bin_4);

        photo5 = (ImageView) findViewById(R.id.photo_5);
        photoView5 = (ImageView) findViewById(R.id.Photo_view_5);
        bin5 = (ImageView) findViewById(R.id.bin_5);


        photo1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST_1);

            }
        });

        photo2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST_2);

            }
        });

        photo3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST_3);

            }
        });

        photo4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST_4);

            }
        });

        photo5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST_5);

            }
        });

        bin1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                photoView1.setImageResource(0);

            }
        });

        bin2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                photoView2.setImageResource(0);

            }
        });

        bin3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                photoView3.setImageResource(0);

            }
        });

        bin4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                photoView4.setImageResource(0);

            }
        });
//
        bin5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                photoView5.setImageResource(0);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
        if (resultCode == Activity.RESULT_OK) {


            switch (requestCode) {
                case CAMERA_REQUEST_1:
                    //Bitmap photo1 = (Bitmap) data.getExtras().get("data");
//                MainActivity.holder.mPath = data.getData().getPath();

                    Uri photo1temp = data.getData();
                    photoView1.setImageURI(photo1temp);
                    break;

                case CAMERA_REQUEST_2:
                    Uri photo2temp = data.getData();
                    photoView2.setImageURI(photo2temp);
                    break;

                case CAMERA_REQUEST_3:
                    Uri photo3temp = data.getData();
                    photoView3.setImageURI(photo3temp);
                    break;

                case CAMERA_REQUEST_4:
                    Uri photo4temp = data.getData();
                    photoView4.setImageURI(photo4temp);
                    break;

                case CAMERA_REQUEST_5:
                    Uri photo5temp = data.getData();
                    photoView5.setImageURI(photo5temp);
                    break;
            }
        }
    }


    private class UploadImage extends AsyncTask<String, Void, String> {

        String imageString;


        UploadImage(String string) {
            this.imageString = string;
        }


        @Override
        protected String doInBackground(String... params) {

            try {

                Long tsLong1 = System.currentTimeMillis()/100;
                String imageNameTime = tsLong1.toString();
                MainActivity.holder.mDirectoryPath +="<->" + imageNameTime+".jpg";

                URL url = new URL(SERVER_ADDRESS);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imageString, "UTF-8")+"&"
                        +URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(imageNameTime,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
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

            return null;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), "Image "+result+" has been send.", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

    public String convertImageToString(Bitmap bitmap){

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
        String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);

        return encodedImage;
    }
}

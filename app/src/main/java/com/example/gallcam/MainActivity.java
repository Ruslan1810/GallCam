package com.example.gallcam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   private Button btnGallery;
   private  Button btnCamera;
   private Button btnElements;
   private  Button btnGps;
   private  ImageView imgCamera;
   private ImageButton imgBtn1;
   private ImageButton imgBtn2;
   private ImageButton imgBtn3;
   TextView txtGps;
   LocationManager locationManager;
   LocationListener listener;

   static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamera = findViewById(R.id.buttonCamera);
        btnGallery = findViewById(R.id.buttonGallery);
        btnElements = findViewById(R.id.buttonElements);
        btnGps = findViewById(R.id.button);
        imgCamera = findViewById(R.id.imageCam);
        imgBtn1 = findViewById(R.id.imageButton1);
        imgBtn2 = findViewById(R.id.imageButton2);
        imgBtn3 = findViewById(R.id.imageButton3);
        txtGps = findViewById(R.id.textView);
        btnGps = findViewById(R.id.button);


        imgBtn1.setVisibility(View.GONE);
        imgBtn2.setVisibility(View.GONE);
        imgBtn3.setVisibility(View.GONE);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //txtGps.append("n " + location.getLongitude() + " " + location.getLatitude());
                txtGps.setText("n " + location.getLongitude() + " " + location.getLatitude());
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };

        addListenerOnButton();
        configure_gps();


    }

    public  void addListenerOnButton(){

        btnGallery.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intGallery = new Intent("com.example.gallcam.GalleryActivity");
                        startActivity(intGallery);
                    }
                }
        );

        btnCamera.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                        }
                    }
                }
        );

        btnElements.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        imgBtn1.setVisibility(View.VISIBLE);
                        imgBtn2.setVisibility(View.VISIBLE);
                        imgBtn3.setVisibility(View.VISIBLE);
                    }
                }
        );

        imgBtn1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        imgCamera.setImageResource(R.drawable.one);
                    }
                }
        );
        imgBtn2.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        imgCamera.setImageResource(R.drawable.two);
                    }
                }
        );
        imgBtn3.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        imgCamera.setImageResource(R.drawable.tree);
                    }
                }
        );
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imgCamera.setImageBitmap(image);
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                configure_gps();
                break;
            default:
                break;
        }
    }

    void configure_gps() {
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}
                        , 10);
            }
            return;
        }
        // this code won'textView execute IF permissions are not allowed, because in the line above there is return statement.
        btnGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //noinspection MissingPermission
                locationManager.requestLocationUpdates("gps", 5000, 0, listener);
            }
        });
    }

}

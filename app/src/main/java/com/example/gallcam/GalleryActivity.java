package com.example.gallcam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.view.KeyEvent;
import android.view.View.OnClickListener;

import java.io.Serializable;

public class GalleryActivity extends AppCompatActivity{


    private ImageButton imgBtn1;
    private ImageButton imgBtn2;
    private ImageButton imgBtn3;
    private ImageButton imgBtn4;
    private ImageButton imgBtn5;
    private ImageButton imgBtn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        addListenerOnButton();



    }

    public  void addListenerOnButton(){
        imgBtn1 = findViewById(R.id.imageButton1);
        imgBtn2 = findViewById(R.id.imageButton2);
        imgBtn3 = findViewById(R.id.imageButton3);
        imgBtn4 = findViewById(R.id.imageButton4);
        imgBtn5 = findViewById(R.id.imageButton5);
        imgBtn6 = findViewById(R.id.imageButton6);

        OnClickListener onClickImgBtn1 = new OnClickListener() {
            @Override
            public void onClick(View v) {



                switch (v.getId()) {
                    case R.id.imageButton1:
                        Intent intent1 = new Intent(GalleryActivity.this, ImgActivity.class);
                        intent1.putExtra("name", R.drawable.one);
                        startActivity(intent1);
                        break;
                    case R.id.imageButton2:
                        Intent intent2 = new Intent(GalleryActivity.this, ImgActivity.class);
                        intent2.putExtra("name", R.drawable.two);
                        startActivity(intent2);
                        break;
                    case R.id.imageButton3:
                        Intent intent3 = new Intent(GalleryActivity.this, ImgActivity.class);
                        intent3.putExtra("name", R.drawable.tree);
                        startActivity(intent3);
                        break;
                    case R.id.imageButton4:
                        Intent intent4 = new Intent(GalleryActivity.this, ImgActivity.class);
                        intent4.putExtra("name", R.drawable.four);
                        startActivity(intent4);
                        break;
                    case R.id.imageButton5:
                        Intent intent5 = new Intent(GalleryActivity.this, ImgActivity.class);
                        intent5.putExtra("name", R.drawable.five);
                        startActivity(intent5);
                        break;
                    case R.id.imageButton6:
                        Intent intent6 = new Intent(GalleryActivity.this, ImgActivity.class);
                        intent6.putExtra("name", R.drawable.six);
                        startActivity(intent6);
                        break;
                }
            }
        };
        imgBtn1.setOnClickListener(onClickImgBtn1);
        imgBtn2.setOnClickListener(onClickImgBtn1);
        imgBtn3.setOnClickListener(onClickImgBtn1);
        imgBtn4.setOnClickListener(onClickImgBtn1);
        imgBtn5.setOnClickListener(onClickImgBtn1);
        imgBtn6.setOnClickListener(onClickImgBtn1);

    }

}

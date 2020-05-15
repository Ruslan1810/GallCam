package com.example.gallcam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View.OnClickListener;

import java.text.DateFormat;


public class ImgActivity extends AppCompatActivity {


    public ImageView imgBig;
    private ImageButton imgBtn1;
    private ImageButton imgBtn2;
    private ImageButton imgBtn3;
    private Button btnElements;
    private Bundle pathImgBig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        //большое изображение
        imgBig = findViewById(R.id.imageView1);
        int i = getIntent().getIntExtra("name", 0);
        imgBig.setImageResource(i);

        //мини картинки
        imgBtn1 = findViewById(R.id.imageButton1);
        imgBtn1.setImageResource(R.drawable.one);
        imgBtn2 = findViewById(R.id.imageButton2);
        imgBtn2.setImageResource(R.drawable.two);
        imgBtn3 = findViewById(R.id.imageButton3);
        imgBtn3.setImageResource(R.drawable.tree);

        imgBtn1.setVisibility(View.GONE);
        imgBtn2.setVisibility(View.GONE);
        imgBtn3.setVisibility(View.GONE);


        btnElements = findViewById(R.id.buttonViewMiniImg);

        addListenerOnButton();


    }


    public  void addListenerOnButton(){

        OnClickListener onClickbtnElements = new OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtn1.setVisibility(View.VISIBLE);
                imgBtn2.setVisibility(View.VISIBLE);
                imgBtn3.setVisibility(View.VISIBLE);

            }
        };
        OnClickListener onClickImgBtn1 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBig.setImageResource(R.drawable.one);

            }
        };
        OnClickListener onClickImgBtn2 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBig.setImageResource(R.drawable.two);

            }
        };
        OnClickListener onClickImgBtn3 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBig.setImageResource(R.drawable.tree);

            }
        };
        btnElements.setOnClickListener(onClickbtnElements);
        imgBtn1.setOnClickListener(onClickImgBtn1);
        imgBtn2.setOnClickListener(onClickImgBtn2);
        imgBtn3.setOnClickListener(onClickImgBtn3);
    }
}

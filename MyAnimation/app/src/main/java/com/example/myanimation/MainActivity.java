package com.example.myanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

        ImageView image;
        Button zoomin,zoomout,fadein,fadeout,slideup,slidedown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image=(ImageView) findViewById(R.id.imageView);
        zoomin=(Button) findViewById(R.id.zoomIn);
        zoomout=(Button) findViewById(R.id.zoomOut);
        fadein=(Button) findViewById(R.id.fadeIn);
        fadeout=(Button) findViewById(R.id.fadeOut);
        slideup=(Button) findViewById(R.id.slideUp);
        slidedown=(Button) findViewById(R.id.slideDown);



        zoomin.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                image.startAnimation(animation);
            }
        });

        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
                image.startAnimation(animation);
            }
        });

        fadein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                image.startAnimation(animation);
            }
        });

        fadeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                image.startAnimation(animation);
            }
        });

        slideup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
                image.startAnimation(animation);
            }
        });

        slidedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
                image.startAnimation(animation);
            }
        });
    }
}
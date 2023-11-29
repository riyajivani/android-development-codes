package com.example.cameraaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoCapture extends AppCompatActivity {

    VideoView video;
    Button capture,go_on_image;

    Intent intent;
    protected static final int Video_Capture_code=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_capture);

        video=(VideoView) findViewById(R.id.videoview);
        capture=(Button) findViewById(R.id.videoButton);
        go_on_image=(Button)findViewById(R.id.videoButton2);

        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cInt = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                //noinspection deprecation
                startActivityForResult(cInt,Video_Capture_code);
            }
        });

        go_on_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent= new Intent(VideoCapture.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==Video_Capture_code)
        {
            if(resultCode==RESULT_OK)
            {
                Uri videoUri = data.getData();
                // Display the captured video in a video player (example)
                video.setVideoURI(videoUri);
                video.start();
            }
            else
            {
                Toast.makeText(this, "canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
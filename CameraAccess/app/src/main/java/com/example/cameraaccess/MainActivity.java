package com.example.cameraaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Button click,go_on_video;
    protected static final int Image_Capture_code=1;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image=(ImageView) findViewById(R.id.imageView);
        click=(Button) findViewById(R.id.button);
        go_on_video=(Button)findViewById(R.id.button1);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //noinspection deprecation
                startActivityForResult(cInt,Image_Capture_code);
            }
        });

        go_on_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent= new Intent(MainActivity.this,VideoCapture.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==Image_Capture_code)
        {
            if(resultCode==RESULT_OK)
            {
                Bitmap bp = (Bitmap) data.getExtras().get("data");
                image.setImageBitmap(bp);
                //MediaStore.Images.Media.insertImage(getContentResolver(),bp,"image","image info");
            }
            else
            {
                Toast.makeText(this, "canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
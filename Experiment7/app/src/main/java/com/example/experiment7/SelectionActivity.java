package com.example.experiment7;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class SelectionActivity extends AppCompatActivity {

    Button music,asynk;
    MediaPlayer mp;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        music = (Button) findViewById(R.id.music);
        asynk = (Button) findViewById(R.id.asynktask);

        mp=new MediaPlayer();
        mp=MediaPlayer.create(SelectionActivity.this,R.raw.dil_ibadat_instrumental);

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying())
                {
                    pauseMusic();
                }
                else {
                    playMusic();
                }

            }
        });

        asynk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(SelectionActivity.this,AsynkTaskActivity.class);
                startActivity(intent);
            }
        });
    }

    public void playMusic()
    {
        if(mp!=null)
        {
            mp.start();
            music.setText("pause music");
        }
    }

    public void pauseMusic()
    {
        if(mp!=null)
        {
            mp.pause();
            music.setText("play music");
        }
    }
}
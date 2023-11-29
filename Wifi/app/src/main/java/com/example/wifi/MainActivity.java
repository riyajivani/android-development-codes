package com.example.wifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button on, off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        on = (Button) findViewById(R.id.on);
        off = (Button) findViewById(R.id.off);

        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!wm.isWifiEnabled())
                    wm.setWifiEnabled(true);
                else {
                    Toast.makeText(MainActivity.this, "wifi is already on", Toast.LENGTH_SHORT).show();
                }
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wm.isWifiEnabled())
                    wm.setWifiEnabled(false);
                else {
                    Toast.makeText(MainActivity.this, "wifi is already off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
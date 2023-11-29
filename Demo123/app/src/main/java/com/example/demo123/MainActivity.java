package com.example.demo123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("activity","create");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("activity","destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("activity","start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("activity","stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("activity","restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("activity","pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("activity","resume");
    }
}


//1> currently i am in this activity and sudden phone call is coming and i receive the phone call i'll return to my this activity.
//so sequence will be oncreate->onstart->onresume->onpause->onstop->onstart->onresume

//2> now i'm closing the tab of this activity.
//onpause->onstop->destroy
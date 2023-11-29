package com.example.musicplayer;

import android.app.ActionBar;
import android.app.Activity;

public class MyActionBar {
    private Activity activity;

    public MyActionBar(Activity activity) {
        this.activity = activity;
    }

    public void setupActionBar(String title,String subtitle) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);

            actionBar.setIcon(R.drawable.baseline_headphones_24);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle(title);
            actionBar.setSubtitle(subtitle);
        }
    }
}

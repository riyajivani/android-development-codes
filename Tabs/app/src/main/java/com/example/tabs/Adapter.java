package com.example.tabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tabs.Fragments.Home;
import com.example.tabs.Fragments.Message;
import com.example.tabs.Fragments.Setting;

public class Adapter extends FragmentStateAdapter {

    public Adapter(@NonNull MainActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position)
        {
            case 0:
                return new Home();
            case 1:
                return new Setting();
            case 2:
                return new Message();
            default:
                return new Home();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

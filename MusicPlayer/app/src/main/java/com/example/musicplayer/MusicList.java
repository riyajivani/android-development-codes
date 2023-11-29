package com.example.musicplayer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;


public class MusicList extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_music_list);


        DBHandler db = new DBHandler(this);

        db.addMusic(String.valueOf(R.string.Shiddat));
        db.addMusic(String.valueOf(R.string.Tumsehi));
        db.addMusic(String.valueOf(R.string.WorthNothing));
        db.addMusic(String.valueOf(R.string.Senorita));
        db.addMusic(String.valueOf(R.string.DatingMyself));
        db.addMusic(String.valueOf(R.string.AeDilHaiMUshkil));
        db.addMusic(String.valueOf(R.string.banzara));
        db.addMusic(String.valueOf(R.string.Barbaadiyan));
        db.addMusic(String.valueOf(R.string.DilIbadat));
        db.addMusic(String.valueOf(R.string.ishqWalaLove));
        db.addMusic(String.valueOf(R.string.JabKioBaat));
        db.addMusic(String.valueOf(R.string.OmSantiOm));
        db.addMusic(String.valueOf(R.string.SanamTeriKasam));
        db.addMusic(String.valueOf(R.string.TeraChehra));
        db.addMusic(String.valueOf(R.string.Unstoppable));


        List<HashMap<String,String>> musicList = db.GetMusic();
        ListView lv = (ListView) findViewById(R.id.music_list);
        ListAdapter adapter = new SimpleAdapter(MusicList.this, musicList, R.layout.list_row,new String[]{"name"},new int[] {R.id.musicname});
        lv.setAdapter(adapter);


    }
}
package com.example.musicplayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MusicPlayerDB";
    private static final String TABLE_MUSIC = "music";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MUSIC_TABLE = "CREATE TABLE " + TABLE_MUSIC + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT)";
        db.execSQL(CREATE_MUSIC_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MUSIC);
        onCreate(db);
    }

    public void addMusic(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);

        db.insert(TABLE_MUSIC, null, values);
        db.close();
    }
    public List<HashMap<String, String>> GetMusic() {
        List<HashMap<String, String>> musicList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_MUSIC;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> music = new HashMap<>();
                music.put("id", cursor.getString(0));
                music.put("name", cursor.getString(1));
                musicList.add(music);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return musicList;
    }
}

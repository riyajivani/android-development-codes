package com.example.ses1_que3b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "studentData";
    private static final String COLUMN_STUDENT_ID = "Student_Id";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_ENROLLMENT = "Enrollment";
    private static final String COLUMN_SEM = "Sem";

    // Constructor
    public DBHelper(Context context) {  //Context context: This parameter is crucial because it provides the context of your Android application. It's needed for the SQLiteOpenHelper to locate or create the database in the appropriate application directory. Typically, you'll pass in an Activity or Application context when creating an instance of this helper class.
        super(context, DATABASE_NAME, null, DATABASE_VERSION); //null: The cursor factory parameter is typically used when you want to customize the behavior of cursors. By passing null, you indicate that you're using the default cursor behavior provided by Android, which is suitable for most cases
    } //DATABASE_VERSION: This is an integer constant that represents the version of the database. It's important to increment this version when you make changes to the database schema (e.g., adding or modifying tables and columns). When the database version changes, the onUpgrade method is called to update the schema if needed.

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the studentData table
        String createTableSQL = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_ENROLLMENT + " TEXT, " +
                COLUMN_SEM + " INTEGER);";
        db.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades (if needed)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method to insert a new student
    public long insertStudent(String name, String enrollment, int sem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_ENROLLMENT, enrollment);
        values.put(COLUMN_SEM, sem);

        // Insert the row
        long newRowId = db.insert(TABLE_NAME, null, values);
        db.close();
        return newRowId;
    }

    // Method to load student data
    public Cursor loadStudent() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_STUDENT_ID, COLUMN_NAME, COLUMN_ENROLLMENT, COLUMN_SEM};
        Cursor cursor = db.query(TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }
}

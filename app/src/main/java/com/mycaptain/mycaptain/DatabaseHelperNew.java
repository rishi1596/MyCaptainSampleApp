package com.mycaptain.mycaptain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelperNew extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "local_database";
    private static final String TABLE_PERSON_DETAILS = "person_details";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";


    public DatabaseHelperNew(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PERSON_DETAILS_TABLE = "CREATE TABLE " + TABLE_PERSON_DETAILS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT " + ")";
        db.execSQL(CREATE_PERSON_DETAILS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String addRecord(String personName) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, personName);

        long id = db.insert(TABLE_PERSON_DETAILS, null, values);
        db.close();

        return String.valueOf(id);
    }

    public void deleteRecord(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PERSON_DETAILS, KEY_ID + " = ?",
                new String[] { String.valueOf(id) }); //int to string
        db.close();
    }

    public int updatePerson(int id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);

        // updating row
        return db.update(TABLE_PERSON_DETAILS, values, KEY_ID + " = ?" ,
                new String[] { String.valueOf(id) });
    }

    public String getPerson(int id) {
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(TABLE_PERSON_DETAILS, new String[] { KEY_NAME }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        return cursor.getString(0);


    }

    public ArrayList<String> getAllPersons() {
        ArrayList<String> personList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT " + KEY_NAME + " FROM " + TABLE_PERSON_DETAILS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                String name = cursor.getString(0);
                personList.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();

        // return contact list
        return personList;
    }
}

package com.example.m8_endevinanum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteManager extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "records.db";


    final String crearTaula = "CREATE TABLE records (nom TEXT NOT NULL PRIMARY KEY, intents INTEGER)";

    public SQLiteManager(Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crearTaula);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
/*
        db.execSQL("DROP TABLE IF EXISTS records");
        onCreate(db);
*/
    }

    public boolean insertarDades(String nom, int intents) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("nom",nom);
        cv.put("intents",intents);

        System.out.println("lololol");

        long prova = db.insert("records",null,cv);

        if (prova > 0) return true;
        else return false;
    }

    public Cursor getDades() {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("SELECT * FROM records ORDER BY intents DESC",null);
    }
}

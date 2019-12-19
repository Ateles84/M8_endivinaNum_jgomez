package com.example.m8_endevinanum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.sql.PreparedStatement;

public class SQLiteManager extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "records.db";


    final String crearTaula = "CREATE TABLE records (nom TEXT NOT NULL PRIMARY KEY, intents INTEGER, imatge BLOB)";

    public SQLiteManager(Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crearTaula);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS records");
        onCreate(db);

    }

    public boolean insertarDades(String nomm, int intents, Bitmap bmap) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        PreparedStatement ps = null;

        String query = "SELECT nom FROM records WHERE nom = ?";

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        cv.put("nom",nomm);
        cv.put("intents",intents);
        cv.put("imatge", byteArray);

        db = this.getWritableDatabase();

        Cursor c = db.rawQuery(("SELECT nom FROM records WHERE nom = \" " + nomm+ "\""),null);

        if (c.getCount() > 0) {
            db.delete("records",("nom = \" "+nomm+"\""),null);
        }

        System.out.println("lololol");

        long prova = db.insert("records",null,cv);

        if (prova > 0) return true;
        else return false;
    }

    public Cursor getDades() {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("SELECT * FROM records ORDER BY intents ASC",null);
    }

}

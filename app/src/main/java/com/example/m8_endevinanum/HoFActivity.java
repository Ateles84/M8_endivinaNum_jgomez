package com.example.m8_endevinanum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class HoFActivity extends AppCompatActivity {

    TextView txtNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_f);

        Intent prova = getIntent();

        Button tornaBtn = findViewById(R.id.tornaMain);

        ListView lv = findViewById(R.id.llistaRecord);

        SQLiteManager sql = new SQLiteManager(this, SQLiteManager.DATABASE_NAME, null, SQLiteManager.DATABASE_VERSION);

        Cursor c = sql.getDades();

        ArrayList<Jugador> ar = new ArrayList<Jugador>();

        if (c.getCount() == 0) {

        } else {
            int i = 1;
            while (c.moveToNext()) {
                byte[] barr = c.getBlob(c.getColumnIndex("imatge"));
                ar.add(new Jugador((i++) + ". " + c.getString(c.getColumnIndex("nom")) + " -- "
                        + c.getInt(c.getColumnIndex("intents")), BitmapFactory.decodeByteArray(barr, 0, barr.length)));
                Log.v("eio ","Esto es una "+i);
            }
        }

        CustomAdapter ara = new CustomAdapter(ar, this);

        lv.setAdapter(ara);

        c.close();
    }

    public void clickBtnTorna(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


}

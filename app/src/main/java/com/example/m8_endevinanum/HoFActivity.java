package com.example.m8_endevinanum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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

        SQLiteManager sql = new SQLiteManager(this,SQLiteManager.DATABASE_NAME,null,SQLiteManager.DATABASE_VERSION);

        Cursor c = sql.getDades();

        ArrayList<String> ar = new ArrayList<String>();

        if (c.getCount() == 0) {

        } else {
            int i = 1;
            while (c.moveToNext()) {
                ar.add((i++)+". "+c.getString(c.getColumnIndex("nom"))+" -- "+c.getInt(c.getColumnIndex("intents")));
            }
        }

        ArrayAdapter ara = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ar);

        lv.setAdapter(ara);

        c.close();
    }

    public void clickBtnTorna(View v) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }


}

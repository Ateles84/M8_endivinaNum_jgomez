package com.example.m8_endevinanum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;

public class HoFActivity extends AppCompatActivity {

    TextView txtNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_f);

        Intent prova = getIntent();

        Button tornaBtn = findViewById(R.id.tornaMain);

        txtNom = findViewById(R.id.Podio);

        txtNom.setText("");

        txtNom.setFocusable(false);

        SQLiteManager sql = new SQLiteManager(this,SQLiteManager.DATABASE_NAME,null,SQLiteManager.DATABASE_VERSION);

        Cursor c = sql.getDades();


        if (c.getCount() == 0) {

        } else {
            int i = 1;
            while (c.moveToNext()) {
                txtNom.setText(txtNom.getText().toString()+"\n"+(i++) + ". "+c.getString(0)+" -- "+c.getInt(1));
            }
        }



    }

    public void clickBtnTorna(View v) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }


}
